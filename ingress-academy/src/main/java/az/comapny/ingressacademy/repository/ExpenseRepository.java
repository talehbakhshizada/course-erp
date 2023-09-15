package az.comapny.ingressacademy.repository;

import az.comapny.ingressacademy.dao.entity.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<ExpenseEntity,Long> {
}
