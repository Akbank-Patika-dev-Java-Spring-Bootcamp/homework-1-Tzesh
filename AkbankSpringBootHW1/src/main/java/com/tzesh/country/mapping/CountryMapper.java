package com.tzesh.country.mapping;

import com.tzesh.country.dto.CountryDto;
import com.tzesh.country.entity.Country;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper for {@link Country} objects.
 * <p>
 * This interface provides mapping operations for {@link Country} objects.
 * <ul>
 *     <li>Country to CountryDto</li>
 *     <li>CountryDto to Country</li>
 *     <li>List of Country to List of CountryDto</li>
 * </ul>
 * <p>
 *     <b>NOTE:</b> This interface is implemented by MapStruct library.
 *     <br>
 * Author: Uğur Dindar (Tzesh)
 */
@Mapper
public interface CountryMapper {

    CountryDto map(Country value);

    Country mapToEntity(CountryDto value);

    List<CountryDto> mapToDtoList(List<Country> value);
}
