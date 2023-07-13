package com.ippo.library.entity;

import javafx.scene.image.Image;

/**
 *
 * 2021/11/16 1:22
 */
public class Item {

    private Image image;

    public Item() {
    }

    public Item(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Item{" +
                "image=" + image +
                '}';
    }

}
