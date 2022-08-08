package br.com.booking.event;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class BookingCreateEvent {
    private UUID uuid;
    private String name;
}