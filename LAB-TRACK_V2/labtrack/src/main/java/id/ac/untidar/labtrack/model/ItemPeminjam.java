/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.untidar.labtrack.model;

/**
 * Kelas perantara Komposisi Item Peminjaman.
 */
class ItemPeminjam {
    private int jumlah;
    private BarangLab barang; // Relasi Agregasi ke BarangLab

    public ItemPeminjam(BarangLab barang, int jumlah) {
        this.barang = barang;
        this.jumlah = jumlah;
    }

    public int getJumlah() { return jumlah; }
    public BarangLab getBarang() { return barang; }
}