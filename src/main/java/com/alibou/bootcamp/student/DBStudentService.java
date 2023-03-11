package com.alibou.bootcamp.student;


import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Primary
public class DBStudentService implements StudentService {

  private final StudentRepository repository;

  @Override
  public Student save(Student s) {
    return repository.save(s);
  }

  @Override
  public Student update(Student s) {
    return repository.save(s);
  }

  @Override
  public Student findById(Integer id) {
    return repository.findById(id)
        .orElse(null)
        ;
  }

  @Override
  public List<Student> findAll() {
    return repository.findAll();
  }

  @Override
  public void delete(Integer id) {
    repository.deleteById(id);
  }
}
