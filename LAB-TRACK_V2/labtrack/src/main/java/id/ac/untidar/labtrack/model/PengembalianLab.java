/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.untidar.labtrack.model;

import java.util.Date;

/**
 * Kelas entitas Pengembalian Alat Lab.
 */
class PengembalianLab {
    private String idPengembalian;
    private Date tglKembaliAktual;
    private String kondisiBarangDiterima;

    public PengembalianLab(String idPengembalian, Date tglKembaliAktual, String kondisiBarangDiterima) {
        this.idPengembalian = idPengembalian;
        this.tglKembaliAktual = tglKembaliAktual;
        this.kondisiBarangDiterima = kondisiBarangDiterima;
    }

    public String getIdPengembalian() { return idPengembalian; }
    public Date getTglKembaliAktual() { return tglKembaliAktual; }
    public String getKondisiBarangDiterima() { return kondisiBarangDiterima; }
}
