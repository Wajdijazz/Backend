package com.followup.davidson.model;

import lombok.*;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DataSet {

    private List<PersonDto> persons;
    private ProjectDto project;


}
