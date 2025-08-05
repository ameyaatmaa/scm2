package com.scm.scm2.helpers;


import lombok.*;
import lombok.Builder.Default;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private String content;

    @Default
    private MessageType type=MessageType.blue;

}
