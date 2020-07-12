package pl.coderslab.medbaseproject.model;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CurrentUser extends User {
    private final pl.coderslab.medbaseproject.entity.User user;

    public CurrentUser(
            String email,
            String password,
            Collection<? extends GrantedAuthority> authorities,
            pl.coderslab.medbaseproject.entity.User user
    ) {
        super(email, password, authorities);
        this.user = user;
    }

    public pl.coderslab.medbaseproject.entity.User getUser() {
        return user;
    }
}
