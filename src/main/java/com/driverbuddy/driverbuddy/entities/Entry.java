package com.driverbuddy.driverbuddy.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "entries")
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer km;
    private Float ridesIncome;
    private Float tipsIncome;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate date;
    private Float gasCons;
    private Float gasPrice;
    private Integer noRides;
    private Integer noHours;
}
