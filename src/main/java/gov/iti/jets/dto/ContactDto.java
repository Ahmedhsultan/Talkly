package gov.iti.jets.dto;

import lombok.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ContactDto implements Serializable {
    private String phoneNumber;
    private String name;
    private String picture;
    private String isOnlineStatus;
}
