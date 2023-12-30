package lk.ijse.coworkhub.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Workspace {
    private String id;
    private String description;
    private String availability;
    private double price;
    private String type;
    private int capacity;

}
