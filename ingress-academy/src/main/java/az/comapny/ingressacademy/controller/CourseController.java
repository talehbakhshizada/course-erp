package az.comapny.ingressacademy.controller;

import az.comapny.ingressacademy.model.request.SaveCourseRequest;
import az.comapny.ingressacademy.model.request.SaveStudentRequest;
import az.comapny.ingressacademy.model.request.UpdateCourseRequest;
import az.comapny.ingressacademy.model.response.CourseResponse;
import az.comapny.ingressacademy.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/courses")
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public List<CourseResponse> getCourses() {
        return courseService.getCourses();
    }

    @GetMapping("/{id}")
    public CourseResponse getCourse(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createBook(@RequestBody SaveCourseRequest request) {
        courseService.saveCourse(request);
    }

//    @PostMapping("/add-student/{id}")
//    @ResponseStatus(HttpStatus.CREATED)
//    public void addStudentToCourse(@PathVariable Long id, @RequestBody SaveStudentRequest request) {
//        courseService.addStudentToCourse(id, request);
//    }

    @PutMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void updateBook(@PathVariable Long id, @RequestBody UpdateCourseRequest request) {
        courseService.updateCourse(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteBook(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }

}
