package com.followup.davidson.model;



import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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
    private Date startdate;

    @Column(name ="endDate")
    private Date endDate;

    private long worked;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;


}
