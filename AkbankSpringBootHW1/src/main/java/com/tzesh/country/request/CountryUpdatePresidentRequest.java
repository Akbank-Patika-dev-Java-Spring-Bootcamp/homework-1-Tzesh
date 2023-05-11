package com.tzesh.country.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 * Request object for updating a country's president
 * @param president Country president
 * Author: Uğur Dindar (Tzesh)
 */
@Schema(name = "CountryUpdatePresidentRequest", description = "Request object for updating a country's president")
public record CountryUpdatePresidentRequest(@NotNull @Length(min = 3, max = 120) String president) {
}
