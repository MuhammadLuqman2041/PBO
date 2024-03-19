/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hewan_terfavorit;

/**
 *
 * @author Luqman
 */
public class Hewan_Terfavorit {
    
    public String namaHewan = "Oren";
    public int umurHewan = 10;
    public String makananFavorit = "Whiskas";
    public char jenisKelamin = 'M';
    
    public void namaHewan()
    {
        System.out.println("Nama: " + namaHewan);
    }
    public void umurHewan()
    {
        System.out.println("Umur: " + umurHewan);
    }
    public void makananFavorit()
    {
        System.out.println("Makanan Favorit: " + makananFavorit);
    }
    public void jenisKelamin()
    {
        System.out.println("Jenis Kelamin: " + jenisKelamin);
    }
    
    public static void main(String [] args)
    {
        Hewan_Terfavorit hewan = new Hewan_Terfavorit();
        hewan.namaHewan();
        hewan.umurHewan();
        hewan.makananFavorit();
        hewan.jenisKelamin();
    }   
}