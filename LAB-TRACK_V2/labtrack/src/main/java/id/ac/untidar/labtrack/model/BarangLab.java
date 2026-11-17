/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.untidar.labtrack.model;

/**
 * Superclass abstrak untuk master inventaris alat lab.
 */
abstract public class BarangLab {
    protected String kodeBarang;
    protected String namaBarang;
    protected int stok;
    protected String lokasi;
    protected double hargaEstimasi;

    public BarangLab(String kodeBarang, String namaBarang, int stok, String lokasi, double hargaEstimasi) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.stok = stok;
        this.lokasi = lokasi;
        this.hargaEstimasi = hargaEstimasi;
    }

    public String getKodeBarang() { return kodeBarang; }
    public String getNamaBarang() { return namaBarang; }
    public int getStok() { return stok; }
    public double getHargaEstimasi() { return hargaEstimasi; }

    public void tambahStok(int qty) {
        if (qty > 0) this.stok += qty;
    }

    public void kurangiStok(int qty) {
        if (this.stok >= qty) {
            this.stok -= qty;
        } else {
            throw new IllegalStateException("Stok barang '" + namaBarang + "' tidak mencukupi!");
        }
    }

    public abstract String getKategoriBarang();
}