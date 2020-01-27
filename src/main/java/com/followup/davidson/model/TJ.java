package com.followup.davidson.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    private double  tarif;

    @ManyToOne
    @JoinColumn(name="person_id")
    @OnDelete(action = OnDeleteAction.CASCADE)

    private Person person;

    @ManyToOne
    @JoinColumn(name="project_id")
    @OnDelete(action = OnDeleteAction.CASCADE)

    private Project project;

}
