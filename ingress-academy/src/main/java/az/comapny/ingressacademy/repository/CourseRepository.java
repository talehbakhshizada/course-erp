package az.comapny.ingressacademy.repository;

import az.comapny.ingressacademy.dao.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseEntity,Long> {
}
