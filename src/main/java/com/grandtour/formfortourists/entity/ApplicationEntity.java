package com.grandtour.formfortourists.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "application", schema = "grand_tour")
public class ApplicationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    private String preferences;
    private int numberOfAdults;
    private int numberOfChildren;
    private String ageOfChildren;
    private int numberOfNights;
    private int budget;

    private LocalDate startDate;
}
