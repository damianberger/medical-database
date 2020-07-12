package pl.coderslab.medbaseproject.service.implementation;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.medbaseproject.entity.Role;
import pl.coderslab.medbaseproject.entity.User;
import pl.coderslab.medbaseproject.repository.RoleRepository;
import pl.coderslab.medbaseproject.repository.UserRepository;
import pl.coderslab.medbaseproject.service.UserService;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void savePatient(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
        if(user.getRoles() == null || user.getRoles().size() == 0) {
            Set<Role> roles = new HashSet<>();
            roles.add(roleRepository.findOneByName("ROLE_PATIENT"));
            user.setRoles(roles);
        }
        userRepository.save(user);
    }

    @Override
    public void saveDoctor(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
        if(user.getRoles() == null || user.getRoles().size() == 0) {
            Set<Role> roles = new HashSet<>();
            roles.add(roleRepository.findOneByName("ROLE_DOCTOR"));
            user.setRoles(roles);
        }
        userRepository.save(user);
    }
}
