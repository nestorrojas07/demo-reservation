package com.nestorrojas07.democrud.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nestorrojas07.democrud.models.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
	
	@Query("select r from reservation where r.from_at = :pfrom_at and r.to_at = :pto_at")
	public List<Reservation> find(@Param("pfrom_at") Date from_at, @Param("pto_at") Date to_at);
}
