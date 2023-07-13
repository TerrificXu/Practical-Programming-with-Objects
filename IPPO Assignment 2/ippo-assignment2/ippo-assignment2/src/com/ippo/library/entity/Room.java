package com.ippo.library.entity;

import java.util.List;

/**
 *
 * 2021/11/16 1:22
 */
public class Room {

    private List<Locate> locates;

    public Room() {
    }

    public Room(List<Locate> locates) {
        this.locates = locates;
    }

    public List<Locate> getLocates() {
        return locates;
    }

    public void setLocates(List<Locate> locates) {
        this.locates = locates;
    }

    @Override
    public String toString() {
        return "Room{" +
                "locates=" + locates +
                '}';
    }

}
