package exception.custom;

// Exception class untuk menangani akses ilegal admin
public class IllegalAdminAccess extends Exception {

    // Konstruktor dengan parameter pesan untuk menetapkan pesan kesalahan
    public IllegalAdminAccess(String message) {
        super(message);
    }
}

