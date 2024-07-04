package com.main;

import data.Admin;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class LoginAdmin {

    public void adminlogin() {
        // Membuat stage baru untuk tampilan login admin
        Stage adminStage = new Stage();
        adminStage.setTitle("UMM Library");
        Admin admin = new Admin(); // Objek admin untuk memproses data admin

        // Memuat dan menampilkan gambar latar belakang
        Image backgroundImage = new Image("file:src/main/java/PerubahanGambar4.png");
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setFitWidth(1280);
        backgroundImageView.setFitHeight(720);
        backgroundImageView.setPreserveRatio(false);

        // Judul "Masuk ke Perpustakaan"
        Label titleLabel = new Label("Masuk ke Perpustakaan");
        titleLabel.setFont(Font.font("Montserrat", FontWeight.BOLD, 20));
        titleLabel.setTranslateX(65);
        titleLabel.setStyle("-fx-text-fill: #FFFFFF;");

        // GridPane untuk menyusun elemen-elemen secara teratur
        GridPane adminGrid = new GridPane();
        adminGrid.setAlignment(Pos.CENTER);
        adminGrid.setVgap(25);
        adminGrid.setHgap(30);

        // Label dan input field untuk nama pengguna admin
        TextField adminUsernameInput = new TextField();
        adminUsernameInput.setPromptText("Nama Pengguna");

        // Label dan input field untuk kata sandi admin
        PasswordField adminPasswordInput = new PasswordField();
        adminPasswordInput.setPromptText("Kata Sandi");

        // Tombol "Login"
        Button loginButton = new Button("Login");
        loginButton.setPrefSize(300,30);
        loginButton.setStyle("-fx-background-color: #4267B2; -fx-text-fill: #FFFFFF; -fx-font-size: 15px;");

        // Label untuk pesan kesalahan saat login gagal
        Label loginFailedLabel = new Label("Pengguna tidak ditemukan");
        loginFailedLabel.setFont(Font.font("Roboto", FontWeight.NORMAL, 12));
        loginFailedLabel.setStyle("-fx-text-fill: #FF1E1E;");
        loginFailedLabel.setVisible(false);

        // Menambahkan elemen-elemen ke dalam GridPane
        adminGrid.add(titleLabel, 0, 0, 2, 1);
        adminGrid.add(adminUsernameInput, 1, 1);
        adminGrid.add(adminPasswordInput, 1, 2);
        adminGrid.add(loginButton, 1, 3);
        adminGrid.add(loginFailedLabel, 1, 4);
        adminGrid.setTranslateY(70);

        // Aksi saat tombol "Login" ditekan
        loginButton.setOnAction(event -> {
            if (adminUsernameInput.getText().equals(Admin.adminusername) &&
                    adminPasswordInput.getText().equals(Admin.adminpassword)) {
                admin.menu(); // Memanggil menu admin jika login berhasil
                adminStage.close(); // Menutup jendela login admin
            } else {
                loginFailedLabel.setVisible(true); // Menampilkan pesan kesalahan jika login gagal
                adminPasswordInput.clear(); // Mengosongkan password jika login gagal
            }
        });

        // StackPane untuk menampilkan gambar latar belakang dan GridPane di atasnya
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(backgroundImageView, adminGrid);

        // Membuat scene dan menampilkannya di stage
        Scene scene = new Scene(stackPane, 1280, 720);
        adminStage.setScene(scene);
        adminStage.show();
    }
}
