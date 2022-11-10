package com.example.pluie_de_valentin;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class MainController implements Initializable {

    public AnchorPane anchor;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Timeline pluie_de_valentin = new Timeline(
                new KeyFrame(Duration.millis(100),
                        event -> {
                            ImageView valentin = new ImageView("valak.png");
                            valentin.setFitHeight(50);
                            valentin.setFitWidth(50);
                            anchor.getChildren().add(valentin);
                            valentin.setX(Math.floor(10 + Math.random() * (540 - 10)));
                            valentin.setY(20);
                        }));


        Timeline move_valentin = new Timeline(
                new KeyFrame(Duration.millis(10), event -> {
                    for (Node node : anchor.getChildren()) {
                        if (node.getTranslateY() > 860) {
                            anchor.getChildren().remove(node);
                            break;
                        } else {
                            node.setTranslateY(node.getTranslateY() + 1);
                        }
                    }
                }));

        pluie_de_valentin.setCycleCount(Timeline.INDEFINITE);
        pluie_de_valentin.play();

        move_valentin.setCycleCount(Timeline.INDEFINITE);
        move_valentin.play();
    }
}