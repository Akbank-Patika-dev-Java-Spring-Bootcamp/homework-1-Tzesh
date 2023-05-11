package com.tzesh.country.repository;

import com.tzesh.country.entity.Country;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for {@link Country} objects.
 * <p>
 *     This interface provides CRUD operations for {@link Country} objects.
 * </p>
 * Author: Uğur Dindar (Tzesh)
 */
public interface CountryRepository extends CrudRepository<Country, Long> {

}
