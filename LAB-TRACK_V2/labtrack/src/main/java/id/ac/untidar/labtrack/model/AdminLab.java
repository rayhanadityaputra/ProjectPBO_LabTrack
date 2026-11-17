/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.untidar.labtrack.model;

/**
 * Subclass pengguna peran Admin Lab.
 */
class AdminLab extends Pengguna implements AksiAdmin {
    private String nip;
    private String jabatan;

    public AdminLab(String idUser, String nama, String email, String password, String nip, String jabatan) {
        super(idUser, nama, email, password);
        this.nip = nip;
        this.jabatan = jabatan;
    }

    public String getNip() { return nip; }
    public String getJabatan() { return jabatan; }

    @Override
    public String getRole() { return "AdminLab"; }

    @Override
    public void kelolaBarang() {
        System.out.println("Admin Lab " + nama + " mengelola inventaris barang.");
    }

    @Override
    public void approvePeminjaman() {
        System.out.println("Admin Lab " + nama + " memverifikasi pengajuan peminjaman.");
    }

    @Override
    public void prosesPengembalian() {
        System.out.println("Admin Lab " + nama + " memproses pengembalian fisik barang.");
    }
}