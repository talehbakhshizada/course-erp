package az.comapny.ingressacademy.model.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorMessages {

    UNEXPECTED_ERROR("Something went wrong "),

    STUDENT_NOT_FOUND("Student not found with ID: %s "),

    COURSE_NOT_FOUND("Course not found with ID: %s"),

    EXPENSE_NOT_FOUND("Expense not found with ID: %s");

    private final String message;
}
