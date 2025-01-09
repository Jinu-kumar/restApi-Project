package in.Project.RestApi.io;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ExpenseRequest {
    private String name;
    private String note;
    private String category;
    private BigDecimal amount;
    private Date date;
}
