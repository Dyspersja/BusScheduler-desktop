package com.dyspersja.database.tables.BusStop;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusStopEntity {

    private int id;
    private String number;
    private String city;
    private String street;
    private double latitude;
    private double longitude;
}
