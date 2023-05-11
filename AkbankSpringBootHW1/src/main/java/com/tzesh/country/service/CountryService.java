package com.tzesh.country.service;

import com.tzesh.country.dto.CountryDto;
import com.tzesh.country.entity.Country;
import com.tzesh.country.mapping.CountryMapper;
import com.tzesh.country.repository.CountryRepository;
import org.apache.commons.collections4.IterableUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Service for country operations
 * <p>
 *     This class provides operations for country objects.
 *     <ul>
 *         <li>Save country to database</li>
 *         <li>Get country by id</li>
 *         <li>Get all countries</li>
 *         <li>Update country</li>
 *         <li>Delete country</li>
 *     </ul>
 * </p>
 * @see CountryRepository
 * @see CountryMapper
 * @see CountryDto
 * @see Country
 * Author: Uğur Dindar (Tzesh)
 */
@Service
public class CountryService {

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper = Mappers.getMapper(CountryMapper.class);

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    /**
     * Save country to database
     * @param country CountryDto object
     * @return CountryDto object
     */
    public CountryDto saveCountry(CountryDto country) {
        // map CountryDto to Country
        Country countryEntity = countryMapper.mapToEntity(country);

        // save country to database
        countryRepository.save(countryEntity);

        // map Country to CountryDto
        country = countryMapper.map(countryEntity);

        // return CountryDto
        return country;
    }

    public CountryDto getCountryById(Long id) {
        // get country from database
        Country country = countryRepository.findById(id).orElse(null);

        // map Country to CountryDto
        CountryDto countryDto = countryMapper.map(country);

        // return CountryDto
        return countryDto;
    }

    public List<CountryDto> getAllCountries() {
        // get all countries from database
        List<Country> countries = IterableUtils.toList(countryRepository.findAll());

        // map countries to countryDto list
        List<CountryDto> countryDtoList = countryMapper.mapToDtoList(countries);

        // return countryDto list
        return countryDtoList;
    }

    public void deleteCountryById(Long id) {
        // delete country from database
        countryRepository.deleteById(id);
    }
}
