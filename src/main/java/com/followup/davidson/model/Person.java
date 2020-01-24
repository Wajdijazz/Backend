package com.followup.davidson.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String firstName;
    @NotEmpty
    private String lastName;



   @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
    private List<Intervention> interventions;

//    @ManyToOne
//    @JoinColumn(name="manager_id")
//    @JsonIgnore
//    private Manager manager;

}
