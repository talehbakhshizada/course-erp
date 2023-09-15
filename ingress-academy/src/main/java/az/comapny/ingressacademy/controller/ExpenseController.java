package az.comapny.ingressacademy.controller;

import az.comapny.ingressacademy.model.request.SaveExpenseRequest;
import az.comapny.ingressacademy.service.ExpenseService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping(consumes = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.MULTIPART_FORM_DATA_VALUE,
    })

    @ResponseStatus(HttpStatus.CREATED)
    public void createExpense(@RequestPart("request") SaveExpenseRequest request,
                              @RequestPart MultipartFile file) {
        expenseService.saveExpense(request, file);
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void uploadExpenseImage(@RequestParam("image") MultipartFile file, @PathVariable Long id) {
        expenseService.uploadExpenseImage(file, id);
    }
}
