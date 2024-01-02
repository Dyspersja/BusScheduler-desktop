package com.dyspersja.database.tables.ticketzone;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ticket_zones")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketZone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "zone_name", nullable = false, unique = true)
    private String zoneName;
}
