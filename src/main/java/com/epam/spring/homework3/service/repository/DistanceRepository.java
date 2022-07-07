package com.epam.spring.homework3.service.repository;

import com.epam.spring.homework3.service.model.Distance;

import java.util.List;

public interface DistanceRepository {
    Distance getDistance(int id);
    List<Distance> getAllDistances();

    Distance createDistance(Distance distance);
    void deleteDistance(int id);
}
