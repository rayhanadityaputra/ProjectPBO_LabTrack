/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.untidar.labtrack.service;

class LaporanService {
    private final TransaksiRepository transaksiRepo;

    public LaporanService(TransaksiRepository transaksiRepo) {
        this.transaksiRepo = transaksiRepo;
    }

    public void cetakLaporanBulanan(String periode, double totalPendapatanDenda) {
        List<TransaksiPeminjaman> daftar = transaksiRepo.cariSemua();
        LaporanPeminjaman lap = new LaporanPeminjaman("LAP-" + System.currentTimeMillis(), periode);
        System.out.println("\n" + lap.generateRekap(daftar.size(), totalPendapatanDenda));
    }
}
