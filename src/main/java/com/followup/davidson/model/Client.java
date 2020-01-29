package com.followup.davidson.model;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;


import javax.persistence.*;


@Entity
@Table(name="client")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="client_id")
    private Long clientId;

    private String clientName;

    private String clientContact;



}
