package com.followup.davidson.model;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name="project")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
/**
 * Project est la classe represetant un Project chez Davidson
 */
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long projectId;

    @NotEmpty
    private String projectName;

    /**
     * C'est le client de chaque projet
     */
    @ManyToOne(fetch = FetchType.EAGER, optional = false,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "client_id")
    private Client client;

}
