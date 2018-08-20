package com.pollingapp.thebloez.repository;

import com.pollingapp.thebloez.model.Role;
import com.pollingapp.thebloez.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
