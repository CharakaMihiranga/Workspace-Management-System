package lk.ijse.coworkhub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservationDTO {
    private String id;
    private String packageId;
    private String workspaceId;
    private Date reservedDate;
    private double totalPrice;
}
