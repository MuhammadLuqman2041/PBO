package books;

import java.util.ArrayList;

public class Book {

    // Atribut buku
    private String bookId;
    private String title;
    private String author;
    private String category;
    private String review;
    private int stock;
    private int duration;

    // ArrayList untuk menyimpan daftar buku yang terdaftar
    public static ArrayList<Book> arr_bookList = new ArrayList<>();

    // ArrayList untuk menyimpan daftar buku yang sedang dipinjam
    public static ArrayList<Book> arr_borrowedBook = new ArrayList<>();

    // Konstruktor default (tanpa parameter)
    public Book() {

    }

    // Konstruktor dengan parameter category
    public Book(String category) {
        this.category = category;
    }

    // Konstruktor dengan parameter bookId, stock, dan duration
    public Book(String bookId, int stock, int duration) {
        this.bookId = bookId;
        this.stock = stock;
        this.duration = duration;
    }

    // Konstruktor dengan parameter bookId, title, author, category, dan stock
    public Book(String bookId, String title, String author, String category, int stock) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.stock = stock;
    }

    // Setter untuk bookId
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    // Setter untuk title
    public void setTitle(String title) {
        this.title = title;
    }

    // Setter untuk author
    public void setAuthor(String author) {
        this.author = author;
    }

    // Setter untuk category
    public void setCategory(String category) {
        this.category = category;
    }

    // Setter untuk stock
    public void setStock(int stock) {
        this.stock = stock;
    }

    // Setter untuk duration
    public void setDuration(int duration) {
        this.duration = duration;
    }

    // Setter untuk review
    public void setReview(String review) {
        this.review = review;
    }

    // Getter untuk bookId
    public String getBookId() {
        return bookId;
    }

    // Getter untuk title
    public String getTitle() {
        return title;
    }

    // Getter untuk author
    public String getAuthor() {
        return author;
    }

    // Getter untuk category
    public String getCategory() {
        return category;
    }

    // Getter untuk review
    public String getReview() {
        return review;
    }

    // Getter untuk stock
    public int getStock() {
        return stock;
    }

    // Getter untuk duration
    public int getDuration() {
        return duration;
    }
}
