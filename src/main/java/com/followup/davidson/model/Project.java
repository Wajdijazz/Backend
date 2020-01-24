package com.followup.davidson.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name="project")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter @Setter
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long projectId;

    @NotEmpty
    private String projectName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "project",  cascade = CascadeType.ALL)
    private List<TJ> TJs;

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Intervention> interventions;


}
