package com.github.qualquercoisavinteconto.seeds;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.qualquercoisavinteconto.models.Role;
import com.github.qualquercoisavinteconto.repositories.RoleRepository;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final RoleRepository roleRepository;

    public DatabaseSeeder(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (roleRepository.count() == 0) {
            roleRepository.saveAll(List.of(
                    new Role("ADMIN"),
                    new Role("CUSTOMER"),
                    new Role("SELLER"),
                    new Role("ADVERTISER")));
        }
    }

}
