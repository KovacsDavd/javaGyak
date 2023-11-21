package com.epam.training.ticketservice.core.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "Rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private int rowNumber;

    private int columnNumber;

    public Room() {
    }

    public Room(String name, int rowNumber, int columnNumber) {
        this.name = name;
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    public void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }

    @Override
    public String toString() {
        var res = rowNumber * columnNumber;
        return "Room " + name + " with " + res + " seats, " + rowNumber + " rows and " + columnNumber + " columns";
    }
}
