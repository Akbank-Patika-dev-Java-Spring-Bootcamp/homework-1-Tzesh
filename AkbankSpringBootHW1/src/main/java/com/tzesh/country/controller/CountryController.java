package com.tzesh.country.controller;

import com.tzesh.country.dto.CountryDto;
import com.tzesh.country.mapping.CountryMapper;
import com.tzesh.country.request.CountryCreateRequest;
import com.tzesh.country.request.CountryUpdatePresidentRequest;
import com.tzesh.country.request.CountryUpdateRequest;
import com.tzesh.country.service.CountryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for country operations
 * <p>
 *     This controller provides CRUD operations for country entity.
 *     <ul>
 *         <li>Get all countries</li>
 *         <li>Create country</li>
 *         <li>Update country</li>
 *         <li>Delete country</li>
 *         <li>Get country by id</li>
 *         <li>Update president by id</li>
 *     </ul>
 * </p>
 * @see CountryService
 * @see CountryMapper
 * @see CountryDto
 * Author: Uğur Dindar (Tzesh)
 */
@RestController
@Validated
@RequestMapping("/country")
@Tag(name = "Country Controller", description = "Country CRUD operations")
public class CountryController {
    private final CountryService countryService;

    /**
     * Constructor for CountryController
     * @param countryService CountryService object
     */
    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    /**
     * GET method to get all countries from database
     * @return ResponseEntity<List<CountryDto>> object
     * @see CountryService#getAllCountries()
     */
    @GetMapping("/")
    @Operation(summary = "Get all countries", description = "Get all countries from database")
    public ResponseEntity<List<CountryDto>> getAllCountries() {
        // get all countries from database
        List<CountryDto> countries = countryService.getAllCountries();

        // return countryDto list
        return ResponseEntity.ok().body(countries);
    }

    /**
     * POST method to create country with validation
     * @param createRequest CountryCreateRequest object
     * @return ResponseEntity<CountryDto> created country
     * @see CountryService#saveCountry(CountryDto)
     */
    @PostMapping("/")
    @Operation(summary = "Create country", description = "Create country")
    public ResponseEntity<CountryDto> createCountry(@RequestBody @Valid CountryCreateRequest createRequest) {
        // map createRequest to countryDto
        CountryDto countryDto = new CountryDto();
        countryDto.setName(createRequest.name());
        countryDto.setPresident(createRequest.president());

        // save country to database
        countryDto = countryService.saveCountry(countryDto);

        // return countryDto
        return ResponseEntity.ok().body(countryDto);
    }

    /**
     * PATCH method to update president of country by id with validation
     * @param id id of country
     * @param updatePresidentRequest CountryUpdatePresidentRequest new president
     * @return ResponseEntity<CountryDto> updated country
     * @see CountryService#getCountryById(Long)
     * @see CountryService#saveCountry(CountryDto)
     */
    @PatchMapping("/{id}")
    @Operation(summary = "Update president of country by id", description = "Update president of country by id")
    public ResponseEntity<CountryDto> updatePresidentById(@PathVariable Long id, @RequestBody @Valid CountryUpdatePresidentRequest updatePresidentRequest) {
        // get country by id from database
        CountryDto countryDto = countryService.getCountryById(id);

        // control if country is present
        if (countryDto == null) {
            // return not found
            return ResponseEntity.notFound().build();
        }

        // change president
        countryDto.setPresident(updatePresidentRequest.president());

        // save country to database
        countryDto = countryService.saveCountry(countryDto);

        // return countryDto
        return ResponseEntity.ok().body(countryDto);
    }

    /**
     * PUT method to update country by id with validation
     * @param id id of country
     * @param updateRequest CountryUpdateRequest new name and president
     * @return ResponseEntity<CountryDto> updated country
     */
    @PutMapping("/{id}")
    @Operation(summary = "Update country by id", description = "Update country by id")
    public ResponseEntity<CountryDto> updateCountry(@PathVariable Long id, @RequestBody @Valid CountryUpdateRequest updateRequest) {
        // get country by id from database
        CountryDto countryDto = countryService.getCountryById(id);

        // control if country is present
        if (countryDto == null) {
            // return not found
            return ResponseEntity.notFound().build();
        }

        // change name and president
        countryDto.setName(updateRequest.name());
        countryDto.setPresident(updateRequest.president());

        // save country to database
        countryDto = countryService.saveCountry(countryDto);

        // return countryDto
        return ResponseEntity.ok().body(countryDto);
    }

    /**
     * DELETE method to delete country by id
     * @param id id of country
     * @return ResponseEntity<CountryDto> deleted country
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete country by id", description = "Delete country by id")
    public ResponseEntity<CountryDto> deleteCountryById(@PathVariable Long id) {
        // get country by id from database
        CountryDto countryDto = countryService.getCountryById(id);

        // control if country is present
        if (countryDto == null) {
            // return not found
            return ResponseEntity.notFound().build();
        }

        // delete country by id from database
        countryService.deleteCountryById(id);

        // return no content
        return ResponseEntity.ok().body(countryDto);
    }

    /**
     * GET method to get country by id
     * @param id id of country
     * @return ResponseEntity<CountryDto> country
     */
    @GetMapping("/{id}")
    @Operation(summary = "Get country by id", description = "Get country by id")
    public ResponseEntity<CountryDto> getCountryById(@PathVariable Long id) {
        // get country by id from database
        CountryDto country = countryService.getCountryById(id);

        // control if country is present
        if (country == null) {
            // return not found
            return ResponseEntity.notFound().build();
        }

        // return countryDto
        return ResponseEntity.ok().body(country);
    }
}
