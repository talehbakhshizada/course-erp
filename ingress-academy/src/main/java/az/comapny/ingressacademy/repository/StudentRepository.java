package az.comapny.ingressacademy.repository;

import az.comapny.ingressacademy.dao.entity.StudentEntity;
import az.comapny.ingressacademy.model.response.StudentResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
    StudentResponse findByPhoneNumber(String  phoneNumber);
}
