package books;

public class HistoryBook extends Book {
    private String category; // Kategori buku sejarah

    // Konstruktor default (tanpa parameter)
    public HistoryBook() {

    }

    // Konstruktor dengan parameter category
    public HistoryBook(String category) {
        super(category); // Memanggil konstruktor superclass dengan parameter category
        this.category = category; // Menginisialisasi atribut category
    }

    // Setter untuk mengatur kategori buku sejarah
    @Override
    public void setCategory(String category) {
        this.category = category;
    }

    // Getter untuk mendapatkan kategori buku sejarah
    @Override
    public String getCategory() {
        return category;
    }

    // Metode toString untuk mengembalikan representasi String dari kategori
    @Override
    public String toString() {
        return category;
    }
}
