package lk.ijse.coworkhub.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Reservation {
    private String id;
    private String packageId;
    private String workspaceId;
    private Date reservedDate;
    private double totalPrice;
}
