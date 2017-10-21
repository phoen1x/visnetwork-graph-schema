package de.livingfire.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "persons",
        path = "persons")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
}
