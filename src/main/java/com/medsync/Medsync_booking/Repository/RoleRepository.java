package com.medsync.Medsync_booking.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.medsync.Medsync_booking.Model.ERole;
import com.medsync.Medsync_booking.Model.Role;

public interface RoleRepository extends MongoRepository<Role,String>{

    Optional<Role> findByName(ERole name);
    
}
