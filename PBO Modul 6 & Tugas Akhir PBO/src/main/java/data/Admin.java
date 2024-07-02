package data;

import com.main.LibrarySystem;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import util.iMenu;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.util.Random;

public class Admin extends User implements iMenu {

    public static String adminusername = "admin";
    public static String adminpassword = "admin";

    @Override
    public void menu() {
        Stage adminMenuStage = new Stage();
        adminMenuStage.setTitle("UMM Library - Admin Menu");

        //Label
        Label sceneTitle = new Label("Menu Admin");
        Hyperlink hyperlink = new Hyperlink("lihat map");

        Image image = new Image("file:src/main/java/ADMIN1.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(720);
        imageView.setFitWidth(1280);
        imageView.setPreserveRatio(false);

        //Font Style
        sceneTitle.setFont(Font.font("Montserrat", FontWeight.BOLD, 20));

        //Font Color
        sceneTitle.setStyle("-fx-text-fill: #A91D3A;");

        //Button
        Image imageb1 = new Image("file:src/main/java/image(1).png");
        ImageView imageView1 = new ImageView(imageb1);
        imageView1.setFitWidth(380);
        imageView1.setFitHeight(280);
        Button tombolTambahMahasiswa = new Button();
        tombolTambahMahasiswa.setGraphic(imageView1);
        tombolTambahMahasiswa.setStyle("-fx-background-color: transparent;");
        tombolTambahMahasiswa.setTranslateY(-60);// semakin berkurang semakin ke atas
        tombolTambahMahasiswa.setTranslateX(170);


        Image imageb2 = new Image("file:src/main/java/image(3).png");
        ImageView imageView2 = new ImageView(imageb2);
        imageView2.setFitWidth(380);
        imageView2.setFitHeight(250);
        Button tombolTampilkanMahasiswa = new Button();
        tombolTampilkanMahasiswa.setGraphic(imageView2);
        tombolTampilkanMahasiswa.setStyle("-fx-background-color: transparent;");
        tombolTampilkanMahasiswa.setTranslateY(-60);
        tombolTampilkanMahasiswa.setTranslateX(50);


        Button tombolTambahBuku = new Button();
        Image imageb3 = new Image("file:src/main/java/image(2).png");
        ImageView imageView3 = new ImageView(imageb3);
        imageView3.setFitWidth(380);
        imageView3.setFitHeight(280);
        tombolTambahBuku.setGraphic(imageView3);
        tombolTambahBuku.setStyle("-fx-background-color: transparent;");
        tombolTambahBuku.setTranslateY(-60);
        tombolTambahBuku.setTranslateX(-50);

        Image imageL = new Image("file:src/main/java/LogoutIcon.png");
        ImageView imageViewq = new ImageView(imageL);
        imageViewq.setFitWidth(120);
        imageViewq.setFitHeight(30);
        imageViewq.setPreserveRatio(true);
        Button tombolKeluar = new Button("Keluar");
        tombolKeluar.setGraphic(imageViewq);
        tombolKeluar.setStyle("-fx-background-color: rgb(220, 0, 0); -fx-text-fill: #ffff; -fx-font-size: 15px; -fx-background-radius: 30;");
        tombolKeluar.setTranslateX(120);
        tombolKeluar.setTranslateY(-90);

        //untuk style tombol menunya wkwkwk
        tombolTambahMahasiswa.setFont(Font.font("Montserrat", FontWeight.BOLD, 14));
        tombolTampilkanMahasiswa.setFont(Font.font("Roboto", FontWeight.BOLD, 14));
        tombolTambahBuku.setFont(Font.font("Roboto", FontWeight.BOLD, 14));
        //tombolKeluar.setFont(Font.font("Roboto", FontWeight.BOLD, 14));

        //Grid Layout
        GridPane tataletak = new GridPane();
        tataletak.setAlignment(Pos.CENTER);

        //grid.add(sceneTitle, 0, 1);

        tataletak.add(tombolTambahMahasiswa, 0, 2);
        tataletak.add(tombolTampilkanMahasiswa, 1, 2);
        tataletak.add(tombolTambahBuku, 2, 2);
        tataletak.add(tombolKeluar, 2, 0);
        tataletak.add(hyperlink, 3, 2);

        tataletak.setVgap(60);
        tataletak.setHgap(90);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(imageView,tataletak);

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
    public void addstudent () {

        // Membuat form baru
        Stage addStudentStage = new Stage();
        addStudentStage.setTitle("Tambah Mahasiswa");

        Image image = new Image("file:src/main/java/Tes.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(1280);
        imageView.setFitHeight(720);
        imageView.setPreserveRatio(false);

        //Label
        Label judulScene = new Label("Masukkan Data Mahasiswa ");
        judulScene.setTranslateY(30);
        judulScene.setTranslateX(30);

        //Label Notifikasi
        Label submitGagal = new Label("NIM Harus 15 Digit!");
        submitGagal.setVisible(false);

        //Input
        TextField inputNama = new TextField();
        inputNama.setPromptText("Nama");
        inputNama.setPrefSize(600,30);
        TextField inputNim = new TextField();
        inputNim.setPromptText("NIM");
        inputNim.setPrefSize(600,30);
        TextField inputFakultas = new TextField();
        inputFakultas.setPromptText("Fakultas");
        inputFakultas.setPrefSize(600,30);
        TextField inputJurusan = new TextField();
        inputJurusan.setPromptText("Jurusan");
        inputJurusan.setPrefSize(600,30);

        inputNim.setTranslateX(-150);
        inputFakultas.setTranslateX(-150);
        inputNama.setTranslateX(-150);
        inputJurusan.setTranslateX(-150);

        //Font Style
        judulScene.setFont(Font.font("Montserrat", FontWeight.BOLD, 20));

        //Font Color
        judulScene.setStyle("-fx-text-fill: #FFFFFF;");
        submitGagal.setStyle("-fx-text-fill: #FF1E1E;");

        //Button
        Button tombolSubmit = new Button("Kirim");
        tombolSubmit.setPrefSize(300,30);
        tombolSubmit.setTranslateX(150);
        tombolSubmit.setStyle("-fx-background-color: #4267B2; -fx-text-fill: #FFFFFF; -fx-font-size: 15px;");
        Button tombolKembali = new Button("Kembali");
        tombolKembali.setPrefSize(300,30);
        tombolKembali.setTranslateX(150);
        tombolKembali.setStyle("-fx-background-color: #4267B2; -fx-text-fill: #FFFFFF; -fx-font-size: 15px;");

        //Grid Layout
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(judulScene, 1, 1);
        gridPane.add(inputNama, 1, 3);
        gridPane.add(inputNim, 1, 4);
        gridPane.add(inputFakultas, 1, 5);
        gridPane.add(inputJurusan, 1, 6);
        gridPane.add(tombolSubmit, 1, 7);
        gridPane.add(tombolKembali, 0, 7);
        gridPane.add(submitGagal, 0, 8);
        gridPane.setVgap(35);
        gridPane.setHgap(5);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(imageView, gridPane);

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
        tombolKembali.setStyle("-fx-background-color: #4267B2; -fx-text-fill: #FFFFFF; -fx-font-size: 15px;");
        tombolKembali.setPrefSize(600,30);

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
