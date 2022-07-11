package web.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

// Этот класс реализует интерфейс GrantedAuthority, в котором необходимо переопределить только один метод getAuthority() (возвращает имя роли).
// Имя роли должно соответствовать шаблону: «ROLE_ИМЯ», например, ROLE_USER.
@Entity
@Getter @Setter @NoArgsConstructor
@Table(name = "Roles")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String role;
    
    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    private Set<User> users;

    public Role(String role){
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role;
    }

    @Override
    public String toString(){return role;}
}



