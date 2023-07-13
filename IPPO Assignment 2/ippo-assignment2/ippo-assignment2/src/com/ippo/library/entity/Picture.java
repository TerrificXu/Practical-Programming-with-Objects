package com.ippo.library.entity;

import javafx.scene.image.Image;

/**
 *
 * 2021/11/16 1:32
 */
public class Picture {

    private String fullName;

    private Image image;

    private Boolean aBoolean;

    private Position position;

    public Picture() {
    }

    public Picture(String fullName, Image image, Boolean aBoolean, Position position) {
        this.fullName = fullName;
        this.image = image;
        this.aBoolean = aBoolean;
        this.position = position;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Boolean getaBoolean() {
        return aBoolean;
    }

    public void setaBoolean(Boolean aBoolean) {
        this.aBoolean = aBoolean;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "fullName='" + fullName + '\'' +
                ", image=" + image +
                ", aBoolean=" + aBoolean +
                ", position=" + position +
                '}';
    }

}
