package br.com.booking.aggregate;

import br.com.booking.command.BookingCommand;
import br.com.booking.event.BookingCreateEvent;
import br.com.booking.event.BookingCreatedEvent;
import br.com.booking.event.BookingUnsavedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

@Aggregate
public class BookingAggregate {
    @AggregateIdentifier
    private UUID uuid;
    private String name;

    @CommandHandler
    protected BookingAggregate (BookingCommand command) {
        AggregateLifecycle.apply(
                BookingCreateEvent.builder()
                        .uuid(command.getUuid())
                        .name(command.getName())
                        .build()
        );
    }

    @EventSourcingHandler
    private void handler (BookingCreateEvent createEvent) {
        this.uuid = createEvent.getUuid();
        this.name = createEvent.getName();

        AggregateLifecycle.apply(
                BookingCreatedEvent.builder()
                        .uuid(createEvent.getUuid())
                        .name(createEvent.getName())
                        .build()
        );
    }

    @EventSourcingHandler
    private void handler (BookingCreatedEvent createdEvent) {
        AggregateLifecycle.apply(
                BookingUnsavedEvent.builder()
                        .uuid(createdEvent.getUuid())
                        .name(createdEvent.getName())
                        .build()
        );
    }
}