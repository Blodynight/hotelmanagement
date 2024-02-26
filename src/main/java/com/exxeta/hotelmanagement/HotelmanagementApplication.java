package com.exxeta.hotelmanagement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.exxeta.hotelmanagement.enums.RoomSize;
import com.exxeta.hotelmanagement.models.Room;
import com.exxeta.hotelmanagement.repositories.RoomRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.exxeta.hotelmanagement.repositories"})
public class HotelmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelmanagementApplication.class, args);
	}
	
    @Bean
    CommandLineRunner demo(RoomRepository repository) {
		return (args) -> {
			repository.save(new Room(1, RoomSize.DOPPELZIMMER, true, false));
			repository.save(new Room(2, RoomSize.EINZELZIMMER, true, false));
			repository.save(new Room(3, RoomSize.SUITE, false, false));
		};
	}

}
