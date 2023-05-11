package com.tzesh.country.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * CountryDto is a DTO class that is used to transfer data between the client and the server.
 * <p>
 *     It is used to transfer data about {@link com.tzesh.country.entity.Country} objects.
 * </p>
 * Author: Uğur Dindar (Tzesh)
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountryDto {
    private Long id;
    private String name;
    private String president;
}
