package pl.coderslab.medbaseproject.service;

import pl.coderslab.medbaseproject.entity.User;

public interface UserService {
    User findByEmail(String email);

    void savePatient(User user);

    void saveDoctor(User user);
}
