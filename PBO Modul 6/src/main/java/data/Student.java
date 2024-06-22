package data;
import books.Book;
import com.main.LibrarySystem;
import exception.custom.IllegalAdminAccess;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import util.iMenu;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Student extends User implements iMenu {
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

        //Button
        Image image = new Image("file:src/main/java/GambarMenuStudent.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(720);
        imageView.setFitWidth(1280);
        imageView.setPreserveRatio(false);

        Button tombolBukuTerpinjam = new Button("Buku Terpinjam");
        Button tombolPinjamBuku = new Button("Pinjam Buku");
        Button tombolKembalikanBuku = new Button("Kembalikan Buku");
        Button tombolKembali = new Button("Logout");

        tombolBukuTerpinjam.setFont(Font.font("Roboto", FontWeight.BOLD, 14));
        tombolPinjamBuku.setFont(Font.font("Roboto", FontWeight.BOLD, 14));
        tombolKembalikanBuku.setFont(Font.font("Roboto", FontWeight.BOLD, 14));
        tombolKembali.setFont(Font.font("Roboto", FontWeight.BOLD, 14));

        //Grid layout
        GridPane tataletak = new GridPane();
        tataletak.setAlignment(Pos.CENTER);

        tataletak.add(tombolBukuTerpinjam, 0,3);
        tataletak.add(tombolPinjamBuku, 1,3);
        tataletak.add(tombolKembalikanBuku,2,3);
        tataletak.add(tombolKembali,3,3);

        tataletak.setVgap(121);
        tataletak.setHgap(190);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(imageView, tataletak);

        Scene studentmenuScene = new Scene(stackPane, 1280, 720);
        studentMenuStage.setScene(studentmenuScene);
        studentMenuStage.show();

        //Action button
        tombolBukuTerpinjam.setOnAction(event ->{
            showBorrowedBooks();
            studentMenuStage.close();
        });

        tombolPinjamBuku.setOnAction(event -> {
            choiceBooks();
            studentMenuStage.close();
        });

        tombolKembalikanBuku.setOnAction(event ->{
            returnBooks();
            studentMenuStage.close();
        });

        tombolKembali.setOnAction(event -> {
            LibrarySystem librarySystemObj = new LibrarySystem();
            librarySystemObj.start(new Stage());
            studentMenuStage.close();
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
        table.setPrefSize(1280, 720);

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

        // Labels
        Label judulAtasPage = new Label("Pengembalian buku");
        Label labelIdBuku = new Label("Inputkan ID buku yang ingin dikembalikan");
        Label labelUlasan = new Label("Masukkan ulasan Anda");
        TextArea reviewTextArea = new TextArea();
        reviewTextArea.setPrefRowCount(3);

        // Notification Labels
        Label labelSubmitBerhasil = new Label("Pengembalian berhasil");
        Label labelSubmitGagal = new Label("Pengembalian gagal");

        // Font Style
        judulAtasPage.setFont(Font.font("Montserrat", FontWeight.BOLD, 20));
        labelIdBuku.setFont(Font.font("Roboto", FontWeight.NORMAL, 15));

        // Font Color
        judulAtasPage.setStyle("-fx-text-fill: #FFFFFF;");
        labelSubmitBerhasil.setStyle("-fx-text-fill: #16FF00;");
        labelSubmitGagal.setStyle("-fx-text-fill: #FF1E1E;");

        // Notification label settings
        labelSubmitBerhasil.setVisible(false);
        labelSubmitGagal.setVisible(false);

        // Fields
        TextField bookIdField = new TextField();

        // Buttons
        Button tombolSubmit = new Button("Submit");
        Button tombolKembali = new Button("Kembali");

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

        tableView.setItems(FXCollections.observableArrayList(Book.arr_borrowedBook));

        // Grid layout
        GridPane tataletak = new GridPane();
        tataletak.setAlignment(Pos.CENTER);
        tataletak.setHgap(10);
        tataletak.setVgap(10);
        tataletak.setPadding(new Insets(15, 15, 15, 15));

        tataletak.add(judulAtasPage, 0, 0, 2, 1);
        tataletak.add(tableView, 0, 1, 6, 1);
        tataletak.add(labelIdBuku, 0, 2);
        tataletak.add(bookIdField, 0, 3);
        tataletak.add(labelUlasan, 0, 4);
        tataletak.add(reviewTextArea, 0, 5);
        tataletak.add(tombolKembali, 0, 6);
        tataletak.add(tombolSubmit, 1, 6);
        tataletak.add(labelSubmitBerhasil, 0, 7);
        tataletak.add(labelSubmitGagal, 0, 7);


        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(imageView, tataletak);

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
            throw new IllegalAdminAccess("NIM harus 15 digit!");
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