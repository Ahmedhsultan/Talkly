package gov.iti.jets.server.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ChatUser implements BaseEntity{
    private int chat_id;
    private String user_id;
}