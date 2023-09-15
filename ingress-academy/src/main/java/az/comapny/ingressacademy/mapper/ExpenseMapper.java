package az.comapny.ingressacademy.mapper;

import az.comapny.ingressacademy.dao.entity.ExpenseEntity;
import az.comapny.ingressacademy.model.request.SaveExpenseRequest;

import java.time.LocalDateTime;

public class ExpenseMapper {

    public static ExpenseEntity mapToExpenseToEntity(SaveExpenseRequest request){
        return ExpenseEntity.builder()
                .expenseName(request.getExpenseName())
                .amount(request.getAmount())
                .date(LocalDateTime.now())
                .text(request.getText())
                .build();
    }
}
