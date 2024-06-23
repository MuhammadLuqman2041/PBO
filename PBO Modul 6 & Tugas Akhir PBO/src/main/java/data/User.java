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

    //===================================== ATRIBUT ======================================

    //====================================== METHOD =======================================

    //Method yang digunakan untuk meminjam buku
    public void choiceBooks() {


        Book bookObj = new Book();
        Student studentObj = new Student();

        Stage choiceBooksStage = new Stage();
        choiceBooksStage.setTitle("UMM library - Pilih Buku");

        Image image = new Image("file:src/main/java/Background.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(1280);
        imageView.setFitHeight(720);
        imageView.setPreserveRatio(false);


        TableView<Book> tableView = new TableView<>();

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

        tableView.getColumns().add(kolomUlasan);

        tableView.getColumns().add(kolomIdBuku);
        tableView.getColumns().add(kolomJudulBuku);
        tableView.getColumns().add(kolomPengarangBuku);
        tableView.getColumns().add(kolomKategoriBuku);
        tableView.getColumns().add(kolomStokBuku);

        for (Book i : Book.arr_bookList) {
            tableView.getItems().add(i);
        }


        GridPane tataletak = new GridPane();
        tataletak.setAlignment(Pos.CENTER);

        tataletak.setHgap(10);
        tataletak.setVgap(10);

        tataletak.setPadding(new Insets(25, 25, 25, 25));

        tataletak.add(tableView, 0, 0);

        Label bookIdLabel = new Label("Input ID buku yang ingin dipinjam:");
        tataletak.add(bookIdLabel, 0, 1);

        TextField inputIdBuku = new TextField();
        tataletak.add(inputIdBuku, 0, 2);

        Label durationLabel = new Label("Berapa hari ingin meminjam buku? (Max 14 hari)");

        TextField durationField = new TextField();
        durationField.setPromptText("Berapa hari ?");

        tataletak.add(durationLabel, 0, 3);
        tataletak.add(durationField, 0, 4);
        Button tombolSubmit = new Button("Submit");
        Button tombolKembali = new Button("Kembali");
        tataletak.add(tombolSubmit, 0, 5);
        tataletak.add(tombolKembali, 0, 6);
        Label messageLabel = new Label();

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(imageView, tataletak);

        Scene scene = new Scene(stackPane, 1280, 720);
        choiceBooksStage.setScene(scene);
        choiceBooksStage.show();

        tombolSubmit.setOnAction(e -> {
            boolean validasi = false;

            String idBukuYangDipinjam = inputIdBuku.getText();

            for (Book i : Book.arr_bookList) {
                if (i.getBookId().equals(idBukuYangDipinjam)) {
                    if (i.getStock() > 0) {
                        int a = i.getStock();
                        a--;
                        i.setStock(a);

                        int inputwaktuPinjaman = Integer.parseInt(durationField.getText());

                        if (inputwaktuPinjaman < 15) {
                            bookObj.setDuration(inputwaktuPinjaman);
                            Book.arr_borrowedBook.add(new Book(idBukuYangDipinjam, i.getStock(), bookObj.getDuration()));
                            validasi = true;
                            break;
                        } else {
                            messageLabel.setText("Max 14 hari");
                        }
                    } else if (i.getStock() == 0) {
                        messageLabel.setText("== Stok buku habis! ==");
                        studentObj.menu();
                    }
                }
            }
            if (validasi) {
                messageLabel.setText("==== Buku berhasil dipinjam! ====");
            } else {
                messageLabel.setText("== ID tidak ditemukan! ==");
            }

        });

        tombolKembali.setOnAction(event -> {
            Student student1 = new Student();
            student1.menu();
            choiceBooksStage.close();
        });
    }

    public void inputBook() {
        Book textBookObj = new TextBook();
        Book storyBookObj = new StoryBook();
        Book historyBookObj = new HistoryBook();

        Stage inputBookStage = new Stage();
        inputBookStage.setTitle("UMM Library - Input Book");

        //Button

        Image image = new Image("file:src/main/java/GambarRevisiBook.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(720);
        imageView.setFitWidth(1280);
        imageView.setPreserveRatio(false);

        Button tombolHistoryBook = new Button("History Book");
        Button tombolStoryBook = new Button("Story Book");
        Button tombolTextBook = new Button("Text Book");
        Button tombolKembali = new Button("kembali");

        tombolHistoryBook.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
        tombolStoryBook.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
        tombolTextBook.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
        tombolKembali.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));

        //Grid layout
        GridPane tataletak = new GridPane();
        tataletak.setAlignment(Pos.CENTER);

        tataletak.add(tombolHistoryBook, 0, 2);
        tataletak.add(tombolStoryBook, 1, 2);
        tataletak.add(tombolTextBook, 2, 2);
        tataletak.add(tombolKembali, 3, 2);

        tataletak.setVgap(120);
        tataletak.setHgap(210);

        StackPane stackPane =new StackPane();
        stackPane.getChildren().addAll(imageView, tataletak);
        Scene scene = new Scene(stackPane, 1280, 720);
        inputBookStage.setScene(scene);
        inputBookStage.show();


        //Action Button
        tombolHistoryBook.setOnAction(event -> {
            addBook(historyBookObj, "UMM Library - Add History Book ", "History Book");
            inputBookStage.close();
        });

        tombolStoryBook.setOnAction(event -> {
            addBook(storyBookObj, "UMM Library - Add Story Book ", "Story Book");
            inputBookStage.close();
        });

        tombolTextBook.setOnAction(event -> {
            addBook(textBookObj, "UMM Library - Add Text Book", "Text Book");
            inputBookStage.close();
        });

        tombolKembali.setOnAction(event -> {
            Admin admin = new Admin();
            admin.menu();
            inputBookStage.close();
        });

    }

    public void addBook(Book genreBook, String addBookStageTitle, String addBookSceneTitle) {
        Admin adminObj = new Admin();
        Book bookObj = new Book();

        Stage addbookStage = new Stage();
        addbookStage.setTitle(addBookStageTitle);

        Image image = new Image("file:src/main/java/GambarBaruAdmin.png");
        ImageView imageView = new ImageView(image);

        imageView.setFitWidth(1280);
        imageView.setFitHeight(720);
        imageView.setPreserveRatio(false);

        //Label
        Label sceneTitleLabel = new Label(addBookSceneTitle);
        Label bookIdLabel = new Label("ID Buku    :");
        Label bookTitleLabel = new Label("Judul Buku :");
        Label authorLabel = new Label("Penulis    :");
        Label stockLabel = new Label("Stok       :");

        //Notification Label
        Label errorMessageLabel = new Label("Stok harus berupa angka");

        //Field
        TextField inputIdBuku = new TextField(adminObj.generateId());
        TextField inputJudulBuku = new TextField();
        TextField inputPengarangBuku = new TextField();
        TextField inputStokBuku = new TextField();

        //Font label style
        sceneTitleLabel.setFont(Font.font("Montserrat", FontWeight.BOLD, 20));
        bookIdLabel.setFont(Font.font("Roboto", FontWeight.NORMAL, 15));
        bookTitleLabel.setFont(Font.font("Roboto", FontWeight.NORMAL, 15));
        authorLabel.setFont(Font.font("Roboto", FontWeight.NORMAL, 15));
        stockLabel.setFont(Font.font("Roboto", FontWeight.NORMAL, 15));

        //Font label color
        sceneTitleLabel.setStyle("-fx-text-fill: #A91D3A;");
        errorMessageLabel.setStyle("-fx-text-fill: #FF1E1E;");

        //Font visible settings
        errorMessageLabel.setVisible(false);

        //Button
        Button submitButton = new Button("Submit");
        Button backbutton = new Button("Kembali");


        //Grid layout
        GridPane gridAddBook = new GridPane();
        gridAddBook.setAlignment(Pos.CENTER);

        gridAddBook.add(sceneTitleLabel, 1, 0);
        gridAddBook.add(bookIdLabel, 0, 2);
        gridAddBook.add(bookTitleLabel, 0, 3);
        gridAddBook.add(authorLabel, 0, 4);
        gridAddBook.add(stockLabel, 0, 5);
        gridAddBook.add(errorMessageLabel, 0, 6);

        gridAddBook.add(inputIdBuku, 2, 2);
        gridAddBook.add(inputJudulBuku, 2, 3);
        gridAddBook.add(inputPengarangBuku, 2, 4);
        gridAddBook.add(inputStokBuku, 2, 5);

        gridAddBook.add(submitButton, 2, 6);
        gridAddBook.add(backbutton, 0, 6);

        gridAddBook.setVgap(10);
        gridAddBook.setHgap(0);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(imageView,gridAddBook);

        Scene addbookScene = new Scene(stackPane, 1280, 720);
        addbookStage.setScene(addbookScene);
        addbookStage.show();

        //Action button
        submitButton.setOnAction(event -> {
            //add book to array
            try {
                errorMessageLabel.setVisible(false);

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

        backbutton.setOnAction(event -> {
            User user = new User();
            user.inputBook();
            addbookStage.close();
        });
    }
}