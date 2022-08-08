package br.com.booking.service;

import br.com.booking.domain.Booking;
import br.com.booking.dto.BookingResponse;
import br.com.booking.event.BookingUnsavedEvent;
import br.com.booking.mapper.BookingMapper;
import br.com.booking.query.BookingQueryById;
import br.com.booking.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository repository;
    private final BookingMapper mapper;

    @EventHandler
    public BookingResponse registerBookingEvent (BookingUnsavedEvent event) {
        return this.repository.save(Booking.builder()
                        .identifier(event.getUuid())
                        .name(event.getName())
                .build())
                .map(mapper::toResponse)
                .block();
    }

    @QueryHandler (queryName = "findBookByIdentifier")
    public BookingResponse findBookByIdentifier (BookingQueryById query) {
        return this.repository.findById(query.getIdentifier())
                .map(mapper::toResponse)
                .doOnError(Throwable::printStackTrace)
                .block();
    }
}