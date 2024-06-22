package com.main;

import data.Admin;
import data.Student;
import exception.custom.IllegalAdminAccess;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class LibrarySystem extends Application {

    public static String NIM;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Admin admin = new Admin();
        Student student = new Student();

        primaryStage.setTitle("UMM Library");
        Image image = new Image("file:src/main/java/gambarDepan.png");
        ImageView imageView = new ImageView(image);

        imageView.setFitWidth(1280);
        imageView.setFitHeight(720);
        imageView.setPreserveRatio(false);

        //Label
        Label sceneTitle    = new Label("Login to Library");
        Label labelNamaPengguna = new Label("Nama pengguna");
        Label labelKataSandi = new Label("Kata Sandi");

        //Notification label
        Label pesanLoginGagal = new Label("Pengguna tidak ditemukan");

        //Field
        TextField inputNamaPengguna = new TextField();
        PasswordField inputKataSandi = new PasswordField();

        //Font Style
        sceneTitle.setFont(Font.font("Montserrat", FontWeight.BOLD, 20));
        labelNamaPengguna.setFont(Font.font("Roboto", FontWeight.NORMAL, 15));
        labelKataSandi.setFont(Font.font("Roboto", FontWeight.NORMAL, 15));
        pesanLoginGagal.setFont(Font.font("Roboto", FontWeight.NORMAL, 12));

        //Font Color
        sceneTitle.setStyle("-fx-text-fill: #FFFFFF;");
        pesanLoginGagal.setStyle("-fx-text-fill: #FF1E1E;");

        labelNamaPengguna.setStyle("-fx-text-fill: #FFD700;");
        labelKataSandi.setStyle("-fx-text-fill: #FFD700;");

        //Font visible Settings
        pesanLoginGagal.setVisible(false);

        //Button
        Button tombolMasuk = new Button("Masuk");

        //Grid Layout
        GridPane tataletak = new GridPane();
        tataletak.setAlignment(Pos.CENTER);

        tataletak.add(sceneTitle, 0,0);

        tataletak.add(labelNamaPengguna, 0,1);
        tataletak.add(labelKataSandi, 0,2);
        tataletak.add(pesanLoginGagal, 0,3);

        tataletak.add(inputNamaPengguna, 1,1);
        tataletak.add(inputKataSandi, 1,2);

        tataletak.add(tombolMasuk, 1,3);

        tataletak.setVgap(10);
        tataletak.setHgap(5);

        //Create Window
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(imageView, tataletak);
        Scene scene =  new Scene(stackPane,1280,720);

        primaryStage.setScene(scene);
        primaryStage.show();

        //Action Button
        tombolMasuk.setOnAction(event ->{
            if(inputNamaPengguna.getText().equals(Admin.adminusername) && inputKataSandi.getText().equals(Admin.adminpassword)) {


                admin.menu();
                primaryStage.close();

            }else if(inputNamaPengguna.getText().length() == 15 && inputKataSandi.getText().length() < 15){

                try {
                    if(student.isStudents(inputNamaPengguna)){
                        pesanLoginGagal.setVisible(false);

                        student.isStudents(inputNamaPengguna);

                    }else{
                        pesanLoginGagal.setVisible(true);
                    }
                } catch (IllegalAdminAccess pesanError) {
                    pesanLoginGagal.setText(pesanError.getMessage());
                    pesanLoginGagal.setVisible(true);
                }
            }else{
                pesanLoginGagal.setVisible(true);
            }
        });
    }
}