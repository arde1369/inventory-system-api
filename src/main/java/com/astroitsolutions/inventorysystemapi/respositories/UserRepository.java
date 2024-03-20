package com.astroitsolutions.inventorysystemapi.respositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.astroitsolutions.inventorysystemapi.entities.User;

public interface UserRepository extends MongoRepository<User, Long>{
    public User findByUsername(String username);
}
