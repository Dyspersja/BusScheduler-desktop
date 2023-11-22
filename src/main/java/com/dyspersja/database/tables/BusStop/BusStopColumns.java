package com.dyspersja.database.tables.BusStop;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BusStopColumns {

    ID("id"),
    NUMBER("number"),
    CITY("city"),
    STREET("street"),
    LATITUDE("latitude"),
    LONGITUDE("longitude");

    private final String columnName;
}
