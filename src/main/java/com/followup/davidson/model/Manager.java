package com.followup.davidson.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name="manager")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter @Setter
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="manager_id")
    private Long managerId;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;

//    @OneToMany(mappedBy = "manager",  fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<Person> persons;


}
