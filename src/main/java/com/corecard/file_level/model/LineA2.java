package com.corecard.file_level.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LineA2 {

    private String primaryNumber;
    private String accountTokenEncrypted;
    private String secondNumber;
    private String nameToken;
    private String finalNumber;


}
