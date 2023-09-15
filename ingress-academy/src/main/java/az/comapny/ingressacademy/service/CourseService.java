package az.comapny.ingressacademy.service;

import az.comapny.ingressacademy.dao.entity.CourseEntity;
import az.comapny.ingressacademy.exception.NotFoundException;
import az.comapny.ingressacademy.mapper.CourseMapper;
import az.comapny.ingressacademy.model.request.SaveCourseRequest;
import az.comapny.ingressacademy.model.request.UpdateCourseRequest;
import az.comapny.ingressacademy.model.response.CourseResponse;
import az.comapny.ingressacademy.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static az.comapny.ingressacademy.mapper.CourseMapper.mapToCourseEntity;
import static az.comapny.ingressacademy.mapper.CourseMapper.mapToCourseResponse;
import static az.comapny.ingressacademy.model.constants.ErrorMessages.COURSE_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseResponse getCourseById(Long id) {
        var course = fetchCourseIfExist(id);
        return mapToCourseResponse(course);
    }

    public List<CourseResponse> getCourses(){
        return courseRepository.findAll()
                .stream()
                .map(CourseMapper::mapToCourseResponse)
                .collect(Collectors.toList());
    }

//    public void addStudentToCourse(Long id, SaveStudentRequest request){ // TODO Fix it
//        var course = fetchBookIfExist(id);
//        var students = course.getStudents();
//
//        students.add(StudentMapper.mapToStudentEntity(request));
//        course.setStudents(students);
//
//        courseRepository.save(course);
//    }

    public void saveCourse(SaveCourseRequest saveCourseRequest) {
        courseRepository.save(mapToCourseEntity(saveCourseRequest));
    }

    public void updateCourse(Long id, UpdateCourseRequest request) {
        var course = fetchCourseIfExist(id);
        CourseMapper.updateCourse(course,request);
        courseRepository.save(course);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    private CourseEntity fetchCourseIfExist(Long id) {
        return courseRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.valueOf(COURSE_NOT_FOUND),
                        String.format(COURSE_NOT_FOUND.getMessage(), id))
        );
    }
}
