/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Java_Pemula;

/**
 *
 * @author Luqman
 */
import java.util.Scanner;

public class LibrarySystem 
{
    public static void main(String [] args)
    {
        int pilihan = 0;
        
        String usernameSiswa = null, usernameAdmin = null, passwordSiswa = null, passwordAdmin = null;
        
        Scanner simpanData = new Scanner(System.in);
        do
        {
        System.out.println("===== Sistem Perpustakaan =====");
        System.out.println("1. Masuk Sebagai Siswa");
        System.out.println("2. Masuk Sebagai Admin");
        System.out.println("3. Keluar");
        
        System.out.print("Pilihan Anda: ");
        pilihan = simpanData.nextInt();
        simpanData.nextLine();
        
        switch (pilihan)
        {
            case 1:
                do
                {
                System.out.print("Maasukkan Username (siswa): ");
                usernameSiswa = simpanData.nextLine();
                System.out.print("Maasukkan Password (siswa): ");
                passwordSiswa = simpanData.nextLine();
                
                if (usernameSiswa.equals("siswa") && passwordSiswa.equals("siswa"))
                {
                    System.out.println("Masuk Berhasil!");
                }
                else
                {
                    System.out.println("Username atau Password Salah!");
                }
                } while (!usernameSiswa.equals("siswa") && !passwordSiswa.equals("siswa"));
                
                break;
            case 2:
                do
                {
                System.out.print("Maasukkan Username (admin): ");
                usernameAdmin = simpanData.nextLine();
                System.out.print("Maasukkan Password (admin): ");
                passwordAdmin = simpanData.nextLine();
                
                if (usernameAdmin.equals("admin") && passwordAdmin.equals("admin"))
                {
                    System.out.println("Masuk Berhasil!");
                }
                else
                {
                    System.out.println("Username atau Password Salah!");
                }
                } while (!usernameAdmin.equals("admin") && !passwordAdmin.equals("admin"));
                break;
            case 3:
                System.out.println("Selesai!");
                break;
            default:
                System.out.println("Pilihan Anda Tidak Valid!");
                break;
        }
        } while (pilihan != 3);
    }
    
}
