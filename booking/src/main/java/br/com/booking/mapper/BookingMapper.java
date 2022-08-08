package br.com.booking.mapper;


import br.com.booking.domain.Booking;
import br.com.booking.dto.BookingRequest;
import br.com.booking.dto.BookingResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper (componentModel = "spring")
public interface BookingMapper {
    BookingResponse toResponse (Booking booking);
    Booking toEntity (BookingRequest request);
}