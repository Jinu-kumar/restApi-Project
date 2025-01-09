package in.Project.RestApi.controller;

import in.Project.RestApi.dto.ExpenseDTO;
import in.Project.RestApi.io.ExpenseResponse;
import in.Project.RestApi.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ExpenseController {

    private final ExpenseService expenseService;
    private final ModelMapper modelMapper;
    @GetMapping("/expenses")
    public List<ExpenseResponse> getExpenses()
    {
        log.info("API get /expenses called");
        List<ExpenseDTO> list= expenseService.getAllExpenses();
        log.info("Printing the data from service{}", list);

        List<ExpenseResponse> response=list.stream().map(expenseDTO -> mapToExpenseResponse(expenseDTO)).collect(Collectors.toList());
        
        return response;
    }

    private ExpenseResponse mapToExpenseResponse(ExpenseDTO expenseDTO) {
        return modelMapper.map(expenseDTO,ExpenseResponse.class);
    }
}
