package lk.ijse.coworkhub.dto;

import javafx.scene.image.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Member {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private Date dob;
    private int age;
    private String profession;
    private double loyalty;
    private String phone;
    private String emergencyContact;
    private Image memberPic;
}
