package in.Project.RestApi.service.impl;

import in.Project.RestApi.dto.ExpenseDTO;
import in.Project.RestApi.entity.ExpenseEntity;
import in.Project.RestApi.repository.ExpenseRepository;
import in.Project.RestApi.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@CrossOrigin("*")
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<ExpenseDTO> getAllExpenses() {
        List<ExpenseEntity> list= expenseRepository.findAll();
        log.info("Printing the data from list{}",list);
        List<ExpenseDTO> listofExpenses =list.stream().map(expenseEntity -> mapToExpenseDTO(expenseEntity)).collect(Collectors.toList());

        return listofExpenses;
    }

    private ExpenseDTO mapToExpenseDTO(ExpenseEntity expenseEntity) {
        return modelMapper.map(expenseEntity,ExpenseDTO.class);
    }
}
