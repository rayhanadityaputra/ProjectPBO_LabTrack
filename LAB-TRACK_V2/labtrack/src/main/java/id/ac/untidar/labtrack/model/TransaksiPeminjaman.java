/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.untidar.labtrack.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Kelas entitas Transaksi Peminjaman Utama.
 */
public class TransaksiPeminjaman {
    private String idTransaksi;
    private Date tglPinjam;
    private Date tglBatasKembali;
    private String status; // PENDING, APPROVED, REJECTED, COMPLETED
    private Pengguna peminjam; // Relasi Asosiasi
    private List<ItemPeminjam> daftarItem = new ArrayList<>(); // Relasi Komposisi
    private PengembalianLab pengembalian; // Relasi Asosiasi (0..1)

    public TransaksiPeminjaman(String idTransaksi, Pengguna peminjam, Date tglPinjam, Date tglBatasKembali) {
        this.idTransaksi = idTransaksi;
        this.peminjam = peminjam;
        this.tglPinjam = tglPinjam;
        this.tglBatasKembali = tglBatasKembali;
        this.status = "PENDING";
    }

    public void tambahItem(BarangLab barang, int jumlah) {
        // Objek ItemPeminjam dibuat di dalam TransaksiPeminjaman (Komposisi)
        daftarItem.add(new ItemPeminjam(barang, jumlah));
    }

    public String getIdTransaksi() { 
        return idTransaksi; 
    }
    public Pengguna getPeminjam() { 
        return peminjam; 
    }
    public String getStatus() { 
        return status; 
    }
    public void setStatus(String status) { 
        this.status = status; 
    }
    public List<ItemPeminjam> getDaftarItem() { 
        return daftarItem; 
    }
    public PengembalianLab getPengembalian() { 
        return pengembalian; 
    }
    public void setPengembalian(PengembalianLab pengembalian) { 
        this.pengembalian = pengembalian; 
    }
}
