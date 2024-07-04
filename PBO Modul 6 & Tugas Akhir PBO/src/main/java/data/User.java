package data;

import books.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class User {

    // Method untuk menampilkan pilihan buku
    public void choiceBooks() {
        // Objek yang diperlukan
        Book bookObj = new Book();
        Student studentObj = new Student();

        // Membuat stage baru untuk memilih buku
        Stage choiceBooksStage = new Stage();
        choiceBooksStage.setTitle("UMM library - Pilih Buku");

        // Background image
        Image image = new Image("file:src/main/java/Background.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(1280);
        imageView.setFitHeight(720);
        imageView.setPreserveRatio(false);

        // TableView untuk menampilkan daftar buku
        TableView<Book> tableView = new TableView<>();
        tableView.setPrefSize(600, 300);

        // Kolom-kolom pada TableView
        TableColumn<Book, String> kolomIdBuku = new TableColumn<>("ID Buku");
        kolomIdBuku.setCellValueFactory(new PropertyValueFactory<>("bookId"));

        TableColumn<Book, String> kolomJudulBuku = new TableColumn<>("Nama Buku");
        kolomJudulBuku.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Book, String> kolomPengarangBuku = new TableColumn<>("Penulis");
        kolomPengarangBuku.setCellValueFactory(new PropertyValueFactory<>("author"));

        TableColumn<Book, String> kolomKategoriBuku = new TableColumn<>("Kategori");
        kolomKategoriBuku.setCellValueFactory(new PropertyValueFactory<>("category"));

        TableColumn<Book, Integer> kolomStokBuku = new TableColumn<>("Stok");
        kolomStokBuku.setCellValueFactory(new PropertyValueFactory<>("stock"));

        TableColumn<Book, String> kolomUlasan = new TableColumn<>("Ulasan");
        kolomUlasan.setCellValueFactory(new PropertyValueFactory<>("review"));

        tableView.getColumns().addAll(kolomIdBuku, kolomJudulBuku, kolomPengarangBuku, kolomKategoriBuku, kolomStokBuku, kolomUlasan);
        tableView.setTranslateX(180);

        // Menambahkan data buku ke dalam TableView
        for (Book i : Book.arr_bookList) {
            tableView.getItems().add(i);
        }

        // GridPane untuk menempatkan elemen-elemen di dalam scene
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        gridPane.add(tableView, 0, 0);

        // TextField untuk input ID buku dan durasi peminjaman
        TextField inputIdBuku = new TextField();
        inputIdBuku.setPromptText("Masukkan ID Buku");
        inputIdBuku.setTranslateX(180);
        TextField durationField = new TextField();
        durationField.setTranslateX(180);
        durationField.setPromptText("Masukkan Durasi Waktu Peminjaman");

        // Button untuk submit dan kembali
        Button tombolSubmit = new Button("Kirim");
        tombolSubmit.setTranslateX(-128);
        tombolSubmit.setStyle("-fx-background-color: #4267B2; -fx-text-fill: #FFFFFF; -fx-font-size: 15px;");
        tombolSubmit.setPrefSize(298, 30);
        Button tombolKembali = new Button("Kembali");
        tombolKembali.setTranslateX(180);
        tombolKembali.setStyle("-fx-background-color: #4267B2; -fx-text-fill: #FFFFFF; -fx-font-size: 15px;");
        tombolKembali.setPrefSize(298, 30);
        gridPane.add(inputIdBuku, 0, 2);
        gridPane.add(durationField, 0, 4);
        gridPane.add(tombolSubmit, 1, 5);
        gridPane.add(tombolKembali, 0, 5);

        // Label untuk menampilkan pesan
        Label messageLabel = new Label();

        // StackPane untuk menempatkan semua elemen di dalam scene
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(imageView, gridPane);

        // Scene utama
        Scene scene = new Scene(stackPane, 1280, 720);
        choiceBooksStage.setScene(scene);
        choiceBooksStage.show();

        // Aksi saat tombol Submit ditekan
        tombolSubmit.setOnAction(e -> {
            boolean validasi = false;
            String idBukuYangDipinjam = inputIdBuku.getText();

            // Mencocokkan ID buku yang dipilih dengan daftar buku yang tersedia
            for (Book i : Book.arr_bookList) {
                if (i.getBookId().equals(idBukuYangDipinjam)) {
                    if (i.getStock() > 0) {
                        int a = i.getStock();
                        a--;
                        i.setStock(a);

                        int inputwaktuPinjaman = Integer.parseInt(durationField.getText());

                        // Validasi durasi peminjaman maksimal 14 hari
                        if (inputwaktuPinjaman < 15) {
                            bookObj.setDuration(inputwaktuPinjaman);
                            Book.arr_borrowedBook.add(new Book(idBukuYangDipinjam, i.getStock(), bookObj.getDuration()));
                            validasi = true;
                            break;
                        } else {
                            messageLabel.setText("Maksimal 14 Hari");
                        }
                    } else if (i.getStock() == 0) {
                        messageLabel.setText("== Stok Buku Kosong! ==");
                        studentObj.menu();
                    }
                }
            }

            // Menampilkan pesan sesuai dengan hasil validasi
            if (validasi) {
                messageLabel.setText("==== Buku Berhasil Dipinjam! ====");
            } else {
                messageLabel.setText("== ID Buku Tidak Ditemukan! ==");
            }
        });

        // Aksi saat tombol Kembali ditekan
        tombolKembali.setOnAction(event -> {
            Student student1 = new Student();
            student1.menu();
            choiceBooksStage.close();
        });
    }

    // Method untuk input buku baru
    public void inputBook() {
        // Objek untuk jenis buku
        Book textBookObj = new TextBook();
        Book storyBookObj = new StoryBook();
        Book historyBookObj = new HistoryBook();

        // Membuat stage baru untuk memasukkan buku
        Stage inputBookStage = new Stage();
        inputBookStage.setTitle("UMM Library - Input Book");

        // Background image
        Image image = new Image("file:src/main/java/ImageAddBook.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(720);
        imageView.setFitWidth(1280);
        imageView.setPreserveRatio(false);

        // Button untuk jenis buku
        Button tombolHistoryBook = new Button("History Book");
        tombolHistoryBook.setPrefHeight(70);
        tombolHistoryBook.setPrefWidth(140);
        tombolHistoryBook.setStyle("-fx-background-color: #FF0000;");
        Button tombolStoryBook = new Button("Story Book");
        tombolStoryBook.setPrefHeight(70);
        tombolStoryBook.setPrefWidth(140);
        tombolStoryBook.setStyle("-fx-background-color: #FF0000;");
        Button tombolTextBook = new Button("Text Book");
        tombolTextBook.setPrefHeight(70);
        tombolTextBook.setPrefWidth(140);
        tombolTextBook.setStyle("-fx-background-color: #FF0000;");
        Button tombolKembali = new Button("kembali");
        tombolKembali.setPrefHeight(70);
        tombolKembali.setPrefWidth(140);
        tombolKembali.setStyle("-fx-background-color: #FF0000;");

        // Font style untuk button
        tombolHistoryBook.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
        tombolStoryBook.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
        tombolTextBook.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
        tombolKembali.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));

        // GridPane untuk menempatkan button
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(tombolHistoryBook, 0, 2);
        gridPane.add(tombolStoryBook, 1, 2);
        gridPane.add(tombolTextBook, 2, 2);
        gridPane.add(tombolKembali, 3, 2);
        gridPane.setVgap(120);
        gridPane.setHgap(145);

        // StackPane untuk menempatkan semua elemen di dalam scene
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(imageView, gridPane);

        // Scene utama
        Scene scene = new Scene(stackPane, 1280, 720);
        inputBookStage.setScene(scene);
        inputBookStage.show();

        // Aksi saat tombol History Book ditekan
        tombolHistoryBook.setOnAction(event -> {
            addBook(historyBookObj, "UMM Library - Add History Book ", "History Book");
            inputBookStage.close();
        });

        // Aksi saat tombol Story Book ditekan
        tombolStoryBook.setOnAction(event -> {
            addBook(storyBookObj, "UMM Library - Add Story Book ", "Story Book");
            inputBookStage.close();
        });

        // Aksi saat tombol Text Book ditekan
        tombolTextBook.setOnAction(event -> {
            addBook(textBookObj, "UMM Library - Add Text Book", "Text Book");
            inputBookStage.close();
        });

        // Aksi saat tombol Kembali ditekan
        tombolKembali.setOnAction(event -> {
            Admin admin = new Admin();
            admin.menu();
            inputBookStage.close();
        });
    }

    // Method untuk menambahkan buku berdasarkan genre
    public void addBook(Book genreBook, String addBookStageTitle, String addBookSceneTitle) {
        Admin adminObj = new Admin();
        Book bookObj = new Book();

        // Membuat stage baru untuk menambahkan buku
        Stage addbookStage = new Stage();
        addbookStage.setTitle(addBookStageTitle);

        // Background image
        Image image = new Image("file:src/main/java/GambarBaruAdmin.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(1280);
        imageView.setFitHeight(720);
        imageView.setPreserveRatio(false);

        // Label untuk judul scene
        Label sceneTitleLabel = new Label(addBookSceneTitle);

        // Label untuk pesan error
        Label errorMessageLabel = new Label("Stok harus berupa angka");

        // TextField untuk input informasi buku
        TextField inputIdBuku = new TextField(adminObj.generateId());
        inputIdBuku.setPromptText("ID Buku");
        inputIdBuku.setPrefSize(600, 30);
        inputIdBuku.setTranslateX(-150);
        TextField inputJudulBuku = new TextField();
        inputJudulBuku.setPrefSize(600, 30);
        inputJudulBuku.setTranslateX(-150);
        inputJudulBuku.setPromptText("Judul Buku");
        TextField inputPengarangBuku = new TextField();
        inputPengarangBuku.setPrefSize(600, 30);
        inputPengarangBuku.setTranslateX(-150);
        inputPengarangBuku.setPromptText("Pengarang Buku");
        TextField inputStokBuku = new TextField();
        inputStokBuku.setPrefSize(600, 30);
        inputStokBuku.setTranslateX(-150);
        inputStokBuku.setPromptText("Stok Buku");

        // Font style untuk label
        sceneTitleLabel.setFont(Font.font("Montserrat", FontWeight.BOLD, 20));

        // Warna untuk label
        sceneTitleLabel.setStyle("-fx-text-fill: #A91D3A;");
        errorMessageLabel.setStyle("-fx-text-fill: #FF1E1E;");

        // Membuat label error tidak terlihat
        errorMessageLabel.setVisible(false);

        // Button untuk submit dan kembali
        Button submitButton = new Button("Kirim");
        submitButton.setStyle("-fx-background-color: #4267B2; -fx-text-fill: #FFFFFF; -fx-font-size: 15px;");
        submitButton.setPrefSize(298, 30);
        submitButton.setTranslateX(150);
        Button backbutton = new Button("Kembali");
        backbutton.setTranslateX(150);
        backbutton.setStyle("-fx-background-color: #4267B2; -fx-text-fill: #FFFFFF; -fx-font-size: 15px;");
        backbutton.setPrefSize(298, 30);

        // GridPane untuk menempatkan elemen-elemen di dalam scene
        GridPane gridAddBook = new GridPane();
        gridAddBook.setAlignment(Pos.CENTER);

        gridAddBook.add(sceneTitleLabel, 1, 0);
        gridAddBook.add(errorMessageLabel, 0, 6);
        gridAddBook.add(inputIdBuku, 2, 2);
        gridAddBook.add(inputJudulBuku, 2, 3);
        gridAddBook.add(inputPengarangBuku, 2, 4);
        gridAddBook.add(inputStokBuku, 2, 5);
        gridAddBook.add(submitButton, 2, 6);
        gridAddBook.add(backbutton, 0, 6);
        gridAddBook.setVgap(10);
        gridAddBook.setHgap(-46);

        // StackPane untuk menempatkan semua elemen di dalam scene
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(imageView, gridAddBook);

        // Scene utama
        Scene addbookScene = new Scene(stackPane, 1280, 720);
        addbookStage.setScene(addbookScene);
        addbookStage.show();

        // Aksi saat tombol Submit ditekan
        submitButton.setOnAction(event -> {
            try {
                errorMessageLabel.setVisible(false);

                // Mengambil informasi dari input dan menambahkan buku ke daftar
                bookObj.setBookId(inputIdBuku.getText());
                bookObj.setTitle(inputJudulBuku.getText());
                genreBook.setCategory(sceneTitleLabel.getText());
                bookObj.setAuthor(inputPengarangBuku.getText());
                bookObj.setStock(Integer.parseInt(inputStokBuku.getText()));

                Book.arr_bookList.add(new Book(bookObj.getBookId(), bookObj.getTitle(), bookObj.getAuthor(), genreBook.getCategory(), bookObj.getStock()));

                adminObj.menu();
                addbookStage.close();
            } catch (NumberFormatException message) {
                errorMessageLabel.setVisible(true);
                addbookStage.show();
            }
        });

        // Aksi saat tombol Kembali ditekan
        backbutton.setOnAction(event -> {
            User user = new User();
            user.inputBook();
            addbookStage.close();
        });
    }
}
