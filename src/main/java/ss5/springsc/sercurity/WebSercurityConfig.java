package ss5.springsc.sercurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Service;

@Configuration
@EnableWebSecurity
public class WebSercurityConfig {
    @Autowired
    private UserDetailService userDetailService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authenticationProvider(authenticationProvider())
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((auth) -> auth.requestMatchers("/cart")
                        .authenticated()
                        .requestMatchers("/admin/**").hasAnyAuthority("Admin")
                        .anyRequest().permitAll()).formLogin((login) ->
                        login.loginPage("/logon")
                                .loginProcessingUrl("/logon")
                                .usernameParameter("userName")
                                .passwordParameter("password")
                ).build();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
}
