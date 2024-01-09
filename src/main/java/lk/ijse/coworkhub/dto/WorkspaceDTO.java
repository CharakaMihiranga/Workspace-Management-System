package lk.ijse.coworkhub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WorkspaceDTO {
    private String id;
    private String description;
    private String availability;
    private double price;
    private String type;
    private int capacity;

}
