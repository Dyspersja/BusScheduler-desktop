package com.dyspersja.database.tables.route;

import com.dyspersja.database.tables.busline.BusLine;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;

@Entity
@Table(name = "routes")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bus_line_id", nullable = false)
    private BusLine busLine;

    @Column(name = "departure_time", nullable = false)
    private Time departureTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "operating_day", nullable = false)
    private OperatingDay operatingDay;
}
