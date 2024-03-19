/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pbo_modul_2;

/**
 *
 * @author Luqman
 */

import java.util.Scanner;
public class PBO_Modul_2 
{
    public static void main(String [] args)
    {
        int pilihan = 0;
        
        Mahasiswa dataMahasiswa = new Mahasiswa();
        Admin dataAdmin = new Admin();
        SistemPerpustakaan sistemPerpustakaan = new SistemPerpustakaan();
        
        Scanner simpanData = new Scanner (System.in);
        
        do
        {
            System.out.println("\n===== Sistem Perpustakaan =====");
            System.out.println("1. Masuk Sebagai Mahasiswa");
            System.out.println("2. Masuk Sebagai Admin");
            System.out.println("3. Keluar");
            
            System.out.print("Masukkan Pilihan Anda (1-3): ");
            pilihan = simpanData.nextInt();
            simpanData.nextLine();
            
            switch(pilihan)
            {
                case 1:
                    do
                    {
                        System.out.print("Masukkan Username Mahasiswa (mahasiswa): ");
                        sistemPerpustakaan.setUsernameMahasiswa(simpanData.nextLine());
                        System.out.print("Masukkan Password Mahasiswa (mahasiswa): ");
                        sistemPerpustakaan.setPasswordMahasiswa(simpanData.nextLine());
                        
                        if (sistemPerpustakaan.usernameMahasiswa.equals("mahasiswa") && sistemPerpustakaan.passwordMahasiswa.equals("mahasiswa"))
                        {
                            System.out.println("Masuk Berhasil!");
                        }
                        else
                        {
                            System.out.println("Username atau Password Salah!");
                        }
                    } while (!sistemPerpustakaan.usernameMahasiswa.equals("mahasiswa") && !sistemPerpustakaan.passwordMahasiswa.equals("mahasiswa"));
                    break;
                    
                case 2:
                    do
                    {
                        System.out.print("Masukkan Username Admin (admin): ");
                        sistemPerpustakaan.setUsernameAdmin(simpanData.nextLine());
                        System.out.print("Masukkan Password Admin (admin): ");
                        sistemPerpustakaan.setPasswordAdmin(simpanData.nextLine());
                        
                        if (sistemPerpustakaan.usernameAdmin.equals("admin") && sistemPerpustakaan.passwordAdmin.equals("admin"))
                        {
                            System.out.println("Masuk Berhasil!");
                        }
                        else
                        {
                            System.out.println("Username atau Password Salah!");
                        }
                    } while (!sistemPerpustakaan.usernameAdmin.equals("admin") && !sistemPerpustakaan.passwordAdmin.equals("admin"));
                    break;
                case 3:
                    System.out.println("Selesai!");
                    break;
                    default:
                    System.out.println("Pilihan Anda Tidak Valid!");
            }
        } while (pilihan != 3);
       
        do
        {
            System.out.println("\n===== Menu Admin =====");
            System.out.println("1. Tambahkan Data Mahasiswa");
            System.out.println("2. Tampilkan Data Mahasiswa");
            System.out.println("3. Keluar");
            
            System.out.print("Masukkan Pilihan Anda (1-3): ");
            pilihan = simpanData.nextInt();
            simpanData.nextLine();
            
            switch (pilihan)
            {
                case 1:
                    System.out.print("Masukkan Nama Mahasiswa: ");
                    dataAdmin.setNamaMahasiswa(simpanData.nextLine());
                    
                    do
                    {
                        System.out.print("Masukkan NIM Mahasiswa: ");
                        dataAdmin.setNimMahasiswa(simpanData.nextLong());
                        simpanData.nextLine();
                        if (String.valueOf(dataAdmin.getNimMahasiswa()).length() != 15)
                        {
                            System.out.println("NIM Harus 15 Digit!");
                        }
                    }while(String.valueOf(dataAdmin.getNimMahasiswa()).length() != 15);
                    System.out.print("Masukkan Fakultas Mahasiswa: ");
                    dataAdmin.setFakultasMahasiswa(simpanData.nextLine());
                    System.out.print("Masukkan Prodi Mahasiswa: ");
                    dataAdmin.setProdiMahasiswa(simpanData.nextLine());
                    break;
                    
                case 2:
                    if (dataAdmin.namaMahasiswa == null && dataAdmin.nimMahasiswa == 0 && dataAdmin.fakultasMahasiswa == null && dataAdmin.prodiMahasiswa == null)
                    {
                        System.out.println("Data Mahasiswa Belum Ditambahkan!");
                    }
                    else
                    {
                        System.out.print("\nNama Mahasiswa: " + dataAdmin.getNamaMahasiswa());
                        System.out.print("\nNIM Mahasiswa: " + dataAdmin.getNimMahasiswa());
                        System.out.print("\nFakultas Mahasiswa: " + dataAdmin.getFakultasMahasiswa());
                        System.out.print("\nProdi Mahasiswa: " + dataAdmin.getProdiMahasiswa());
                    }
                    break;
                case 3:
                    System.out.println("Selesai!");
                    break;
                default:
                    System.out.println("Pilihan Anda Tidak Valid!");
            }
            
        } while (pilihan != 3);
    
        do
        {
            System.out.println("\n===== Menu Mahasiswa =====");
            System.out.println("1. Pinjam Buku");
            System.out.println("2. Buku Yang Dipinjam");
            System.out.println("3. Keluar");
            
            System.out.print("Masukkan Pilihan Anda (0-3): ");
            pilihan = simpanData.nextInt();
            simpanData.nextLine();
            switch (pilihan)
            {
                case 1:
                    System.out.println("======================================================================================================");
                    System.out.printf("%-15s | %-15s | %-15s | %-15s | %-15s | %-15s|%n", "Nomor Buku", "Judul", "Pengarang", "ID Buku", "Genre", "Stok");
                    System.out.println("======================================================================================================");

                    System.out.printf("| %-10s | %-20s | %-20s | %-10s | %-15s | %-10s |%n", "0", "Buku Indonesia", "Soekarno", "0001", "Fantasy", "10");
                    System.out.printf("| %-10s | %-20s | %-20s | %-10s | %-15s | %-10s |%n", "1", "Buku Jepang", "Hirohito", "0002", "Isekai", "5");
                    System.out.printf("| %-10s | %-20s | %-20s | %-10s | %-15s | %-10s |%n", "2", "Buku Inggris", "Elizabeth", "0003", "Noble", "20");
                    System.out.printf("| %-10s | %-20s | %-20s | %-10s | %-15s | %-10s |%n", "3", "Buku Jerman", "Hitler", "0004", "Action", "15");
                    System.out.println("=======================================================================================================");

        
                    System.out.print("Masukkan Nomor Buku Yang Anda Pilih (0-3): ");
                    dataMahasiswa.nomorBuku = simpanData.nextInt();
                    System.out.println("Buku Berhasil Dipinjam!");
                    break;
                case 2:
                    if (dataMahasiswa.getNomorBuku() == -1)
                    {
                        System.out.println("Buku Belum Dipinjam!");
                    }
                    else if (dataMahasiswa.getNomorBuku() < 0 && dataMahasiswa.getNomorBuku() >= dataMahasiswa.getJudulBuku().length)
                    {
                        System.out.println("Nomor Buku Tidak Valid!");
                    }
                    else
                    {
                        System.out.println("\nBerikut Buku Yang Anda Pinjam: ");
                        System.out.println("Judul Buku: " +dataMahasiswa.getJudulBuku()[dataMahasiswa.getNomorBuku()]);
                        System.out.println("Pengarang Buku: " +dataMahasiswa.getPengarangBuku()[dataMahasiswa.getNomorBuku()]);
                        System.out.println("ID Buku: " +dataMahasiswa.getIdBuku()[dataMahasiswa.getNomorBuku()]);
                        System.out.println("Kategori Buku: " +dataMahasiswa.getKategoriBuku()[dataMahasiswa.getNomorBuku()]);
                        System.out.println("Stok Buku: " +dataMahasiswa.getStokBuku()[dataMahasiswa.getNomorBuku()]);
                    }
                    break;
                case 3:
                    System.out.println("Selesai!");
                    break;
                default:
                    
            }
        } while (pilihan != 3);
    }

       
    static class Mahasiswa
    {
        private int nomorBuku = -1;
         
        private String[] idBuku = {"001", "002", "003", "004"};
        private int[] stokBuku = {10, 5, 20, 15};
        
        private String[] judulBuku = {"Buku Indonesia", "Buku Jepang", "Buku Inggris", "Buku Jerman"};
        private String[] pengarangBuku = {"Soekarno", "Hirohito", "Elizabeth", "Hitler"};
        private String[] kategoriBuku = {"Fantasi", "Isekai", "Petualangan", "Martial Art"};
       
        public void setNomorBuku(int nomorBuku)
        {
            this.nomorBuku = nomorBuku;
        }
       
        public String[] getJudulBuku()
        {
            return judulBuku;
        }
        
        public String[] getPengarangBuku()
        {
            return pengarangBuku;
        }
        
                
        public String[] getKategoriBuku()
        {
            return kategoriBuku;
        }
        
        public int getNomorBuku()
        {
            return nomorBuku;
        }
        
        public int[] getStokBuku()
        {
            return stokBuku;
        }
        public String[] getIdBuku()
        {
            return idBuku;
        }
    } 
        
    static class Admin
    {
        private String namaMahasiswa = null;
        private String fakultasMahasiswa = null;
        private String prodiMahasiswa = null;
        private long nimMahasiswa = 0;
        
        public void setNamaMahasiswa(String namaMahasiswa)
        {
            this.namaMahasiswa = namaMahasiswa;
        }
        public void setNimMahasiswa(long nimMahasiswa)
        {
            this.nimMahasiswa = nimMahasiswa;
        }
        public void setFakultasMahasiswa(String fakultasMahasiswa)
        {
            this.fakultasMahasiswa = fakultasMahasiswa;
        }
        public void setProdiMahasiswa(String prodiMahasiswa)
        {
            this.prodiMahasiswa = prodiMahasiswa;
        }
        
        public String getNamaMahasiswa()
        {
            return namaMahasiswa;
        }
        public long getNimMahasiswa()
        {
            return nimMahasiswa;
        }
        public String getFakultasMahasiswa()
        {
            return fakultasMahasiswa;
        }
        public String getProdiMahasiswa()
        {
            return prodiMahasiswa;
        }
    }
    
        static class SistemPerpustakaan
    {
        private String usernameMahasiswa = null;
        private String usernameAdmin = null;
        private String passwordMahasiswa = null;
        private String passwordAdmin = null;
        
        public void setUsernameMahasiswa(String usernameMahasiswa)
        {
            this.usernameMahasiswa = usernameMahasiswa;
        }
        public void setUsernameAdmin(String usernameAdmin)
        {
            this.usernameAdmin = usernameAdmin;
        }
        public void setPasswordMahasiswa(String passwordMahasiswa)
        {
            this.passwordMahasiswa = passwordMahasiswa;
        }
        public void setPasswordAdmin(String passwordAdmin)
        {
            this.passwordAdmin = passwordAdmin;
        }
        
        public String getUsernameMahasiswa()
        {
            return usernameMahasiswa;
        }
        public String getUsernameAdmin()
        {
            return usernameAdmin;
        }
        public String getPasswordMahasiswa()
        {
            return passwordMahasiswa;
        }
        public String getPasswordAdmin()
        {
            return passwordAdmin;
        }
    }
}