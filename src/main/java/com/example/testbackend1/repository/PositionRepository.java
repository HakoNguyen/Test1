package com.example.testbackend1.repository;

import com.example.testbackend1.model.Position;
import com.example.testbackend1.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PositionRepository extends JpaRepository<Position, Long> {
    Optional<Position> findByPositionCode(String positionCode);
    boolean existsByPositionCode(String positionCode);
    void deleteByPositionCode(String positionCode);
}