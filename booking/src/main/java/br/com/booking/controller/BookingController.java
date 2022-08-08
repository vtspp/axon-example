package br.com.booking.controller;

import br.com.booking.command.BookingCommand;
import br.com.booking.dto.BookingResponse;
import br.com.booking.query.BookingQueryById;
import lombok.RequiredArgsConstructor;
import org.axonframework.extensions.reactor.commandhandling.gateway.ReactorCommandGateway;
import org.axonframework.extensions.reactor.queryhandling.gateway.ReactorQueryGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping ("/api/v1/booking")
@RequiredArgsConstructor
public class BookingController {

    private final ReactorCommandGateway commandGateway;
    private final ReactorQueryGateway queryGateway;

    @GetMapping
    public Mono<BookingResponse> test () {
        return this.commandGateway.send(
                BookingCommand.builder()
                        .uuid(UUID.randomUUID())
                        .name("booking test")
                        .build()
        );
    }

    @GetMapping("/{identifier}")
    public Mono<BookingResponse> bookingByIdentifier (@PathVariable UUID identifier) {
        return this.queryGateway.query("findBookByIdentifier",
                BookingQueryById.builder()
                        .identifier(identifier)
                        .build(),
                ResponseTypes.instanceOf(BookingResponse.class)
        );
    }
}