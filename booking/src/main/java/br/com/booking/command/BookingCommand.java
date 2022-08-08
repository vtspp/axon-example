package br.com.booking.command;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;
@Data
@Builder
public class BookingCommand {
    private UUID uuid;
    private String name;
}