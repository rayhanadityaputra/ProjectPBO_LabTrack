/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.untidar.labtrack.service;

import id.ac.untidar.labtrack.model.ItemPeminjam;
import id.ac.untidar.labtrack.model.TransaksiPeminjaman;
import id.ac.untidar.labtrack.repository.BarangRepository;
import id.ac.untidar.labtrack.repository.TransaksiRepository;
import id.ac.untidar.labtrack.notification.Notifikasi;

class PeminjamanService {
    private final TransaksiRepository transaksiRepo;
    private final BarangRepository barangRepo;
    private final Notifikasi notif;

    // Dependency Injection melalui konstruktor (DIP)
    public PeminjamanService(TransaksiRepository transaksiRepo, BarangRepository barangRepo, Notifikasi notif) {
        this.transaksiRepo = transaksiRepo;
        this.barangRepo = barangRepo;
        this.notif = notif;
    }

    public boolean ajukanPeminjaman(TransaksiPeminjaman tx) {
        // Validasi ketersediaan stok tiap item
        for (ItemPeminjam item : tx.getDaftarItem()) {
            BarangLab b = barangRepo.cariByKode(item.getBarang().getKodeBarang());
            if (b == null || b.getStok() < item.getJumlah()) {
                System.out.println("[GAGAL] Stok barang " + item.getBarang().getNamaBarang() + " tidak mencukupi!");
                return false;
            }
        }
        transaksiRepo.simpan(tx);
        notif.kirimPesan(tx.getPeminjam().getEmail(), "Pengajuan peminjaman " + tx.getIdTransaksi() + " berhasil dibuat.");
        return true;
    }

    public boolean approvePeminjaman(String idTx) {
        TransaksiPeminjaman tx = transaksiRepo.cariById(idTx);
        if (tx != null && tx.getStatus().equals("PENDING")) {
            // Potong stok barang saat disetujui Admin Lab
            for (ItemPeminjam item : tx.getDaftarItem()) {
                BarangLab b = barangRepo.cariByKode(item.getBarang().getKodeBarang());
                b.kurangiStok(item.getJumlah());
                barangRepo.update(b);
            }
            tx.setStatus("APPROVED");
            transaksiRepo.update(tx);
            notif.kirimPesan(tx.getPeminjam().getEmail(), "Peminjaman " + idTx + " telah DISETUJUI oleh Admin Lab.");
            return true;
        }
        return false;
    }

    public boolean rejectPeminjaman(String idTx) {
        TransaksiPeminjaman tx = transaksiRepo.cariById(idTx);
        if (tx != null && tx.getStatus().equals("PENDING")) {
            tx.setStatus("REJECTED");
            transaksiRepo.update(tx);
            notif.kirimPesan(tx.getPeminjam().getEmail(), "Peminjaman " + idTx + " DITOLAK oleh Admin Lab.");
            return true;
        }
        return false;
    }

    public void ingatkanJatuhTempo(String idTx) {
        TransaksiPeminjaman tx = transaksiRepo.cariById(idTx);
        if (tx != null && tx.getStatus().equals("APPROVED")) {
            notif.kirimPesan(tx.getPeminjam().getEmail(), "[PERINGATAN] Transaksi " + idTx + " mendekati batas jatuh tempo pengembalian!");
        }
    }
}
