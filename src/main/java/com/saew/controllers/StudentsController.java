package com.saew.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saew.dto.Student;

@RestController
@RequestMapping("/students")
public class StudentsController {
    
    @Autowired
    private List<Student> students;

    @PostConstruct
    public void init() {
        students = new ArrayList<>();
        students.add(new Student(1, "Juan Pérez", "juan.perez@example.com", 3.5f));
        students.add(new Student(2, "Ana López", "ana.lopez@example.com", 3.8f));
        students.add(new Student(3, "Carlos Gómez", "carlos.gomez@example.com", 3.2f));
        students.add(new Student(4, "Laura Martínez", "laura.martinez@example.com", 3.9f));
        students.add(new Student(5, "Sofía Hernández", "sofia.hernandez@example.com", 3.4f));
        students.add(new Student(6, "Diego Jiménez", "diego.jimenez@example.com", 3.6f));
        students.add(new Student(7, "Lucía Solano", "lucia.solano@example.com", 4.0f));
        students.add(new Student(8, "Mateo Navarro", "mateo.navarro@example.com", 3.7f));
        students.add(new Student(9, "Isabella Castro", "isabella.castro@example.com", 3.3f));
        students.add(new Student(10, "Miguel Ángel Torres", "miguel.angel.torres@example.com", 3.1f));
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return students;
    }

    @GetMapping("/name/{name}")
    public List<Student> getStudentByName(@PathVariable String name) {
        return students.stream()
                .filter(student -> student.getNombre().equalsIgnoreCase(name))
                .collect(Collectors.toList());
            
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .map(student -> new ResponseEntity<>(student, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        students.add(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setNombre(updatedStudent.getNombre());
                student.setCorreoElectronico(updatedStudent.getCorreoElectronico());
                student.setGpa(updatedStudent.getGpa());
                return new ResponseEntity<>(student, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable int id) {
        boolean removed = students.removeIf(student -> student.getId() == id);
        if (removed) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}