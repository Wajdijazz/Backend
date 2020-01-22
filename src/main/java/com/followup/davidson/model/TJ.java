package com.followup.davidson.model;




import lombok.*;

import javax.persistence.*;


@Entity
@Table(name="tj")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter @Setter
public class TJ {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String  tarif;

    @ManyToOne
    @JoinColumn(name="person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name="project_id")
    private Project project;

}
