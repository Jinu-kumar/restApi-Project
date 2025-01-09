package in.Project.RestApi.service;

import in.Project.RestApi.dto.ExpenseDTO;

import java.util.List;

public interface ExpenseService {
    List<ExpenseDTO> getAllExpenses();
}
