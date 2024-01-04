package com.acheron.lababd.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "email", nullable = false)
    private String email;
    @Enumerated(value = EnumType.STRING)
    @ToString.Exclude
    private Role role;
    @ToString.Exclude
    private String password;

    public enum Role implements GrantedAuthority {
        USER,ADMIN;

        @Override
        public String getAuthority() {
            return name();
        }
    }
}
