package com.followup.davidson.model;



import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="intervention")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Intervention {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "intervention_id")
    private Long interventionId;

    @Column(name ="startDate")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date startDate;


    @Column(name ="endDate")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date endDate;

    private long worked;
    @ManyToOne
    @JoinColumn(name = "person_id")

    private Person person;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;


}
