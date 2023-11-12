package com.dyspersja.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusStop {

    private int id;
    private String number;
    private String city;
    private String street;
    private double latitude;
    private double longitude;
}
