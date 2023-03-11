package com.alibou.bootcamp.student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryStudentRepository {

  private static final List<Student> students = new ArrayList<>();

  public Student saveToMemory(Student s) {
    students.add(s);
    return s;
  }

  public Student updateInMemory(Student s) {
    var studentIndex = IntStream
        .range(0, students.size())
        .filter(index -> students.get(index).getId().equals(s.getId()))
        .findFirst()
        .orElse(-1);
    if (studentIndex > -1) {
      students.set(studentIndex, s);
      return s;
    }
    return null;
  }

  public Student findByIdInMemory(Integer id) {
    return students
        .stream()
        .filter(st -> st.getId().equals(id))
        .findFirst()
        .orElse(null)
        ;
  }

  public List<Student> findAllInMemory() {
    return students;
  }

  public void deleteFromMemory(Integer id) {
    var student = findByIdInMemory(id);
    students.remove(student);
  }

}
