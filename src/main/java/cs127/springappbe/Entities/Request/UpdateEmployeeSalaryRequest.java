package cs127.springappbe.Entities.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class UpdateEmployeeSalaryRequest {
    @JsonProperty("emp_id")
    private Long employeeID;

    @JsonProperty("salary")
    private String salary;

}
