package books;

public class StoryBook extends Book {
    private String category; // Kategori buku cerita

    // Konstruktor default (tanpa parameter)
    public StoryBook() {

    }

    // Konstruktor dengan parameter category
    public StoryBook(String category) {
        super(category); // Memanggil konstruktor superclass dengan parameter category
        this.category = category; // Menginisialisasi atribut category
    }

    // Setter untuk mengatur kategori buku cerita
    @Override
    public void setCategory(String category) {
        this.category = category;
    }

    // Getter untuk mendapatkan kategori buku cerita
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
