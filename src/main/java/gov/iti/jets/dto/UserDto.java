package gov.iti.jets.dto;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserDto implements BaseDto {
    private String id;
    private String name;
    private String email;
    private String picture;
    private String gender;
    private String country;
    private Date dateOfBirth;
    private String isOnlineStatus;
    private boolean botMode;
    private String bio;
}
