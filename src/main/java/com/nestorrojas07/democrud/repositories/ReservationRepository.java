package com.nestorrojas07.democrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nestorrojas07.democrud.models.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{

}
