package az.comapny.ingressacademy.controller;

import az.comapny.ingressacademy.model.request.SaveStudentRequest;
import az.comapny.ingressacademy.model.request.UpdateStudentRequest;
import az.comapny.ingressacademy.model.response.StudentResponse;
import az.comapny.ingressacademy.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<StudentResponse> getAllStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/{id}")
    public StudentResponse getStudent(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/phone-number")
    public StudentResponse getBookByPhoneNumber(@RequestParam String phoneNumber) {
        return studentService.getStudentByPhoneNumber(phoneNumber);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@RequestBody SaveStudentRequest request) {
        studentService.saveStudent(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void updateStudent(@PathVariable Long id, @RequestBody UpdateStudentRequest request) {
        studentService.updateStudent(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
