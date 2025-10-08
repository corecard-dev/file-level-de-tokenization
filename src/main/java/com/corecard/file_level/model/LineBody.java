package com.corecard.file_level.model;

import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LineBody {

    private List<String> primaryNumber;
    private List<String> accountTokenEncrypted;
    private List<String> secondNumber;
    private List<String> nameToken;
    private List<String> finalNumber;


}
