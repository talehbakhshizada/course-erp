package az.comapny.ingressacademy.mapper;

import az.comapny.ingressacademy.dao.entity.StudentEntity;
import az.comapny.ingressacademy.model.request.SaveStudentRequest;
import az.comapny.ingressacademy.model.request.UpdateStudentRequest;
import az.comapny.ingressacademy.model.response.StudentResponse;

public class StudentMapper {

    public static StudentResponse mapToStudentResponse(StudentEntity entity) {
        return StudentResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .surname(entity.getSurname())
                .email(entity.getEmail())
                .phoneNumber(entity.getPhoneNumber())
                .build();
    }

    public static StudentEntity mapToStudentEntity(SaveStudentRequest request){
        return StudentEntity.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .build();
    }

    public static void updateStudent(StudentEntity entity, UpdateStudentRequest request){
               entity.setName(request.getName());
               entity.setSurname(request.getSurname());
               entity.setEmail(request.getEmail());
               entity.setPhoneNumber(request.getPhoneNumber());
    }

}
