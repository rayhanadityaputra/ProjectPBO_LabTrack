/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.untidar.labtrack.model;

import java.util.Date;

/**
 * Kelas entitas Rekap Laporan Peminjaman.
 */
class LaporanPeminjaman {
    private String idLaporan;
    private Date tglCetak;
    private String periode;

    public LaporanPeminjaman(String idLaporan, String periode) {
        this.idLaporan = idLaporan;
        this.periode = periode;
        this.tglCetak = new Date();
    }

    public String generateRekap(int totalTransaksi, double totalDenda) {
        return "=== LAPORAN PEMINJAMAN LAB-TRACK [" + periode + "] ===\n" +
               "ID Laporan      : " + idLaporan + "\n" +
               "Tanggal Cetak   : " + tglCetak + "\n" +
               "Total Transaksi : " + totalTransaksi + "\n" +
               "Total Denda     : Rp " + String.format("%,.2f", totalDenda) + "\n" +
               "===================================================";
    }
}