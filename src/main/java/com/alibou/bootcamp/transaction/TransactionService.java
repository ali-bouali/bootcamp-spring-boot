package com.alibou.bootcamp.transaction;

import com.alibou.bootcamp.validator.ObjectsValidator;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {

  private final TransactionRepository repository;
  private final ObjectsValidator<TransactionRequest> validator;
  private final TransactionMapper mapper;

  public Integer create(TransactionRequest request) {
    validator.validate(request);
    var transaction = mapper.toTransaction(request);
    var multiplier = BigDecimal.valueOf(getTransactionMultiplier(request.getType()));
    var amountToSave = request.getAmount().multiply(multiplier);
    transaction.setAmount(amountToSave);
    return repository.save(transaction).getId();
  }

  public List<TransactionResponse> findAllByUser(Integer userId) {
    return repository.findAllByUserId(userId)
        .stream()
        .map(mapper::toResponse)
        .collect(Collectors.toList());
  }

  private int getTransactionMultiplier(TransactionType type) {
    return  TransactionType.TRANSFERT == type ? -1 : 1;
  }
}
