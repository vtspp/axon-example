package br.com.booking.repository;

import br.com.booking.domain.Booking;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookingRepository extends ReactiveMongoRepository<Booking, UUID> {
}