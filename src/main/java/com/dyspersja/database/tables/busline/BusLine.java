package com.dyspersja.database.tables.busline;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "bus_lines", uniqueConstraints = {@UniqueConstraint(columnNames = {"line_number", "is_return_line"})})
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BusLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "line_number", nullable = false)
    private int lineNumber;

    @Column(name = "is_return_line", nullable = false)
    private boolean isReturnLine;

}
