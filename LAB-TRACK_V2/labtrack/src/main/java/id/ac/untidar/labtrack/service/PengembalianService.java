/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.untidar.labtrack.service;

class PengembalianService {
    private final TransaksiRepository transaksiRepo;
    private final BarangRepository barangRepo;
    private final Notifikasi notif;

    public PengembalianService(TransaksiRepository transaksiRepo, BarangRepository barangRepo, Notifikasi notif) {
        this.transaksiRepo = transaksiRepo;
        this.barangRepo = barangRepo;
        this.notif = notif;
    }

    public double prosesPengembalian(String idTx, Date tglKembaliAktual, int hariTerlambat, String kondisiBarang) {
        TransaksiPeminjaman tx = transaksiRepo.cariById(idTx);
        if (tx == null || !tx.getStatus().equals("APPROVED")) {
            System.out.println("[GAGAL] Transaksi tidak valid untuk diproses pengembalian.");
            return 0.0;
        }

        // Catat entitas pengembalian
        PengembalianLab pengembalian = new PengembalianLab("RET-" + idTx, tglKembaliAktual, kondisiBarang);
        tx.setPengembalian(pengembalian);
        tx.setStatus("COMPLETED");

        double totalDenda = 0.0;

        // 1. Hitung Denda Keterlambatan jika ada
        if (hariTerlambat > 0) {
            HitungDenda dendaHarian = new DendaTerlambat(5000.0); // Rp 5.000 / hari
            totalDenda += dendaHarian.hitungDenda(hariTerlambat, 0);
        }

        // 2. Kembalikan stok fisik dan hitung Denda Kerusakan jika rusak
        for (ItemPeminjam item : tx.getDaftarItem()) {
            BarangLab b = barangRepo.cariByKode(item.getBarang().getKodeBarang());
            
            if (kondisiBarang.equalsIgnoreCase("RUSAK")) {
                HitungDenda dendaFisik = new DendaKerusakan(0.5); // 50% dari harga barang
                totalDenda += dendaFisik.hitungDenda(0, b.getHargaEstimasi() * item.getJumlah());
            } else {
                // Jika kondisi baik, kembalikan stok
                b.tambahStok(item.getJumlah());
                barangRepo.update(b);
            }
        }

        transaksiRepo.update(tx);
        notif.kirimPesan(tx.getPeminjam().getEmail(), "Pengembalian " + idTx + " selesai. Total Denda: Rp " + String.format("%,.2f", totalDenda));
        return totalDenda;
    }
}