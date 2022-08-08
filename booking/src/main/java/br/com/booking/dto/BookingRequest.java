package br.com.booking.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class BookingRequest {
    private UUID identifier;
    private String name;
}