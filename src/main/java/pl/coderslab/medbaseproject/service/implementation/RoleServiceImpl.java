package pl.coderslab.medbaseproject.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.medbaseproject.entity.Role;
import pl.coderslab.medbaseproject.repository.RoleRepository;
import pl.coderslab.medbaseproject.service.RoleService;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void save(Role role) {
        this.roleRepository.save(role);
    }

    @Override
    public Role findOneByName(String roleName) {
        return this.roleRepository.findOneByName(roleName);
    }

    @Override
    public List<Role> findAll() {
        return this.roleRepository.findAll();
    }
}
