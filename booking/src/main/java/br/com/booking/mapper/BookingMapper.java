package br.com.booking.mapper;


import br.com.booking.domain.Booking;
import br.com.booking.dto.BookingResponse;
import org.springframework.stereotype.Component;

@Component
public class BookingMapper {

    public BookingResponse toResponse (Booking booking) {
        return BookingResponse.builder()
                .identifier(booking.getIdentifier())
                .name(booking.getName())
                .build();
    }
}