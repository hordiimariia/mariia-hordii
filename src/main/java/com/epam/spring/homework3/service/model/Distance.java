package com.epam.spring.homework3.service.model;

import lombok.Builder;
import lombok.Data;

import java.util.Objects;

@Data
@Builder
public class Distance {
    private int id;
    private String from;
    private String to;
    private int distance;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distance distance1 = (Distance) o;
        return id == distance1.id
                && distance == distance1.distance
                && Objects.equals(from, distance1.from)
                && Objects.equals(to, distance1.to);
    }
}
