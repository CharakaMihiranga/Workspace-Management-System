package lk.ijse.coworkhub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PackageDTO {
    private String packageId;
    private String packageName;
    private String description;
    private double packagePrice;
}
