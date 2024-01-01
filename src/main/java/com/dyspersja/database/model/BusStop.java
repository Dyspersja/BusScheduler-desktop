package com.dyspersja.database.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "bus_stops")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BusStop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "stop_name", nullable = false, unique = true)
    private String stopName;

    @Column(name = "stop_number", nullable = false, unique = true)
    private int stopNumber;

    @ManyToOne
    @JoinColumn(name = "city_district_id", nullable = false)
    private CityDistrict cityDistrict;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "latitude", nullable = false)
    private Double latitude;

    @Column(name = "longitude", nullable = false)
    private Double longitude;
}
