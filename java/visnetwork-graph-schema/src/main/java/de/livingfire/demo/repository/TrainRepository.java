package de.livingfire.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "trains",
        path = "trains")
public interface TrainRepository extends PagingAndSortingRepository<Train, Long> {
}
