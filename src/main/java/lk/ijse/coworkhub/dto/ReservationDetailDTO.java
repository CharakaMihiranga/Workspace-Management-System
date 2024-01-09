package lk.ijse.coworkhub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservationDetailDTO {

    private String reservationId;
    private String memberId;
    private String memberName;
    private String packageName;
    private String workspaceId;
    private String workspaceType;

}
