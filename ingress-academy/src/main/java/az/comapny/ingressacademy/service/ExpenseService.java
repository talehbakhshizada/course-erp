package az.comapny.ingressacademy.service;

import az.comapny.ingressacademy.dao.entity.ExpenseEntity;
import az.comapny.ingressacademy.exception.NotFoundException;
import az.comapny.ingressacademy.model.request.SaveExpenseRequest;
import az.comapny.ingressacademy.repository.ExpenseRepository;
import az.comapny.ingressacademy.util.ImageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

import static az.comapny.ingressacademy.mapper.ExpenseMapper.mapToExpenseToEntity;
import static az.comapny.ingressacademy.model.constants.ErrorMessages.EXPENSE_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    @Transactional
    public void saveExpense(SaveExpenseRequest saveExpenseRequest, MultipartFile file) {
        var expense = mapToExpenseToEntity(saveExpenseRequest);
        try {
            expense.setImageData(ImageUtil.compressImage(file.getBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        expenseRepository.save(expense);

    }

    public void uploadExpenseImage(MultipartFile file, Long id) {
        var expense = fetchExpenseIfExist(id);
        try {
            expense.setImageData(ImageUtil.compressImage(file.getBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        expenseRepository.save(expense);
    }

    private ExpenseEntity fetchExpenseIfExist(Long id) {
        return expenseRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.valueOf(EXPENSE_NOT_FOUND),
                        String.format(EXPENSE_NOT_FOUND.getMessage(), id))
        );
    }


}
