package ss5.springsc.sercurity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import ss5.springsc.model.entity.User;

import java.util.Collection;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserPrinciple implements UserDetails {
    private User user;
    private Collection<? extends GrantedAuthority> authorities;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }


    @Override
    public boolean isEnabled() {
        return user.isStatus();
    }

    @Override
    public String getPassword() {
        return user.getPassword();

    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }
}
