package com.archisacademy.open.ai.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //getter ve setter oluşturdu
@AllArgsConstructor //parametreli constructor oluşturdu
@NoArgsConstructor //parametresiz constructor oluşturdu
public class Message {
    private String role;
    private String content;

}
