package lk.ijse.coworkhub.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
    private String id;
    private String name;
    private String address;
    private int tel;
    private String email;
    private String position;
}
