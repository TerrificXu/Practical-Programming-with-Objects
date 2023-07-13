package com.ippo.library.entity;

import java.util.List;

/**
 *
 * 2021/11/16 11:05
 */
public class Locate {
    private Views views;
    private List<Item> items;
    private Locate northNode;
    private Locate southNode;
    private Locate westNode;
    private Locate eastNode;

    public Locate() {
    }

    public Locate(Views views, List<Item> items) {
        this.views = views;
        this.items = items;
    }

    public Locate getNewLocate(Locate locate, Position position){
        switch (position){
            case NORTH:
                return locate.northNode;
            case SOUTH:
                return locate.southNode;
            case WEST:
                return locate.westNode;
            case EAST:
                return locate.eastNode;
            default:
                return null;
        }
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Views getViews() {
        return views;
    }

    public Locate getNorthNode() {
        return northNode;
    }

    public void setNorthNode(Locate northNode) {
        this.northNode = northNode;
    }

    public Locate getSouthNode() {
        return southNode;
    }

    public void setSouthNode(Locate southNode) {
        this.southNode = southNode;
    }

    public Locate getWestNode() {
        return westNode;
    }

    public void setWestNode(Locate westNode) {
        this.westNode = westNode;
    }

    public Locate getEastNode() {
        return eastNode;
    }

    public void setEastNode(Locate eastNode) {
        this.eastNode = eastNode;
    }

    @Override
    public String toString() {
        return "Locate{" +
                "views=" + views +
                ", items=" + items +
                ", northNode=" + northNode +
                ", southNode=" + southNode +
                ", westNode=" + westNode +
                ", eastNode=" + eastNode +
                '}';
    }

}
