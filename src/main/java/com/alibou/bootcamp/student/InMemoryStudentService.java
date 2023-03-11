package com.alibou.bootcamp.student;


import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InMemoryStudentService implements StudentService {

  private final InMemoryStudentRepository repository;

  @Override
  public Student save(Student s) {
    return repository.saveToMemory(s);
  }

  @Override
  public Student update(Student s) {
    return repository.updateInMemory(s);
  }

  @Override
  public Student findById(Integer id) {
    return repository.findByIdInMemory(id);
  }

  @Override
  public List<Student> findAll() {
    return repository.findAllInMemory();
  }

  @Override
  public void delete(Integer id) {
    repository.deleteFromMemory(id);
  }
}
