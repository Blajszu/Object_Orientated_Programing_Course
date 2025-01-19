package agh.ics.oop;

import agh.ics.oop.model.WorldElement;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.util.HashMap;
import java.util.Map;

public class WorldElementBox {
    private final VBox container = new VBox();
    private final WorldElement element;
    private static final Map<String, Image> imageCache = new HashMap<>();

    public WorldElementBox(WorldElement element) {
        this.element = element;
        fillContent();
    }

    public VBox getGraphicBox() {
        return container;
    }

    public WorldElement getElement() {
        return element;
    }

    public void update() {
        container.getChildren().clear();
        fillContent();
    }

    private void fillContent() {
        Image image = getOrCreateImage(element.getResourceFileName());
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);

        Label label = new Label(element.getResourceName());
        label.setStyle("-fx-font-size: 10px;");
        container.getChildren().addAll(imageView, label);
        container.setAlignment(Pos.CENTER);
    }

    private Image getOrCreateImage(String resourceFileName) {
        return imageCache.computeIfAbsent(resourceFileName, Image::new);
    }
}