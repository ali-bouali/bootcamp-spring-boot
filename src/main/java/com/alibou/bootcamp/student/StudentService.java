package com.alibou.bootcamp.student;

import java.util.List;

public interface StudentService {

  Student save(Student s);

  Student update(Student s);

  Student findById(Integer id);

  List<Student> findAll();

  void delete(Integer id);

}
