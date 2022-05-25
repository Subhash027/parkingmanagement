package com.grootan.parkingmanagement.repository;

import com.grootan.parkingmanagement.model.entity.DAOUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<DAOUser, Integer> {
    DAOUser findByUsername(String username);
}
