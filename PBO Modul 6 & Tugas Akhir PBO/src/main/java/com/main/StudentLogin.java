package com.main;

import data.Student;
import exception.custom.IllegalAdminAccess;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class StudentLogin {

    public void LoginStudent() {
        // Membuat stage baru untuk tampilan login mahasiswa
        Stage studentStage = new Stage();
        studentStage.setTitle("Login Mahasiswa");
        Student student = new Student(); // Objek untuk memproses data mahasiswa

        // GridPane untuk menyusun elemen-elemen secara teratur
        GridPane studentGrid = new GridPane();
        studentGrid.setAlignment(Pos.CENTER);
        studentGrid.setVgap(10);
        studentGrid.setHgap(5);

        // Label judul "Student Login"
        Label titleLabel = new Label("Student Login");
        titleLabel.setFont(Font.font("Montserrat", FontWeight.BOLD, 20));
        titleLabel.setTranslateX(85);
        titleLabel.setTranslateY(65);
        titleLabel.setStyle("-fx-text-fill: #FFFFFF;");

        // Gambar latar belakang
        Image backgroundImage = new Image("file:src/main/java/studentFoto.png");
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setFitWidth(1280);
        backgroundImageView.setFitHeight(720);

        // TextField untuk input NIM mahasiswa
        TextField studentUsernameInput = new TextField();
        studentUsernameInput.setPromptText("Masukkan NIM");
        studentUsernameInput.setTranslateY(70);

        // Tombol "Masuk"
        Button loginButton = new Button("Masuk");
        loginButton.setPrefSize(300,30);
        loginButton.setTranslateY(80);
        loginButton.setStyle("-fx-background-color: #4267B2; -fx-text-fill: #FFFFFF; -fx-font-size: 15px;");

        // Label untuk pesan kesalahan saat login gagal
        Label loginFailedLabel = new Label("Pengguna tidak ditemukan");
        loginFailedLabel.setFont(Font.font("Roboto", FontWeight.NORMAL, 12));
        loginFailedLabel.setStyle("-fx-text-fill: #FF1E1E;");
        loginFailedLabel.setVisible(false);

        // Menambahkan elemen-elemen ke dalam GridPane
        studentGrid.add(titleLabel, 1, 0);
        studentGrid.add(studentUsernameInput, 1, 1);
        studentGrid.add(loginButton, 1, 2);
        studentGrid.add(loginFailedLabel, 1, 3);

        // StackPane untuk menampilkan gambar latar belakang dan GridPane di atasnya
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(backgroundImageView, studentGrid);

        // Membuat scene dan menampilkannya di stage
        Scene scene = new Scene(stackPane, 1280, 720);
        studentStage.setScene(scene);
        studentStage.show();

        // Aksi saat tombol "Masuk" ditekan
        loginButton.setOnAction(event -> {
            if (studentUsernameInput.getText().length() == 15) { // Panjang NIM harus 15 karakter
                try {
                    if (student.isStudents(studentUsernameInput)) { // Memeriksa validitas mahasiswa
                        loginFailedLabel.setVisible(true); // Tampilkan pesan kesalahan
                        studentStage.close(); // Tutup jendela login mahasiswa
                    } else {
                        loginFailedLabel.setVisible(true); // Tampilkan pesan kesalahan
                    }
                } catch (IllegalAdminAccess error) {
                    loginFailedLabel.setText(error.getMessage()); // Menangani kesalahan kustom
                    loginFailedLabel.setVisible(false); // Sembunyikan pesan kesalahan
                }
            } else {
                loginFailedLabel.setVisible(true); // Tampilkan pesan kesalahan
            }
        });

        studentGrid.requestFocus(); // Fokus ke GridPane untuk memastikan promptText terlihat
    }
}
