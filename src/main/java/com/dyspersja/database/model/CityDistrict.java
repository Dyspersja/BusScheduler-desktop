package com.dyspersja.database.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "city_districts")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CityDistrict {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "district_name", nullable = false, unique = true)
    private String districtName;

    @Column(name = "city", nullable = false)
    private String city;

    @ManyToOne
    @JoinColumn(name = "ticket_zone_id")
    private TicketZone ticketZone;
}
