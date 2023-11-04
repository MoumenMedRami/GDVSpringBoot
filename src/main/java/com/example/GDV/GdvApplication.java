package com.example.GDV;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GdvApplication {

	public static void main(String[] args) {
		SpringApplication.run(GdvApplication.class, args);
	}
/*
	@Bean
	public CommandLineRunner commandLineRunner(
			AuthenticationService service
	) {
		return args -> {

			var r1 = Role.builder()
					.roleName("ADMIN")
					.build();
			var r2 = Role.builder()
					.roleName("USER")
					.build();
			var r3 = Role.builder()
					.roleName("DEMANDEUR")
					.build();

			service.addRole(r1);service.addRole(r2);service.addRole(r3);

			var admin = RegisterRequest.builder()
					.firstname("Admin")
					.lastname("Admin")
					.email("admin@mail.com")
					.password("1234")
					.username("rami")
					.build();
			var user = RegisterRequest.builder()
					.firstname("user")
					.lastname("user")
					.email("user@mail.com")
					.password("1234")
					.username("user")
					.build();
			var demandeur = RegisterRequest.builder()
					.firstname("user")
					.lastname("user")
					.email("user@mail.com")
					.password("1234")
					.username("demandeur")
					.build();
			service.register(admin);
			service.register(user);
			service.register(demandeur);
			service.addRoleToUser("rami","ADMIN");
			service.addRoleToUser("user","USER");
			service.addRoleToUser("rami","USER");



		};
	}

 */

}
