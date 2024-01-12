package cs127.springappbe.Entities.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class AvailServiceRequest {

    @JsonProperty("service_id")
    private int serviceID;

    @JsonProperty("quantity")
    private int quantity;

}
