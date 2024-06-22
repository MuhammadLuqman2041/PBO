package data;

import com.main.LibrarySystem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import util.iMenu;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.util.Random;

public class Admin extends User implements iMenu {

    //=================================== ATRIBUT =====================================
    public static String adminusername = "admin";
    public static String adminpassword = "admin";

    //=================================== Main & Start Method ==================================

    //======================================= MENU Method =======================================
    @Override
    public void menu() {
        Stage adminMenuStage = new Stage();
        adminMenuStage.setTitle("UMM Library - Admin Menu");

        //Label
        Label sceneTitle = new Label("Menu Admin");

        Image image = new Image("file:src/main/java/GambarRevisi.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(720);
        imageView.setFitWidth(1280);
        imageView.setPreserveRatio(false);

        //Font Style
        sceneTitle.setFont(Font.font("Montserrat", FontWeight.BOLD, 20));

        //Font Color
        sceneTitle.setStyle("-fx-text-fill: #A91D3A;");

        //Button
        Button tombolTambahMahasiswa = new Button("Tambah Mahasiswa");
        Button tombolTampilkanMahasiswa = new Button("Daftar Mahasiswa");
        Button tombolTambahBuku = new Button("Tambah Buku");
        Button tombolKeluar = new Button("Logout");

        //untuk style tombol menunya wkwkwk
        tombolTambahMahasiswa.setFont(Font.font("Montserrat", FontWeight.BOLD, 14));
        tombolTampilkanMahasiswa.setFont(Font.font("Roboto", FontWeight.BOLD, 14));
        tombolTambahBuku.setFont(Font.font("Roboto", FontWeight.BOLD, 14));
        tombolKeluar.setFont(Font.font("Roboto", FontWeight.BOLD, 14));

        //Grid Layout
        GridPane tataletak = new GridPane();
        tataletak.setAlignment(Pos.CENTER);

        //grid.add(sceneTitle, 0, 1);

        tataletak.add(tombolTambahMahasiswa, 0, 2);
        tataletak.add(tombolTampilkanMahasiswa, 1, 2);
        tataletak.add(tombolTambahBuku, 2, 2);
        tataletak.add(tombolKeluar, 3, 2);

        tataletak.setVgap(121);
        tataletak.setHgap(175);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(imageView, tataletak);

        Scene scene = new Scene(stackPane, 1280, 720);
        adminMenuStage.setScene(scene);
        adminMenuStage.show();

        //Action Button
        tombolTambahMahasiswa.setOnAction(event -> {
            addstudent();
            adminMenuStage.close();
        });

        tombolTampilkanMahasiswa.setOnAction(event -> {
            displaystudent();
            adminMenuStage.close();
        });

        tombolTambahBuku.setOnAction(event -> {
            inputBook();
            adminMenuStage.close();
        });

        tombolKeluar.setOnAction(event -> {
            LibrarySystem librarySystemObj = new LibrarySystem();
            librarySystemObj.start(new Stage());
            adminMenuStage.close();
        });

    }

    //===================================== Other Method =======================================
    public void addstudent() {

        // Membuat form baru
        Stage addStudentStage = new Stage();
        addStudentStage.setTitle("Tambah Mahasiswa");

        Image image = new Image("file:src/main/java/GambarBaruAdmin.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(1280);
        imageView.setFitHeight(720);
        imageView.setPreserveRatio(false);

        //Label
        Label judulScene = new Label("Masukkan Data Mahasiswa ");
        Label labelNama = new Label("Nama");
        Label labelNim = new Label("NIM");
        Label fakultasLabel = new Label("Fakultas");
        Label labelJurusan = new Label("Jurusan");

        //Notification Label
        Label submitGagal = new Label("NIM harus 15 digit!");
        submitGagal.setVisible(false);

        //Field
        TextField inputNama = new TextField();
        TextField inputNim = new TextField();
        TextField inputFakultas = new TextField();
        TextField inputJurusan = new TextField();

        //Font Style
        judulScene.setFont(Font.font("Montserrat", FontWeight.BOLD, 20));
        labelNama.setFont(Font.font("Roboto", FontWeight.NORMAL, 15));
        labelNim.setFont(Font.font("Roboto", FontWeight.NORMAL, 15));
        fakultasLabel.setFont(Font.font("Roboto", FontWeight.NORMAL, 15));
        labelJurusan.setFont(Font.font("Roboto", FontWeight.NORMAL, 15));

        //Font Color
        judulScene.setStyle("-fx-text-fill: #A91D3A;");
        submitGagal.setStyle("-fx-text-fill: #FF1E1E;");

        //Button
        Button tombolSubmit = new Button("Submit");
        Button tombolKembali = new Button("Kembali");

        //Grid Layout
        GridPane tataletak = new GridPane();
        tataletak.setAlignment(Pos.CENTER);
        tataletak.add(judulScene, 1, 1);

        tataletak.add(labelNama, 0, 3);
        tataletak.add(labelNim, 0, 4);
        tataletak.add(fakultasLabel, 0, 5);
        tataletak.add(labelJurusan, 0, 6);

        tataletak.add(inputNama, 1, 3);
        tataletak.add(inputNim, 1, 4);
        tataletak.add(inputFakultas, 1, 5);
        tataletak.add(inputJurusan, 1, 6);

        tataletak.add(tombolSubmit, 1, 7);
        tataletak.add(tombolKembali, 0, 7);

        tataletak.add(submitGagal, 0, 8);

        tataletak.setVgap(35);
        tataletak.setHgap(5);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(imageView, tataletak);

        Scene scene = new Scene(stackPane, 1280, 720);
        addStudentStage.setScene(scene);
        addStudentStage.show();

        //Action Button
        tombolSubmit.setOnAction(event -> {
            if (inputNim.getText().length() == 15) {
                Admin adminObj = new Admin();

                Student.dataMahasiswa.add(new Student.UserStudent(inputNama.getText(), inputNim.getText(), inputFakultas.getText(), inputJurusan.getText()));
                adminObj.menu();
                addStudentStage.close();

            } else {
                submitGagal.setVisible(true);
            }
        });

        tombolKembali.setOnAction(event -> {
            Admin adminObj = new Admin();
            adminObj.menu();
            addStudentStage.close();
        });
    }

    public void displaystudent() {
        // Membuat stage baru
        Stage displayStudentStage = new Stage();
        displayStudentStage.setTitle("UMM Library - Daftar Mahasiswa");


        Image image = new Image("file:src/main/java/GambarDaftarMahasiswa.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(1280);
        imageView.setFitHeight(720);
        imageView.setPreserveRatio(false);
        //Label
        Label sceneTitle = new Label("Daftar Mahasiswa");

        //Font Style
        sceneTitle.setFont(Font.font("Montserrat", FontWeight.BOLD, 20));

        //Font Color
        sceneTitle.setStyle("-fx-text-fill: #A91D3A;");

        // Membuat ListView untuk menampilkan mahasiswa
        ListView<String> listView = new ListView<>();

        for (Student.UserStudent i : Student.dataMahasiswa) {
            String studentInfo = "Nama     : " + i.nama + "\n" +
                    "NIM      : " + i.nim + "\n" +
                    "Fakultas : " + i.fakultas + "\n" +
                    "Prodi    : " + i.prodi + "\n" +
                    "===========================";
            listView.getItems().add(studentInfo);
        }

        //Button
        Button tombolKembali = new Button("Kembali");

        //Grid Layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);

        grid.add(sceneTitle, 0, 2);
        grid.add(listView, 0,4 );
        grid.add(tombolKembali, 0, 5);

        grid.setVgap(10);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(imageView,grid);

        Scene scene = new Scene(stackPane, 1280, 720);
        displayStudentStage.setScene(scene);
        displayStudentStage.show();

        //Action Button
        tombolKembali.setOnAction(event -> {
            Admin adminObj = new Admin();
            adminObj.menu();
            displayStudentStage.close();
        });
    }

    public void inputBook() {
        super.inputBook();
    }


    public String generateId() {
        Random random = new Random();

        StringBuilder idTengah = new StringBuilder();
        StringBuilder idAkhir = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            idTengah.append(random.nextInt(10));
            idAkhir.append(random.nextInt(10));

        }
        return ("UMM-" + idTengah + "-" + idAkhir);
    }
}