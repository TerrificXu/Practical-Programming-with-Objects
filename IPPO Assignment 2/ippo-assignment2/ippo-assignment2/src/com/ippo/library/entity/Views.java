package com.ippo.library.entity;

/**
 *
 * 2021/11/16 2:00
 */
public class Views {

    private Picture northPic;

    private Picture eastPic;

    private Picture southPic;

    private Picture westPic;

    public Views() {
    }

    public Views(Picture northPic, Picture eastPic, Picture southPic, Picture westPic) {
        this.northPic = northPic;
        this.eastPic = eastPic;
        this.southPic = southPic;
        this.westPic = westPic;
    }

    public Picture getNewPicture(Position position, String operate) {
        Position newPosition = position.getNewPosition(position, operate);
        return getPicture(newPosition);
    }

    public Picture getPicture(Position position) {
        switch (position){
            case NORTH:
                return northPic;
            case EAST:
                return eastPic;
            case SOUTH:
                return southPic;
            case WEST:
                return westPic;
            default:
                return null;
        }
    }

    public Picture getNorthPic() {
        return northPic;
    }

    public void setNorthPic(Picture northPic) {
        this.northPic = northPic;
    }

    public Picture getSouthPic() {
        return southPic;
    }

    public void setSouthPic(Picture southPic) {
        this.southPic = southPic;
    }

    public Picture getWestPic() {
        return westPic;
    }

    public void setWestPic(Picture westPic) {
        this.westPic = westPic;
    }

    public Picture getEastPic() {
        return eastPic;
    }

    public void setEastPic(Picture eastPic) {
        this.eastPic = eastPic;
    }

    @Override
    public String toString() {
        return "Views{" +
                "northPic=" + northPic +
                ", eastPic=" + eastPic +
                ", southPic=" + southPic +
                ", westPic=" + westPic +
                '}';
    }

}
