import java.util.ArrayList;
import java.util.Scanner;

public class PBO_Modul_3 {
    public static void main(String[] args) {
        int pilihan = 0;
        String usernameMahasiswa = null, usernameAdmin = null, passwordMahasiswa = null, passwordAdmin = null;
        String namaMahasiswa = null, fakultasMahasiswa = null, prodiMahasiswa = null;
        long nimMahasiswa = 0;

        int nomorBuku = -1;

        ArrayList<String> simpanJudulBuku = new ArrayList<>();
        ArrayList<String> simpanPengarangBuku = new ArrayList<>();
        ArrayList<String> simpanGenreBuku = new ArrayList<>();

        ArrayList<Integer> simpanNomorBuku = new ArrayList<>();
        ArrayList<Integer> simpanIdBuku = new ArrayList<>();
        ArrayList<Integer> simpanStokBuku = new ArrayList<>();

        simpanJudulBuku.add("Buku Indonesia");
        simpanJudulBuku.add("Soekarno");
        simpanJudulBuku.add("History");
        simpanJudulBuku.add("0");
        simpanJudulBuku.add("001");
        simpanJudulBuku.add("10");

        simpanJudulBuku.add("Buku Inggris");
        simpanJudulBuku.add("Elizabeth");
        simpanJudulBuku.add("Nobility");
        simpanJudulBuku.add("1");
        simpanJudulBuku.add("002");
        simpanJudulBuku.add("5");

        simpanJudulBuku.add("Buku Jepang");
        simpanJudulBuku.add("Hirohito");
        simpanJudulBuku.add("Isekai");
        simpanJudulBuku.add("2");
        simpanJudulBuku.add("003");
        simpanJudulBuku.add("15");

        Scanner simpanData = new Scanner(System.in);

        do {
            System.out.println("\n===== Sistem Perpustakaan =====");
            System.out.println("1. Masuk Sebagai Mahasiswa");
            System.out.println("2. Masuk Sebagai Admin");
            System.out.println("3. Keluar");

            System.out.print("Masukkan Pilihan Anda (1-3): ");
            pilihan = simpanData.nextInt();
            simpanData.nextLine();

            switch (pilihan) {
                case 1:
                    do {
                        System.out.print("Masukkan Username Mahasiswa (mahasiswa): ");
                        usernameMahasiswa = simpanData.nextLine();
                        System.out.print("Masukkan Password Mahasiswa (mahasiswa): ");
                        passwordMahasiswa = simpanData.nextLine();

                        if (usernameMahasiswa.equals("mahasiswa") && passwordMahasiswa.equals("mahasiswa")) {
                            System.out.println("Masuk Berhasil!");
                        } else {
                            System.out.println("Username atau Password Salah!");
                        }
                    } while (!usernameMahasiswa.equals("mahasiswa") && !passwordMahasiswa.equals("mahasiswa"));
                    break;

                case 2:
                    do {
                        System.out.print("Masukkan Username Admin (admin): ");
                        usernameAdmin = simpanData.nextLine();
                        System.out.print("Masukkan Password Admin (admin): ");
                        passwordAdmin = simpanData.nextLine();

                        if (usernameAdmin.equals("admin") && passwordAdmin.equals("admin")) {
                            System.out.println("Masuk Berhasil!");
                        } else {
                            System.out.println("Username atau Password Salah!");
                        }
                    } while (!usernameAdmin.equals("admin") && !passwordAdmin.equals("admin"));
                    break;
                case 3:
                    System.out.println("Selesai!");
                    break;
                default:
                    System.out.println("Pilihan Anda Tidak Valid!");
            }
        } while (pilihan != 3);

        do {
            System.out.println("\n===== Menu Admin =====");
            System.out.println("1. Tambahkan Data Mahasiswa");
            System.out.println("2. Tampilkan Data Mahasiswa");
            System.out.println("3. Keluar");

            System.out.print("Masukkan Pilihan Anda (1-3): ");
            pilihan = simpanData.nextInt();
            simpanData.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Nama Mahasiswa: ");
                    namaMahasiswa = simpanData.nextLine();

                    do {
                        System.out.print("Masukkan NIM Mahasiswa: ");
                        nimMahasiswa = simpanData.nextLong();
                        simpanData.nextLine();
                        if (String.valueOf(nimMahasiswa).length() != 15) {
                            System.out.println("NIM Harus 15 Digit!");
                        }
                    } while (String.valueOf(nimMahasiswa).length() != 15);
                    System.out.print("Masukkan Fakultas Mahasiswa: ");
                    fakultasMahasiswa = simpanData.nextLine();
                    System.out.print("Masukkan Prodi Mahasiswa: ");
                    prodiMahasiswa = simpanData.nextLine();
                    break;

                case 2:
                    if (namaMahasiswa == null && nimMahasiswa == 0 && fakultasMahasiswa == null && prodiMahasiswa == null) {
                        System.out.println("Data Mahasiswa Belum Ditambahkan!");
                    } else {
                        System.out.print("\nNama Mahasiswa: " + namaMahasiswa);
                        System.out.print("\nNIM Mahasiswa: " + nimMahasiswa);
                        System.out.print("\nFakultas Mahasiswa: " + fakultasMahasiswa);
                        System.out.print("\nProdi Mahasiswa: " + prodiMahasiswa);
                    }
                    break;
                case 3:
                    System.out.println("Selesai!");
                    break;
                default:
                    System.out.println("Pilihan Anda Tidak Valid!");
            }

        } while (pilihan != 3);


        do {
            System.out.println("\n===== Menu Mahasiswa =====");
            System.out.println("1. Pinjam Buku");
            System.out.println("2. Buku Yang Dipinjam");
            System.out.println("3. Tambahkan Buku");
            System.out.println("4. Tampilkan Buku");
            System.out.println("5. Keluar");

            System.out.print("Masukkan Pilihan Anda (0-5): ");
            pilihan = simpanData.nextInt();
            simpanData.nextLine();
            switch (pilihan) {
                case 1:
                    System.out.println("======================================================================================================");
                    System.out.printf("%-15s | %-15s | %-15s | %-15s | %-15s | %-15s|%n", "Nomor Buku", "Judul", "Pengarang", "ID Buku", "Genre", "Stok");

                    System.out.println("======================================================================================================");
                    for (int i = 0; i < simpanJudulBuku.size(); i++)
                    {
                        System.out.printf("| %-10s | %-20s | %-20s | %-10s | %-15s | %-10s |%n", i, simpanJudulBuku.get(i), simpanPengarangBuku.get(i), simpanIdBuku.get(i), simpanGenreBuku.get(i), simpanStokBuku.get(i));
                    }
                    System.out.println("=======================================================================================================");

                    System.out.print("Masukkan Nomor Buku Yang Anda Pilih (0-3): ");
                    nomorBuku = simpanData.nextInt();
                    System.out.println("Buku Berhasil Dipinjam!");
                    break;
                case 2:
                    if (nomorBuku == -1) {
                        System.out.println("Buku Belum Dipinjam!");
                    } else if (nomorBuku < 0 || nomorBuku >= simpanJudulBuku.size()) {
                        System.out.println("Nomor Buku Tidak Valid!");
                    } else {
                        System.out.println("\nBerikut Buku Yang Anda Pinjam: ");
                        System.out.println("Judul Buku: " + simpanJudulBuku.get(nomorBuku));
                        System.out.println("Pengarang Buku: " + simpanPengarangBuku.get(nomorBuku));
                        System.out.println("ID Buku: " + simpanIdBuku.get(nomorBuku));
                        System.out.println("Kategori Buku: " + simpanGenreBuku.get(nomorBuku));
                        System.out.println("Stok Buku: " + simpanStokBuku.get(nomorBuku));
                    }
                    break;
                case 3:
                    System.out.print("Masukkan Judul Buku: ");
                    String tambahkanJudulBuku = simpanData.nextLine();
                    simpanJudulBuku.add(tambahkanJudulBuku);
                    System.out.print("Masukkan Pengarang Buku: ");
                    String tambahkanPengarangBuku = simpanData.nextLine();
                    simpanPengarangBuku.add(tambahkanPengarangBuku);
                    System.out.print("Masukkan Genre Buku: ");
                    String tambahkanGenreBuku = simpanData.nextLine();
                    simpanGenreBuku.add(tambahkanGenreBuku);

                    System.out.print("Masukkan Id Buku: ");
                    Integer tambahkanIdBuku = simpanData.nextInt();
                    simpanData.nextLine();
                    simpanIdBuku.add(tambahkanIdBuku);
                    System.out.print("Masukkan Stok Buku: ");
                    Integer tambahkanStokBuku = simpanData.nextInt();
                    simpanData.nextLine();
                    simpanStokBuku.add(tambahkanStokBuku);
                    break;
                case 4:
                    if (simpanJudulBuku.isEmpty())
                    {
                        System.out.println("Buku Belum Ditambahkan");
                    }
                    else {
                    System.out.println("======================================================================================================");
                    System.out.printf("%-15s | %-15s | %-15s | %-15s | %-15s | %-15s|%n", "Nomor Buku", "Judul", "Pengarang", "ID Buku", "Genre", "Stok");
                    System.out.println("======================================================================================================");

                    for (int i = 0; i < simpanJudulBuku.size(); i++)
                    {
                        System.out.printf("| %-10s | %-20s | %-20s | %-10s | %-15s | %-10s |%n", i, simpanJudulBuku.get(i), simpanPengarangBuku.get(i), simpanIdBuku.get(i), simpanGenreBuku.get(i), simpanStokBuku.get(i));
                    }
                    System.out.println("=======================================================================================================");
                    }
                    break;
                case 5:
                    System.out.println("Selesai!");
                    break;
                default:

            }
        } while (pilihan != 5);
    }
}