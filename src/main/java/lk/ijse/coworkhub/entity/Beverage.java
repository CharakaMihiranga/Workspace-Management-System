package lk.ijse.coworkhub.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Beverage {
    private String id;
    private String name;
    private String description;
    private double Price;
}
