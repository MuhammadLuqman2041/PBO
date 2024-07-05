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

// Kelas Admin mewarisi kelas User dan mengimplementasikan interface iMenu
public class Admin extends User implements iMenu {

    // Informasi login admin (username dan password default)
    public static String adminusername = "admin";
    public static String adminpassword = "admin";

    @Override
    // Implementasi metode menu dari interface iMenu
    public void menu() {
        // Membuat stage untuk menu admin
        Stage adminMenuStage = new Stage();
        adminMenuStage.setTitle("UMM Library - Admin Menu");

        // Label untuk judul menu
        Label sceneTitle = new Label("Menu Admin");

        // Hyperlink untuk melihat peta
        Hyperlink hyperlink = new Hyperlink("lihat map");

        // Menampilkan latar belakang gambar admin
        Image image = new Image("file:src/main/java/ADMIN1.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(720);
        imageView.setFitWidth(1280);
        imageView.setPreserveRatio(false);

        // Pengaturan gaya font untuk judul
        sceneTitle.setFont(Font.font("Montserrat", FontWeight.BOLD, 20));

        // Pengaturan warna teks untuk judul
        sceneTitle.setStyle("-fx-text-fill: #A91D3A;");

        // Tombol-tombol untuk menu admin dengan gambar
        Image imageb1 = new Image("file:src/main/java/GmbrTambahMhs.png");
        ImageView imageView1 = new ImageView(imageb1);
        imageView1.setFitWidth(405);
        imageView1.setFitHeight(245);
        Button tombolTambahMahasiswa = new Button();
        tombolTambahMahasiswa.setGraphic(imageView1);
        tombolTambahMahasiswa.setStyle("-fx-background-color: transparent;");
        tombolTambahMahasiswa.setTranslateY(-10);
        tombolTambahMahasiswa.setTranslateX(140);

        Image imageb2 = new Image("file:src/main/java/image(3).png");
        ImageView imageView2 = new ImageView(imageb2);
        imageView2.setFitWidth(420);
        imageView2.setFitHeight(250);
        Button tombolTampilkanMahasiswa = new Button();
        tombolTampilkanMahasiswa.setGraphic(imageView2);
        tombolTampilkanMahasiswa.setStyle("-fx-background-color: transparent;");
        tombolTampilkanMahasiswa.setTranslateY(-10);
        tombolTampilkanMahasiswa.setTranslateX(20);

        Button tombolTambahBuku = new Button();
        Image imageb3 = new Image("file:src/main/java/image(2).png");
        ImageView imageView3 = new ImageView(imageb3);
        imageView3.setFitWidth(420);
        imageView3.setFitHeight(280);
        tombolTambahBuku.setGraphic(imageView3);
        tombolTambahBuku.setStyle("-fx-background-color: transparent;");
        tombolTambahBuku.setTranslateY(-10);
        tombolTambahBuku.setTranslateX(-100);

        // Tombol keluar dengan ikon logout
        Image imageL = new Image("file:src/main/java/LogoutIcon.png");
        ImageView imageViewq = new ImageView(imageL);
        imageViewq.setFitWidth(120);
        imageViewq.setFitHeight(30);
        imageViewq.setPreserveRatio(true);
        Button tombolKeluar = new Button("Keluar");
        tombolKeluar.setGraphic(imageViewq);
        tombolKeluar.setStyle("-fx-background-color: rgb(220, 0, 0); -fx-text-fill: #ffff; -fx-font-size: 15px; -fx-background-radius: 30;");
        tombolKeluar.setTranslateX(195);
        tombolKeluar.setTranslateY(-90);

        // Menetapkan gaya font untuk tombol menu
        tombolTambahMahasiswa.setFont(Font.font("Montserrat", FontWeight.BOLD, 14));
        tombolTampilkanMahasiswa.setFont(Font.font("Roboto", FontWeight.BOLD, 14));
        tombolTambahBuku.setFont(Font.font("Roboto", FontWeight.BOLD, 14));

        // Grid untuk menyusun tombol-tombol menu
        GridPane tataletak = new GridPane();
        tataletak.setAlignment(Pos.CENTER);
        tataletak.add(tombolTambahMahasiswa, 0, 2);
        tataletak.add(tombolTampilkanMahasiswa, 1, 2);
        tataletak.add(tombolTambahBuku, 2, 2);
        tataletak.add(tombolKeluar, 2, 0);
        tataletak.add(hyperlink, 3, 2);
        tataletak.setVgap(60);
        tataletak.setHgap(20);

        // StackPane untuk menampilkan latar belakang gambar dan grid menu admin
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(imageView, tataletak);

        // Menyiapkan scene dengan stackpane sebagai root node
        Scene scene = new Scene(stackPane, 1280, 720);
        adminMenuStage.setScene(scene);
        adminMenuStage.show();

        // Aksi ketika tombol-tombol menu ditekan
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
            // Kembali ke halaman utama saat tombol keluar ditekan
            LibrarySystem librarySystemObj = new LibrarySystem();
            librarySystemObj.start(new Stage());
            adminMenuStage.close();
        });
    }

    //===================================== Metode Lain =======================================

    // Metode untuk menambahkan data mahasiswa baru
    public void addstudent() {
        // Membuat stage untuk menambah data mahasiswa
        Stage addStudentStage = new Stage();
        addStudentStage.setTitle("Tambah Mahasiswa");

        // Menampilkan latar belakang gambar untuk halaman tambah mahasiswa
        Image image = new Image("file:src/main/java/Tes.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(1280);
        imageView.setFitHeight(720);
        imageView.setPreserveRatio(false);

        // Label judul untuk form tambah mahasiswa
        Label judulScene = new Label("Masukkan Data Mahasiswa");
        judulScene.setTranslateY(30);
        judulScene.setTranslateX(30);

        // Label untuk notifikasi kesalahan jika NIM tidak sesuai
        Label submitGagal = new Label("NIM Harus 15 Digit!");
        submitGagal.setVisible(false);

        // Input fields untuk nama, NIM, fakultas, dan jurusan mahasiswa
        TextField inputNama = new TextField();
        inputNama.setPromptText("Nama");
        inputNama.setPrefSize(600, 30);
        TextField inputNim = new TextField();
        inputNim.setPromptText("NIM");
        inputNim.setPrefSize(600, 30);
        TextField inputFakultas = new TextField();
        inputFakultas.setPromptText("Fakultas");
        inputFakultas.setPrefSize(600, 30);
        TextField inputJurusan = new TextField();
        inputJurusan.setPromptText("Jurusan");
        inputJurusan.setPrefSize(600, 30);

        // Menyesuaikan posisi input fields
        inputNim.setTranslateX(-150);
        inputFakultas.setTranslateX(-150);
        inputNama.setTranslateX(-150);
        inputJurusan.setTranslateX(-150);

        // Pengaturan gaya font untuk judul
        judulScene.setFont(Font.font("Montserrat", FontWeight.BOLD, 20));

        // Pengaturan warna teks untuk judul dan pesan kesalahan
        judulScene.setStyle("-fx-text-fill: #FFFFFF;");
        submitGagal.setStyle("-fx-text-fill: #FF1E1E;");

        // Tombol untuk submit data mahasiswa dan kembali ke menu admin
        Button tombolSubmit = new Button("Kirim");
        tombolSubmit.setPrefSize(300, 30);
        tombolSubmit.setTranslateX(150);
        tombolSubmit.setStyle("-fx-background-color: #4267B2; -fx-text-fill: #FFFFFF; -fx-font-size: 15px;");
        Button tombolKembali = new Button("Kembali");
        tombolKembali.setPrefSize(300, 30);
        tombolKembali.setTranslateX(150);
        tombolKembali.setStyle("-fx-background-color: #4267B2; -fx-text-fill: #FFFFFF; -fx-font-size: 15px;");

        // Grid untuk menyusun elemen-elemen form tambah mahasiswa
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

        // StackPane untuk menampilkan latar belakang gambar dan grid form tambah mahasiswa
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(imageView, gridPane);

        // Menyiapkan scene dengan stackpane sebagai root node
        Scene scene = new Scene(stackPane, 1280, 720);
        addStudentStage.setScene(scene);
        addStudentStage.show();

        // Aksi ketika tombol submit dan kembali ditekan
        tombolSubmit.setOnAction(event -> {
            if (inputNim.getText().length() == 15) {
                // Menambahkan data mahasiswa baru jika NIM valid
                Admin adminObj = new Admin();
                Student.dataMahasiswa.add(new Student.UserStudent(inputNama.getText(), inputNim.getText(), inputFakultas.getText(), inputJurusan.getText()));
                adminObj.menu();
                addStudentStage.close();
            } else {
                // Menampilkan pesan kesalahan jika NIM tidak valid
                submitGagal.setVisible(true);
            }
        });

        tombolKembali.setOnAction(event -> {
            // Kembali ke menu admin jika tombol kembali ditekan
            Admin adminObj = new Admin();
            adminObj.menu();
            addStudentStage.close();
        });
    }

    // Metode untuk menampilkan daftar mahasiswa
    public void displaystudent() {
        // Membuat stage untuk menampilkan daftar mahasiswa
        Stage displayStudentStage = new Stage();
        displayStudentStage.setTitle("UMM Library - Daftar Mahasiswa");

        // Menampilkan latar belakang gambar untuk halaman daftar mahasiswa
        Image image = new Image("file:src/main/java/GambarDaftarMahasiswa.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(1280);
        imageView.setFitHeight(720);
        imageView.setPreserveRatio(false);

        // Label judul untuk daftar mahasiswa
        Label sceneTitle = new Label("Daftar Mahasiswa");

        // Pengaturan gaya font untuk judul
        sceneTitle.setFont(Font.font("Montserrat", FontWeight.BOLD, 20));

        // Pengaturan warna teks untuk judul
        sceneTitle.setStyle("-fx-text-fill: #A91D3A;");

        // ListView untuk menampilkan daftar mahasiswa
        ListView<String> listView = new ListView<>();

        // Memasukkan data mahasiswa ke dalam ListView
        for (Student.UserStudent i : Student.dataMahasiswa) {
            String studentInfo = "Nama     : " + i.nama + "\n" +
                    "NIM      : " + i.nim + "\n" +
                    "Fakultas : " + i.fakultas + "\n" +
                    "Prodi    : " + i.prodi + "\n" +
                    "===========================";
            listView.getItems().add(studentInfo);
        }

        // Tombol untuk kembali ke menu admin
        Button tombolKembali = new Button("Kembali");
        tombolKembali.setStyle("-fx-background-color: #4267B2; -fx-text-fill: #FFFFFF; -fx-font-size: 15px;");
        tombolKembali.setPrefSize(600, 30);

        // Grid untuk menyusun elemen-elemen halaman daftar mahasiswa
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.add(sceneTitle, 0, 2);
        grid.add(listView, 0, 4);
        grid.add(tombolKembali, 0, 5);
        grid.setVgap(10);

        // StackPane untuk menampilkan latar belakang gambar dan grid daftar mahasiswa
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(imageView, grid);

        // Menyiapkan scene dengan stackpane sebagai root node
        Scene scene = new Scene(stackPane, 1280, 720);
        displayStudentStage.setScene(scene);
        displayStudentStage.show();

        // Aksi ketika tombol kembali ditekan
        tombolKembali.setOnAction(event -> {
            Admin adminObj = new Admin();
            adminObj.menu();
            displayStudentStage.close();
        });
    }

    // Metode untuk memasukkan data buku (diambil dari kelas User)
    public void inputBook() {
        super.inputBook();
    }

    // Metode untuk menghasilkan ID acak (diambil dari kelas User)
    public String generateId() {
        Random random = new Random();
        StringBuilder idTengah = new StringBuilder();
        StringBuilder idAkhir = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            idTengah.append(random.nextInt(10));
            idAkhir.append(random.nextInt(10));
        }
        return ("ID-" + idTengah + "-" + idAkhir);
    }
}