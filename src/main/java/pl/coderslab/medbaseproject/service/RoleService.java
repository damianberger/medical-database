package pl.coderslab.medbaseproject.service;

import pl.coderslab.medbaseproject.entity.Role;

import java.util.List;

public interface RoleService {
    void save(Role role);
    Role findOneByName(String roleName);
    List<Role> findAll();
}
