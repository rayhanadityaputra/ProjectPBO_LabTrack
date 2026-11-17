/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.untidar.labtrack.model;

import java.util.Date;

/**
 * Subclass inventaris jenis Barang Konsumabel.
 */
class BarangKonsumabel extends BarangLab {
    private Date masaPakai;
    private boolean isHabisPakai;

    public BarangKonsumabel(String kodeBarang, String namaBarang, int stok, String lokasi, double harga, Date masaPakai, boolean isHabisPakai) {
        super(kodeBarang, namaBarang, stok, lokasi, harga);
        this.masaPakai = masaPakai;
        this.isHabisPakai = isHabisPakai;
    }

    @Override
    public String getKategoriBarang() { return "Konsumabel"; }
}