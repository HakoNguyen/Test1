package com.example.testbackend1.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {
    @Id

    String id;
    String employeeId;
    String name;

    @ManyToOne
    @JoinColumn(name = "department_id")
    Department department;

    @ManyToOne
    @JoinColumn(name = "position_id")
    Position position;

    @ManyToOne
    @JoinColumn(name = "atttendance_id")
    Attendance attendance;

}
