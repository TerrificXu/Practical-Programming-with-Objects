package com.ippo.library.component;

import com.ippo.controller.SimpleController;
import com.ippo.library.constant.Constants;
import com.ippo.library.entity.Item;
import com.ippo.library.entity.Picture;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 *
 * 2021/11/16 9:18
 */
public class ButtonView implements Initializable {

    private SimpleController controller = null;

    @FXML
    private Label captionLabel;

    @FXML
    private ImageView imageView;

    @FXML
    private VBox roomBox;

    @FXML
    private VBox basketBox;

    @FXML
    private Label errorLabel;

    @FXML
    private Button left;

    @FXML
    private Button forward;

    @FXML
    private Button right;

    public ButtonView() {
        SimpleController simpleController = new SimpleController();
        setController(simpleController);
    }

    public void setController(SimpleController controller) {
        this.controller = controller;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showPicture(controller.getPicture());
        addRoomView(controller.getRoomViews());
    }

    @FXML
    void goLeft() {
        left.setOnAction(e -> showPicture(controller.execute(Constants.LEFT)));
    }

    @FXML
    void goForward() {
        forward.setOnAction(e -> {
            Picture picture = controller.execute(Constants.FORWARD);
            if (Objects.isNull(picture)) {
                showErrorMessage("no way!!!");
                return;
            }
            showPicture(picture);
            addRoomView(controller.getRoomViews());
        });
    }

    @FXML
    void goRight() {
        right.setOnAction(e -> showPicture(controller.execute(Constants.RIGHT)));
    }

    private void addRoomView(List<Item> items) {
        roomBox.getChildren().clear();
        for (int i = 0; i < items.size(); i++) {
            final Integer index = i;
            ImageView imageView = new ImageView(items.get(i).getImage());
            VBox.setMargin(imageView, new Insets(0.0, 0.0, 10.0, 10.0));
            roomBox.getChildren().add(imageView);
            imageView.setOnMouseClicked(e -> {
                addRoomView(controller.refreshRoomView(index));
                addBasketView(controller.getBasketViews());
            });
        }
    }

    private void addBasketView(List<Item> items) {
        basketBox.getChildren().clear();
        for (int i = 0; i < items.size(); i++) {
            final Integer index = i;
            ImageView imageView = new ImageView(items.get(i).getImage());
            VBox.setMargin(imageView, new Insets(0.0, 0.0, 10.0, 10.0));
            basketBox.getChildren().add(imageView);
            imageView.setOnMouseClicked(e -> {
                addBasketView(controller.refreshBasketView(index));
                addRoomView(controller.getRoomViews());
            });
        }
    }

    private void showPicture(Picture picture) {
        clearErrorMessage();
        imageView.setImage(picture.getImage());
        setCaption(picture.getFullName());
    }

    private void setCaption(String caption) {
        captionLabel.setText(caption);
    }

    private void showErrorMessage(String message) {
        errorLabel.setText(message);
    }

    private void clearErrorMessage() {
        errorLabel.setText("");
    }

}
