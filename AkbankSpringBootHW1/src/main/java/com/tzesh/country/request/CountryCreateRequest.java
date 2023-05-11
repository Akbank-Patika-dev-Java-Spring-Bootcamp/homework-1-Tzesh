package com.tzesh.country.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 * Request object for creating a country
 * @param name Country name
 * @param president Country president
 * Author: Uğur Dindar (Tzesh)
 */
@Schema(name = "CountryCreateRequest", description = "Request object for creating a country")
public record CountryCreateRequest(@NotNull @Length(min = 3, max = 120) String name,
                                   @NotNull @Length(min = 3, max = 120) String president) {
}
