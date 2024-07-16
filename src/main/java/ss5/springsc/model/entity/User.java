package ss5.springsc.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="user_name",unique = true,length = 100)
    private String userName;
    @Column(name="password")
    private String password;
    private boolean status;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="user_role",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}

