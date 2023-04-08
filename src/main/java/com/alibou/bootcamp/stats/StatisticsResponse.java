package com.alibou.bootcamp.stats;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StatisticsResponse {

    private BigDecimal highestTransfer;
    private BigDecimal highestDeposit;
    private BigDecimal accountBalance;
}
