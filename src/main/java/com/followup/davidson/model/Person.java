package com.followup.davidson.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;


@Entity
@Table(name="person")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter @Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="person_id")

    private Long personId;

    @NotEmpty
    @Column(unique = true)
    private String firstName;



    @NotEmpty
    private String lastName;

    @OneToMany(mappedBy = "person",   cascade = CascadeType.ALL)
    private List<TJ> TJs;
/*
    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Intervention> interventions;

*/
}
