package com.followup.davidson.model;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
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
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="manager_id")
    private Long managerId;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;



}
