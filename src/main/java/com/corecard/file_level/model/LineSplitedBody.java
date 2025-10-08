package com.corecard.file_level.model;

import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class LineSplitedBody {

    private List<String> primaryPart;
    private List<String> secondPart;



}
