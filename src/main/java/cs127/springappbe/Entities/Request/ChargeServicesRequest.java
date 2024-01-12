package cs127.springappbe.Entities.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class ChargeServicesRequest {

    @JsonProperty("BRN_Code")
    private String BRNCode;

    @JsonProperty("employee_id")
    private long employeeID;

    @JsonProperty("availed_services")
    private List<AvailServiceRequest> availedServices;

}
