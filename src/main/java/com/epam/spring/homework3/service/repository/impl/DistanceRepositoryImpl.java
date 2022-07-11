package com.epam.spring.homework3.service.repository.impl;

import com.epam.spring.homework3.service.model.Distance;
import com.epam.spring.homework3.service.repository.DistanceRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DistanceRepositoryImpl implements DistanceRepository {

    private final List<Distance> list = new ArrayList<>();

    @Override
    public Distance getDistance(int id) {
        return list.stream()
                .filter(distance -> distance.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Distance is not found!"));
    }

    @Override
    public List<Distance> getAllDistances() {
        return new ArrayList<>(list);
    }

    @Override
    public Distance createDistance(Distance distance) {
        list.add(distance);
        return distance;
    }

    @Override
    public void deleteDistance(int id) {
        list.removeIf(distance -> distance.getId() == id);
    }
}
