package com.followup.davidson.model;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PersonDto {
    private Long personId;
    private  String name;
    private  double worked;
    private  double price;
}
