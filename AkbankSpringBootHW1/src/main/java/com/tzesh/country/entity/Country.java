package com.tzesh.country.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Country is an entity class that is used to store data about countries.
 * Author: Uğur Dindar (Tzesh)
 */
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Country {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String president;
}
