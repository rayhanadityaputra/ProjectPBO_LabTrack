/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.untidar.labtrack.model;

/**
 * Subclass pengguna peran Mahasiswa.
 */
class Mahasiswa extends Pengguna implements AksiPeminjam {
    private int nim;
    private String prodi;

    public Mahasiswa(String idUser, String nama, String email, String password, int nim, String prodi) {
        super(idUser, nama, email, password);
        this.nim = nim;
        this.prodi = prodi;
    }

    public int getNim() { return nim; }
    public String getProdi() { return prodi; }

    @Override
    public String getRole() { return "Mahasiswa"; }
    public void lihatKatalog() {
        System.out.println("Mahasiswa " + nama + " melihat katalog alat lab.");
    }
    public void ajukanPeminjaman() {
        System.out.println("Mahasiswa " + nama + " mengajukan peminjaman alat lab.");
    }
}
