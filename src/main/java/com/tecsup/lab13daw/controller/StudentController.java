package com.tecsup.lab13daw.controller;

import com.tecsup.lab13daw.model.Student;
import com.tecsup.lab13daw.model.Course;
import com.tecsup.lab13daw.repository.StudentRepository;
import com.tecsup.lab13daw.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {
    
    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private CourseRepository courseRepository;
    
    // GET /api/students - Lista todos los estudiantes
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return ResponseEntity.ok(students);
    }
    
    // GET /api/students/{id} - Obtiene un estudiante por ID con sus cursos
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentRepository.findByIdWithCourses(id);
        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    // POST /api/students - Crea un nuevo estudiante
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student savedStudent = studentRepository.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }
    
    // PUT /api/students/{id} - Actualiza un estudiante
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setName(studentDetails.getName());
            student.setEmail(studentDetails.getEmail());
            Student updatedStudent = studentRepository.save(student);
            return ResponseEntity.ok(updatedStudent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    // DELETE /api/students/{id} - Elimina un estudiante
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    // POST /api/students/{studentId}/courses/{courseId} - Asigna un curso a un estudiante
    @PostMapping("/{studentId}/courses/{courseId}")
    public ResponseEntity<Student> assignCourseToStudent(@PathVariable Long studentId, @PathVariable Long courseId) {
        Student student = studentRepository.findByIdWithCourses(studentId);
        Optional<Course> courseOpt = courseRepository.findById(courseId);
        
        if (student != null && courseOpt.isPresent()) {
            Course course = courseOpt.get();
            student.addCourse(course);
            Student updatedStudent = studentRepository.save(student);
            return ResponseEntity.ok(updatedStudent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    // DELETE /api/students/{studentId}/courses/{courseId} - Elimina un curso de un estudiante
    @DeleteMapping("/{studentId}/courses/{courseId}")
    public ResponseEntity<Student> removeCourseFromStudent(@PathVariable Long studentId, @PathVariable Long courseId) {
        Student student = studentRepository.findByIdWithCourses(studentId);
        Optional<Course> courseOpt = courseRepository.findById(courseId);
        
        if (student != null && courseOpt.isPresent()) {
            Course course = courseOpt.get();
            student.removeCourse(course);
            Student updatedStudent = studentRepository.save(student);
            return ResponseEntity.ok(updatedStudent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

