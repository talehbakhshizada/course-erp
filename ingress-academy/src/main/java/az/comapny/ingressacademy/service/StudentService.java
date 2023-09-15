package az.comapny.ingressacademy.service;

import az.comapny.ingressacademy.dao.entity.StudentEntity;
import az.comapny.ingressacademy.exception.NotFoundException;
import az.comapny.ingressacademy.mapper.StudentMapper;
import az.comapny.ingressacademy.model.request.SaveStudentRequest;
import az.comapny.ingressacademy.model.request.UpdateStudentRequest;
import az.comapny.ingressacademy.model.response.StudentResponse;
import az.comapny.ingressacademy.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static az.comapny.ingressacademy.mapper.StudentMapper.*;
import static az.comapny.ingressacademy.model.constants.ErrorMessages.STUDENT_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<StudentResponse> getStudents(){
        return studentRepository.findAll()
                .stream()
                .map(StudentMapper::mapToStudentResponse)
                .collect(Collectors.toList());
    }

    public StudentResponse getStudentById(Long id) {
        var student = fetchStudentIfExist(id);
        return mapToStudentResponse(student);
    }

    public StudentResponse getStudentByPhoneNumber(String phoneNumber) {
       return studentRepository.findByPhoneNumber(phoneNumber);
    }

    public void saveStudent(SaveStudentRequest studentRequest) {
        studentRepository.save(mapToStudentEntity(studentRequest));
    }

    public void updateStudent(Long id, UpdateStudentRequest studentRequest) {
        var student = fetchStudentIfExist(id);
        StudentMapper.updateStudent(student, studentRequest);
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    private StudentEntity fetchStudentIfExist(Long id) {
        return studentRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.valueOf(STUDENT_NOT_FOUND),
                        String.format(STUDENT_NOT_FOUND.getMessage(), id))
        );
    }
}
