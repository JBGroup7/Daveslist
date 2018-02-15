package com.group7.daveslist;

import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long>{

    Role findByRole(String role);
}

