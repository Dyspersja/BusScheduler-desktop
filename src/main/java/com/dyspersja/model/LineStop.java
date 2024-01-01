package com.dyspersja.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "line_stops")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LineStop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bus_line_id", nullable = false)
    private BusLine busLine;

    @ManyToOne
    @JoinColumn(name = "bus_stop_id", nullable = false)
    private BusStop busStop;

    @Column(name = "is_start", nullable = false)
    private boolean isStart;

    @Column(name = "is_end", nullable = false)
    private boolean isEnd;

    @Column(name = "bus_stop_order", nullable = false)
    private int busStopOrder;

    @Column(name = "travel_time", nullable = false)
    private int travelTime;
}
