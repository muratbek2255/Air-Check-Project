package com.example.authenticationservice.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;


@Entity
@Getter
@Setter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "phone_number")
    @NonNull
    String phoneNumber;

    @Column(nullable = false, name = "password")
    @NonNull
    String password;

    @Column(name = "first_name")
    @NonNull
    String firstName;

    @Column(name = "last_name")
    @NonNull
    String lastName;

    @Column(name = "middle_name")
    @NonNull
    String middleName;

    @Column(name = "is_admin")
    Boolean isAdmin;

    @Column(name = "is_read_only_user")
    Boolean isReadOnlyUser;

    @Column(name = "credentialsExpiryDate")
    LocalDateTime credentialsExpiryDate;

    @Column(name = "isAccountExpired")
    Boolean isAccountExpired;

    @Column(name = "isAccountLocked")
    Boolean isAccountLocked;

    @Column(name = "enabled")
    Boolean enabled;


    public User() {

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        if(isAdmin.equals(Boolean.TRUE)) {

            if(isReadOnlyUser.equals(Boolean.TRUE)) {
                return UserRole.MODERATOR.getAuthorities();
            }

            return UserRole.ADMIN.getAuthorities();
        }

        if(isReadOnlyUser.equals(Boolean.TRUE)) {
            return UserRole.GUEST.getAuthorities();
        }

        return UserRole.USER.getAuthorities();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return phoneNumber;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountExpired;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsExpiryDate == null ||  credentialsExpiryDate.isAfter(LocalDateTime.now());
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
