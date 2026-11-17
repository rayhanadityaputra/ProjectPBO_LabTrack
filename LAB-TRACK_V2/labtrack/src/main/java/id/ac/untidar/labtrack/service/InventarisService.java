/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.untidar.labtrack.service;

class InventarisService {
    private final BarangRepository barangRepo;

    public InventarisService(BarangRepository barangRepo) {
        this.barangRepo = barangRepo;
    }

    public void tambahBarang(BarangLab b) {
        barangRepo.simpan(b);
        System.out.println("[INVENTARIS] Barang baru berhasil ditambahkan: " + b.getNamaBarang());
    }

    public void tampilkanKatalog() {
        System.out.println("\n---------------- KATALOG INVENTARIS ALAT LAB ----------------");
        for (BarangLab b : barangRepo.cariSemua()) {
            System.out.printf("[%s] %-25s | Kategori: %-10s | Stok: %-3d | Lokasi: %s\n",
                    b.getKodeBarang(), b.getNamaBarang(), b.getKategoriBarang(), b.getStok(), b.lokasi);
        }
        System.out.println-------------------------------------------------------------");
    }
}