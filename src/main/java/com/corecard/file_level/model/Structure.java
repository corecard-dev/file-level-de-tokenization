package com.corecard.file_level.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Structure {

    private LineBody lineBody;
    private LineSplitedBody lineSplitedBody;

}
