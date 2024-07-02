package data;
import books.Book;
import com.main.LibrarySystem;
import exception.custom.IllegalAdminAccess;
import javafx.application.HostServices;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import util.iMenu;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URI;
import java.util.ArrayList;

public class Student extends User  implements iMenu {
    public static ArrayList<UserStudent> dataMahasiswa = new ArrayList<>();


    //Konstruktor untuk arraylist arr_userStudent.
    public static class UserStudent {
        String nama, nim, fakultas, prodi;

        public UserStudent(String nama, String nim, String fakultas, String prodi) {
            this.nama = nama;
            this.nim = nim;
            this.fakultas = fakultas;
            this.prodi = prodi;
        }
    }

    @Override
    public void menu() {
        Stage studentMenuStage = new Stage();
        studentMenuStage.setTitle("UMM Library - Student Menu");

        // Background Image
        Image image = new Image("file:src/main/java/stdnew1.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(720);
        imageView.setFitWidth(1280);
        imageView.setPreserveRatio(false);

        // Buttons with Images
        Image imageb1 = new Image("file:src/main/java/std2.png");
        ImageView imageView1 = new ImageView(imageb1);
        imageView1.setFitWidth(500);
        imageView1.setFitHeight(280);
        Button tombolBukuTerpinjam = new Button();
        tombolBukuTerpinjam.setGraphic(imageView1);
        tombolBukuTerpinjam.setStyle("-fx-background-color: transparent;");

        Image imageb2 = new Image("file:src/main/java/std3.png");
        ImageView imageView2 = new ImageView(imageb2);
        imageView2.setFitWidth(500);
        imageView2.setFitHeight(280);
        Button tombolPinjamBuku = new Button();
        tombolPinjamBuku.setGraphic(imageView2);
        tombolPinjamBuku.setStyle("-fx-background-color: transparent;");

        Image imageb3 = new Image("file:src/main/java/std4.png");
        ImageView imageView3 = new ImageView(imageb3);
        imageView3.setFitWidth(500);
        imageView3.setFitHeight(280);
        Button tombolKembalikanBuku = new Button();
        tombolKembalikanBuku.setGraphic(imageView3);
        tombolKembalikanBuku.setStyle("-fx-background-color: transparent;");

        Image imageLogout = new Image("file:src/main/java/LogoutIcon.png");
        ImageView imageViewLogout = new ImageView(imageLogout);
        imageViewLogout.setFitWidth(120);
        imageViewLogout.setFitHeight(30);
        imageViewLogout.setPreserveRatio(true);
        Button tombolKembali = new Button("Keluar");
        tombolKembali.setGraphic(imageViewLogout);
        tombolKembali.setStyle("-fx-background-color: rgb(220, 0, 0); -fx-text-fill: #ffff; -fx-font-size: 15px; -fx-background-radius: 30;");


        Image imageRadio = new Image("file:src/main/java/std5.png");
        ImageView imageViewRadio = new ImageView(imageRadio);
        imageViewRadio.setFitWidth(390);
        imageViewRadio.setFitHeight(390);
        imageViewRadio.setPreserveRatio(true);
        Button tombolRadio = new Button("lihat radio");
        tombolRadio.setGraphic(imageViewRadio);
        tombolRadio.setStyle("-fx-background-color: transparent;");


        // Arrange buttons in a GridPane
        GridPane buttonLayout = new GridPane();
        buttonLayout.setAlignment(Pos.CENTER);
        buttonLayout.setVgap(10);
        buttonLayout.setHgap(-100);

        buttonLayout.add(tombolBukuTerpinjam, 0, 1);
        buttonLayout.add(tombolRadio, 0, 2);
        buttonLayout.add(tombolPinjamBuku, 1, 1);
        buttonLayout.add(tombolKembalikanBuku, 2, 1);
        buttonLayout.add(tombolKembali, 1, 0);

        // Set translations for button positioning
        tombolBukuTerpinjam.setTranslateY(10);
        tombolPinjamBuku.setTranslateY(10);
        tombolKembalikanBuku.setTranslateY(10);
        tombolKembali.setTranslateY(-50);
        tombolKembali.setTranslateX(640);
        tombolRadio.setTranslateY(0);
        tombolRadio.setTranslateX(50);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(imageView, buttonLayout);

        Scene studentMenuScene = new Scene(stackPane, 1280, 720);
        studentMenuStage.setScene(studentMenuScene);
        studentMenuStage.show();

        // Button actions
        tombolBukuTerpinjam.setOnAction(event -> {
            showBorrowedBooks();
            studentMenuStage.close();
        });

        tombolPinjamBuku.setOnAction(event -> {
            choiceBooks();
            studentMenuStage.close();
        });

        tombolKembalikanBuku.setOnAction(event -> {
            returnBooks();
            studentMenuStage.close();
        });

        tombolKembali.setOnAction(event -> {
            LibrarySystem librarySystemObj = new LibrarySystem();
            librarySystemObj.start(new Stage());
            studentMenuStage.close();
        });

        tombolRadio.setOnAction(event -> {
            try {
                // URL yang ingin dibuka
                String url = "https://widya-bahana-suara.perpusnas.go.id/live?type=http&nocache=1";
                // Membuka URL di browser default
                if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                    Desktop.getDesktop().browse(new URI(url));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }

    @Override
    public void choiceBooks(){
        super.choiceBooks();
    }
    public static void showBorrowedBooks(){
        Stage stageTampilkanBukuTerpinjam = new Stage();
        stageTampilkanBukuTerpinjam.setTitle("Informasi Buku Yang Dipinjam");

        Image image = new Image("file:src/main/java/Background.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(1280);
        imageView.setFitHeight(720);
        imageView.setPreserveRatio(false);

        TableView<Book> table = new TableView<>();
        table.setPrefSize(600, 300);

        TableColumn<Book, String> kolomIdBuku = new TableColumn<>("ID Buku");
        kolomIdBuku.setCellValueFactory(new PropertyValueFactory<>("bookId"));

        TableColumn<Book, String> kolomJudulBuku = new TableColumn<>("Nama Buku");
        kolomJudulBuku.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Book, String> kolomPengarangBuku = new TableColumn<>("Penulis");
        kolomPengarangBuku.setCellValueFactory(new PropertyValueFactory<>("author"));

        TableColumn<Book, String> kolomKategoriBuku = new TableColumn<>("Kategori");
        kolomKategoriBuku.setCellValueFactory(new PropertyValueFactory<>("category"));

        TableColumn<Book, Integer> kolomDurasiPinjam = new TableColumn<>("Durasi");
        kolomDurasiPinjam.setCellValueFactory(new PropertyValueFactory<>("duration"));

        Button button = new Button("Kembali");
        button.setStyle("-fx-background-color: #4267B2; -fx-text-fill: #FFFFFF; -fx-font-size: 15px;");
        button.setPrefSize(600,30);

        table.getColumns().add(kolomIdBuku);
        table.getColumns().add(kolomJudulBuku);
        table.getColumns().add(kolomPengarangBuku);
        table.getColumns().add(kolomKategoriBuku);
        table.getColumns().add(kolomDurasiPinjam);

        for (Book a : Book.arr_borrowedBook) {
            for (Book i : Book.arr_bookList) {
                if (i.getBookId().equals(a.getBookId())) {
                    table.getItems().add(i);
                }
            }
        }

        button.setOnAction(event -> {
            Student student = new Student();
            student.menu();
            stageTampilkanBukuTerpinjam.close();
        });


        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(table, 1, 0);
        gridPane.add(button, 1, 1);// menambahkan tabel ke GridPane

        gridPane.setVgap(10);
        gridPane.setHgap(5);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(imageView,gridPane);

        Scene scene = new Scene(stackPane,1280,720);
        stageTampilkanBukuTerpinjam.setScene(scene);
        stageTampilkanBukuTerpinjam.show();
    }

    public static void returnBooks() {
        Stage returnBooksStage = new Stage();
        returnBooksStage.setTitle("UMM Library - Pengembalian buku");

        Image image = new Image("file:src/main/java/Background.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(1280);
        imageView.setFitHeight(720);
        imageView.setPreserveRatio(false);

        // Label
        Label judulAtasPage = new Label("Pengembalian buku");
        TextArea reviewTextArea = new TextArea();
        reviewTextArea.setPromptText("Masukkan Ulasan Anda");
        reviewTextArea.setTranslateX(180);
        reviewTextArea.setPrefSize(600,300);
        reviewTextArea.setPrefRowCount(3);

        // Notification Labels
        Label labelSubmitBerhasil = new Label("Pengembalian Sukses!");
        Label labelSubmitGagal = new Label("Pengembalian Gagal!");

        // Font Style
        judulAtasPage.setFont(Font.font("Montserrat", FontWeight.BOLD, 20));
        /*labelIdBuku.setFont(Font.font("Roboto", FontWeight.NORMAL, 15));*/

        // Font Color
        judulAtasPage.setStyle("-fx-text-fill: #FFFFFF;");
        labelSubmitBerhasil.setStyle("-fx-text-fill: #16FF00;");
        labelSubmitGagal.setStyle("-fx-text-fill: #FF1E1E;");

        // Notification label settings
        labelSubmitBerhasil.setVisible(false);
        labelSubmitGagal.setVisible(false);

        // Fields
        TextField bookIdField = new TextField();
        bookIdField.setPromptText("Masukkan ID Buku Yang Ingin Dipinjam");
        bookIdField.setTranslateX(180);

        // Buttons
        Button tombolSubmit = new Button("Kirim");
        tombolSubmit.setStyle("-fx-background-color: #4267B2; -fx-text-fill: #FFFFFF; -fx-font-size: 15px;");
        tombolSubmit.setPrefSize(298,30);
        tombolSubmit.setTranslateX(-128);
        Button tombolKembali = new Button("Kembali");
        tombolKembali.setStyle("-fx-background-color: #4267B2; -fx-text-fill: #FFFFFF; -fx-font-size: 15px;");
        tombolKembali.setPrefSize(298,30);
        tombolKembali.setTranslateX(178);

        // Table setup
        TableView<Book> tableView = new TableView<>();

        TableColumn<Book, String> kolomIdBuku = new TableColumn<>("ID Buku");
        TableColumn<Book, String> kolomJudulBuku = new TableColumn<>("Judul");
        TableColumn<Book, String> kolomPengarangBuku = new TableColumn<>("Author");
        TableColumn<Book, String> kolomKategoriBuku = new TableColumn<>("Kategori");
        TableColumn<Book, String> kolomDurasiPinjam = new TableColumn<>("Durasi Pinjaman (Hari)");

        kolomIdBuku.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        kolomJudulBuku.setCellValueFactory(new PropertyValueFactory<>("title"));
        kolomPengarangBuku.setCellValueFactory(new PropertyValueFactory<>("author"));
        kolomKategoriBuku.setCellValueFactory(new PropertyValueFactory<>("category"));
        kolomDurasiPinjam.setCellValueFactory(new PropertyValueFactory<>("duration"));

        tableView.getColumns().add(kolomIdBuku);
        tableView.getColumns().add(kolomJudulBuku);
        tableView.getColumns().add(kolomPengarangBuku);
        tableView.getColumns().add(kolomKategoriBuku);
        tableView.getColumns().add(kolomDurasiPinjam);
        tableView.setMaxSize(600,300);
        tableView.setTranslateX(180);

        tableView.setItems(FXCollections.observableArrayList(Book.arr_borrowedBook));

        // Grid layout
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(15, 15, 15, 15));

        gridPane.add(judulAtasPage, 0, 0, 2, 1);
        gridPane.add(tableView, 0, 1, 6, 1);
        gridPane.add(bookIdField, 0, 3);
        gridPane.add(reviewTextArea, 0, 5);
        gridPane.add(tombolKembali, 0, 6);
        gridPane.add(tombolSubmit, 1, 6);
        gridPane.add(labelSubmitBerhasil, 0, 6);
        gridPane.add(labelSubmitGagal, 0, 6);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(imageView, gridPane);

        Scene returnBookScene = new Scene(stackPane, 1280, 720);
        returnBooksStage.setScene(returnBookScene);
        returnBooksStage.show();

        // Action button
        tombolSubmit.setOnAction(event -> {
            boolean validasiReturnBooks = false;
            String inputBookId = bookIdField.getText();

            for (int i = 0; i < Book.arr_borrowedBook.size(); i++) {
                Book borrowedBook = Book.arr_borrowedBook.get(i);

                if (borrowedBook.getBookId().equals(inputBookId)) {
                    for (Book book : Book.arr_bookList) {
                        if (book.getBookId().equals(inputBookId)) {
                            book.setReview(reviewTextArea.getText());
                            book.setStock(book.getStock() + 1);
                            Book.arr_borrowedBook.remove(i);

                            validasiReturnBooks = true;
                            break;
                        }
                    }
                    break;
                }
            }

            tableView.setItems(FXCollections.observableArrayList(Book.arr_borrowedBook));
            tableView.refresh();

            if (validasiReturnBooks) {
                labelSubmitBerhasil.setVisible(true);
                labelSubmitGagal.setVisible(false);
            } else {
                labelSubmitGagal.setVisible(true);
                labelSubmitBerhasil.setVisible(false);
            }
        });

        tombolKembali.setOnAction(event -> {
            Student studentObj = new Student();
            studentObj.menu();
            returnBooksStage.close();
        });
    }

    public boolean isStudents(TextField username) throws IllegalAdminAccess {
        if (username.getText().length() != 15) {
            throw new IllegalAdminAccess("NIM Harus 15 Digit!");
        }
        for (UserStudent i : dataMahasiswa) {
            if (i.nim.equals(username.getText())) {
                menu();
                return false;
            }
        }
        throw new IllegalAdminAccess("NIM tidak ditemukan!");
    }
}