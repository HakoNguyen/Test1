package com.example.testbackend1.controller;

import com.example.testbackend1.model.Position;
import com.example.testbackend1.service.PositionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/positions")
public class PositionController {

    @Autowired
    private PositionService positionService;

    // Tạo chức vụ mới
    @PostMapping("/add")
    public ResponseEntity<Position> addPosition(@RequestBody Position position) {
        Position createdPosition = positionService.addPosition(position);
        return new ResponseEntity<>(createdPosition, HttpStatus.CREATED);
    }

    // Lấy tất cả chức vụ
    @GetMapping
    public ResponseEntity<List<Position>> getAllPositions() {
        List<Position> positions = positionService.getAllPositions();
        return new ResponseEntity<>(positions, HttpStatus.OK);
    }
    @Transactional
// Xóa chức vụ theo id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePosition(@PathVariable String id) {
        try {
            positionService.deletePositionById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
