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
        // Set judul untuk primary stage
        primaryStage.setTitle("Sistem Perpustakaan");

        // Muat dan atur gambar latar belakang
        Image imageLibrary = new Image("file:src/main/java/MainGambar.png");
        ImageView imageViewLibrary = new ImageView(imageLibrary);
        imageViewLibrary.setFitHeight(720);
        imageViewLibrary.setFitWidth(1280);
        imageViewLibrary.setPreserveRatio(false);

        // Persiapkan tombol dan ikon untuk admin
        Image imageAdmin = new Image("file:src/main/java/AdminLoginIcon.png");
        ImageView imageViewAdmin = new ImageView(imageAdmin);
        imageViewAdmin.setFitWidth(117);
        imageViewAdmin.setFitHeight(22);
        imageViewAdmin.setPreserveRatio(true);
        Button adminButton = new Button("Masuk Admin");
        adminButton.setGraphic(imageViewAdmin);
        adminButton.setStyle("-fx-background-color: rgb(220, 0, 0); -fx-text-fill: #ffff; -fx-font-size: 15px; -fx-background-radius: 30;");
        adminButton.setTranslateX(-80);
        adminButton.setTranslateY(40);

        // Persiapkan tombol dan ikon untuk mahasiswa
        Image imageStudent = new Image("file:src/main/java/UserLoginIcon.png");
        ImageView imageViewStudent = new ImageView(imageStudent);
        imageViewStudent.setFitWidth(112);
        imageViewStudent.setFitHeight(17);
        imageViewStudent.setPreserveRatio(true);
        Button studentButton = new Button("Masuk Mahasiswa");
        studentButton.setGraphic(imageViewStudent);
        studentButton.setStyle("-fx-background-color: rgb(220, 0, 0); -fx-text-fill: #ffff; -fx-font-size: 15px; -fx-background-radius: 30;");
        studentButton.setTranslateX(-60);
        studentButton.setTranslateY(40);

        // Aksi saat tombol admin diklik
        adminButton.setOnAction(event -> {
            LoginAdmin loginAdmin = new LoginAdmin();
            loginAdmin.adminlogin();
            primaryStage.close();
        });

        // Aksi saat tombol mahasiswa diklik
        studentButton.setOnAction(event -> {
            StudentLogin studentLogin = new StudentLogin();
            studentLogin.LoginStudent();
            primaryStage.close();
        });

        // Setup layout grid untuk tombol admin dan mahasiswa
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_RIGHT);
        grid.setHgap(50);
        grid.add(adminButton, 0, 0);
        grid.add(studentButton, 1, 0);

        // Setup stack pane untuk menambahkan gambar latar belakang dan grid tombol
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(imageViewLibrary, grid);

        // Setup scene dengan stack pane sebagai root
        Scene scene = new Scene(stackPane, 1280, 720);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
