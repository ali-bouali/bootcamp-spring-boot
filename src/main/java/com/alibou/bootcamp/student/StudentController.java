package com.alibou.bootcamp.student;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

  private final StudentService service;

  @PostMapping
  public Student save(
      @RequestBody Student s
  ) {
    return  service.save(s);
  }

  @PutMapping
  public Student update(
      @RequestBody Student s
  ) {
    return  service.update(s);
  }

  @GetMapping("/{id}")
  public Student findById(
      @PathVariable("id") Integer idStudent
  ) {
    return service.findById(idStudent);
  }

  @GetMapping
  public List<Student> findAll() {
    return service.findAll();
  }

  @DeleteMapping("/{id}")
  public void delete(
      @PathVariable("id") Integer id
  ) {
    service.delete(id);
  }

}
