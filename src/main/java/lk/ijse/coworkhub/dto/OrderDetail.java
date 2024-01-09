package lk.ijse.coworkhub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetail {

    private String orderId;
    private String beverageId;
    private String memberId;
    private int qty;
    private Date orderDate;
}
