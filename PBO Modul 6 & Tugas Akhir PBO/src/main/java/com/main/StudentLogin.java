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
        Stage tampilanStudent = new Stage();
        tampilanStudent.setTitle("student");
        Student student = new Student();

        GridPane studentGrid = new GridPane();
        studentGrid.setAlignment(Pos.CENTER);
        studentGrid.setVgap(10);
        studentGrid.setHgap(5);

        Image image = new Image("file:src/main/java/gmb.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(1280);
        imageView.setFitHeight(720);

        TextField studentInputNamaPengguna = new TextField();
        studentInputNamaPengguna.setPromptText("Masukkan NIM");
        studentInputNamaPengguna.setTranslateY(50);

        Button studentTombolMasuk = new Button("Masuk");
        studentTombolMasuk.setPrefSize(300,30);
        studentTombolMasuk.setTranslateY(50);
        studentTombolMasuk.setStyle("-fx-background-color: #4267B2; -fx-text-fill: #FFFFFF; -fx-font-size: 15px;");
        Label studentPesanLoginGagal = new Label("Pengguna tidak ditemukan");
        studentPesanLoginGagal.setFont(Font.font("Roboto", FontWeight.NORMAL, 12));
        studentPesanLoginGagal.setStyle("-fx-text-fill: #FF1E1E;");
        studentPesanLoginGagal.setVisible(false);

        studentGrid.add(studentInputNamaPengguna, 1, 0);
        studentGrid.add(studentTombolMasuk, 1, 2);
        studentGrid.add(studentPesanLoginGagal, 1, 3);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(imageView, studentGrid);

        Scene scene = new Scene(stackPane, 1280, 720);
        tampilanStudent.setScene(scene);
        tampilanStudent.show();

        studentTombolMasuk.setOnAction(event -> {
            if (studentInputNamaPengguna.getText().length() == 15) {
                try {
                    if (student.isStudents(studentInputNamaPengguna)) {
                        studentPesanLoginGagal.setVisible(false);
                    } else {
                        studentPesanLoginGagal.setVisible(true);
                    }
                } catch (IllegalAdminAccess pesanError) {
                    studentPesanLoginGagal.setText(pesanError.getMessage());
                    studentPesanLoginGagal.setVisible(true);
                }
            } else {
                studentPesanLoginGagal.setVisible(true);
            }
        });

        studentGrid.requestFocus(); // Memastikan promptText terlihat
    }
}
