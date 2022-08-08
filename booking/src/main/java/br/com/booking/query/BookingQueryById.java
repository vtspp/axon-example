package br.com.booking.query;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class BookingQueryById {
    private UUID identifier;
}