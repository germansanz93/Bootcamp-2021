package com.intercorp.pinapper.repository;

import com.intercorp.pinapper.domain.model.Pinapper;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PinapperRepository extends CrudRepository<Pinapper, Long> {
    List<Pinapper> findByLastName(String lastName);

    Pinapper findById(long id);
}
