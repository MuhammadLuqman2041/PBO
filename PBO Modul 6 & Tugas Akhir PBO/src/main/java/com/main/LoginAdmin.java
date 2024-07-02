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
        Stage tampilanAdmin = new Stage();
        Admin admin = new Admin();

        tampilanAdmin.setTitle("UMM Library");
        Image image = new Image("file:src/main/java/PerubahanGambar4.png");
        ImageView imageView = new ImageView(image);

        imageView.setFitWidth(1280);
        imageView.setFitHeight(720);
        imageView.setPreserveRatio(false);

        // Pengaturan font dan gaya
        Label sceneTitle = new Label("Masuk ke Perpustakaan");
        sceneTitle.setFont(Font.font("Montserrat", FontWeight.BOLD, 20));
        sceneTitle.setStyle("-fx-text-fill: #FFFFFF;");

        // Pengaturan grid untuk admin
        GridPane adminGrid = new GridPane();
        adminGrid.setAlignment(Pos.CENTER);
        adminGrid.setVgap(25);
        adminGrid.setHgap(30);

        /*Label adminLabelNamaPengguna = new Label("USERNAME");
        adminLabelNamaPengguna.setFont(Font.font("Roboto", FontWeight.BOLD, 15));
        adminLabelNamaPengguna.setStyle("-fx-text-fill: #FFFFFF;");

        Label adminLabelKataSandi = new Label("KATA SANDI");
        adminLabelKataSandi.setFont(Font.font("Roboto", FontWeight.BOLD, 15));
        adminLabelKataSandi.setStyle("-fx-text-fill: #FFFFFF;");*/

        TextField adminInputNamaPengguna = new TextField();
        adminInputNamaPengguna.setPromptText("Nama Pengguna");
        PasswordField adminInputKataSandi = new PasswordField();
        adminInputKataSandi.setPromptText("Kata Sandi");

        Button adminTombolMasuk = new Button("Login");
        adminTombolMasuk.setPrefSize(300,30);
        adminTombolMasuk.setStyle("-fx-background-color: #4267B2; -fx-text-fill: #FFFFFF; -fx-font-size: 15px;");
        Label adminPesanLoginGagal = new Label("Pengguna tidak ditemukan");
        adminPesanLoginGagal.setFont(Font.font("Roboto", FontWeight.NORMAL, 12));
        adminPesanLoginGagal.setStyle("-fx-text-fill: #FF1E1E;");
        adminPesanLoginGagal.setVisible(false);

        adminGrid.add(sceneTitle, 0, 0, 2, 1);
        /*adminGrid.add(adminLabelNamaPengguna, 0, 1);*/
        adminGrid.add(adminInputNamaPengguna, 1, 1);
        /*adminGrid.add(adminLabelKataSandi, 0, 2);*/
        adminGrid.add(adminInputKataSandi, 1, 2);
        adminGrid.add(adminTombolMasuk, 1, 3);
        adminGrid.add(adminPesanLoginGagal, 1, 4);
        adminGrid.setTranslateY(70);

        adminTombolMasuk.setOnAction(event -> {
            if (adminInputNamaPengguna.getText().equals(Admin.adminusername) &&
                    adminInputKataSandi.getText().equals(Admin.adminpassword)) {

                admin.menu();
                tampilanAdmin.close();
            } else {
                adminPesanLoginGagal.setVisible(true);
                adminInputKataSandi.clear(); // Kosongkan password jika gagal
            }
        });

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(imageView,adminGrid);

        Scene scene = new Scene(stackPane, 1280, 720);
        tampilanAdmin.setScene(scene);
        tampilanAdmin.show();
    }
}

