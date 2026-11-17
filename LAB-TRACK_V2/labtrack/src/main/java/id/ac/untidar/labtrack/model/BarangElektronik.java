/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.untidar.labtrack.model;

/**
 * Subclass inventaris jenis Barang Elektronik.
 */
class BarangElektronik extends BarangLab {
    private String dayaListrik;
    private String statusKalibrasi;

    public BarangElektronik(String kodeBarang, String namaBarang, int stok, String lokasi, double harga, String dayaListrik, String statusKalibrasi) {
        super(kodeBarang, namaBarang, stok, lokasi, harga);
        this.dayaListrik = dayaListrik;
        this.statusKalibrasi = statusKalibrasi;
    }

    @Override
    public String getKategoriBarang() { return "Elektronik"; }
}