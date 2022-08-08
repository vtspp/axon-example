package br.com.booking.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.UUID;

@Data
@Builder
@Document
public class Booking {
    @MongoId
    private UUID identifier;
    private String name;
}