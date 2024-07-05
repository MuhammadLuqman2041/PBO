package books;

public class TextBook extends Book {
    private String category; // Kategori buku teks

    // Konstruktor default (tanpa parameter)
    public TextBook() {

    }

    // Konstruktor dengan parameter category
    public TextBook(String category) {
        super(category); // Memanggil konstruktor superclass dengan parameter category
        this.category = category; // Menginisialisasi atribut category
    }

    // Setter untuk mengatur kategori buku teks
    @Override
    public void setCategory(String category) {
        this.category = category;
    }

    // Getter untuk mendapatkan kategori buku teks
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
