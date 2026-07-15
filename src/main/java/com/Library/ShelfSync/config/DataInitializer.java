package com.Library.ShelfSync.config;

import com.Library.ShelfSync.enums.RoleName;
import com.Library.ShelfSync.models.RoleEntity;
import com.Library.ShelfSync.models.UserEntity;
import com.Library.ShelfSync.repository.RoleRepo;
import com.Library.ShelfSync.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${app.admin.email}")
    private String adminEmail;

    @Value("${app.admin.password}")
    private String adminPassword;

    @Value("${app.admin.Phone}")
    private String Phone;

    @Override
    public void run(String... args){
        initializeRoles();
        initializeAdmin();
    }

    private void initializeRoles(){
        if (!roleRepo.existsByRoleName(RoleName.ADMIN)) {

            roleRepo.save(
                    new RoleEntity(RoleName.ADMIN)
            );

        }

        if (!roleRepo.existsByRoleName(RoleName.LIBRARIAN)) {

            roleRepo.save(
                    new RoleEntity(RoleName.LIBRARIAN)
            );

        }

        if (!roleRepo.existsByRoleName(RoleName.STUDENT)) {

            roleRepo.save(
                    new RoleEntity(RoleName.STUDENT)
            );

        }
    }

    private void initializeAdmin(){

        if(userRepo.existsByEmail("admin@shelfsync.com")){
            return;
        }

        RoleEntity adminRole = roleRepo.findByRoleName(RoleName.ADMIN)
                .orElseThrow(() -> new RuntimeException("Admin role not found"));

        UserEntity admin = new UserEntity();

        admin.setFirstName("System");
        admin.setLastName("Admin");
        admin.setEmail(adminEmail);
        admin.setPassword(passwordEncoder.encode(adminPassword));
        admin.setPhoneNumber(Phone);
        admin.setRole(adminRole);

        userRepo.save(admin);


    }

}
