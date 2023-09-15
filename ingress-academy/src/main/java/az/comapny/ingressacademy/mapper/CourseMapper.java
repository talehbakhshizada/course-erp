package az.comapny.ingressacademy.mapper;

import az.comapny.ingressacademy.dao.entity.CourseEntity;
import az.comapny.ingressacademy.model.enums.CourseStatus;
import az.comapny.ingressacademy.model.request.SaveCourseRequest;
import az.comapny.ingressacademy.model.request.UpdateCourseRequest;
import az.comapny.ingressacademy.model.response.CourseResponse;

import java.util.stream.Collectors;

public class CourseMapper {
    public static CourseEntity mapToCourseEntity(SaveCourseRequest request){
        return CourseEntity.builder()
                .name(request.getName())
                .courseStatus(CourseStatus.OPEN)
                .build();
    }

    public static CourseResponse mapToCourseResponse(CourseEntity entity) {
        var students = entity.getStudents().stream().map(StudentMapper::mapToStudentResponse).collect(Collectors.toList());

        return CourseResponse.builder()
                .name(entity.getName())
                .students(students)
                .build();
    }

    public static void updateCourse(CourseEntity entity, UpdateCourseRequest request) {
        entity.setName(request.getName());
    }
}
