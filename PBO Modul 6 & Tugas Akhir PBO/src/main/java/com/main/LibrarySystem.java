package com.main;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LibrarySystem extends Application {

    public static String NIM;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("halaman");

        Image imageLibrary = new Image("file:src/main/java/PerubahanGambar1.png");
        ImageView imageViewLibrary = new ImageView(imageLibrary);
        imageViewLibrary.setFitHeight(720);
        imageViewLibrary.setFitWidth(1280);
        imageViewLibrary.setPreserveRatio(false);

        Image imageL = new Image("file:src/main/java/AdminLoginIcon.png");
        ImageView imageView1 = new ImageView(imageL);
        imageView1.setFitWidth(120);
        imageView1.setFitHeight(30);
        imageView1.setPreserveRatio(true); // Preserve ratio
        Button adminButton = new Button("Masuk Admin");
        adminButton.setGraphic(imageView1);
        adminButton.setStyle("-fx-background-color: rgb(220, 0, 0); -fx-text-fill: #ffff; -fx-font-size: 15px; -fx-background-radius: 30;");
        adminButton.setTranslateX(-80);
        adminButton.setTranslateY(40);// Make button background transparent

        Image imageL1 = new Image("file:src/main/java/UserLoginIcon.png");
        ImageView imageViewL1 = new ImageView(imageL1);
        imageViewL1.setFitWidth(120);
        imageViewL1.setFitHeight(30);
        imageViewL1.setPreserveRatio(true); // Preserve ratio
        Button studentButton = new Button("Masuk Mahasiswa");
        studentButton.setGraphic(imageViewL1);
        studentButton.setStyle("-fx-background-color: rgb(220, 0, 0); -fx-text-fill: #ffff; -fx-font-size: 15px; -fx-background-radius: 30;");
        studentButton.setTranslateX(-60);
        studentButton.setTranslateY(40);/// Make button background transparent


        adminButton.setOnAction(event -> {
            LoginAdmin loginAdmin = new LoginAdmin();
            loginAdmin.adminlogin();
            primaryStage.close();
        });

        studentButton.setOnAction(event -> {
            StudentLogin studentLogin = new StudentLogin();
            studentLogin.LoginStudent();
            primaryStage.close();
        });

        // Layout setup
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_RIGHT);
        grid.setHgap(50);
        grid.add(adminButton, 0, 0);
        grid.add(studentButton, 1, 0);


        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(imageViewLibrary,grid);

        Scene scene = new Scene(stackPane, 1280, 720);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

