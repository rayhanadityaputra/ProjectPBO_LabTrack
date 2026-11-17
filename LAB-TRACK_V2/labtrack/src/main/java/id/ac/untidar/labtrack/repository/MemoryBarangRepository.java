/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.untidar.labtrack.repository;

import id.ac.untidar.labtrack.model.BarangLab;
import id.ac.untidar.labtrack.model.TransaksiPeminjaman;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MemoryBarangRepository implements BarangRepository {
    private Map<String, BarangLab> dbBarang = new HashMap<>();

    public void simpan(BarangLab b) { dbBarang.put(b.getKodeBarang(), b); }
    public BarangLab cariByKode(String kode) { return dbBarang.get(kode); }
    public List<BarangLab> cariSemua() { return new ArrayList<>(dbBarang.values()); }
    public void update(BarangLab b) { dbBarang.put(b.getKodeBarang(), b); }
    public boolean hapus(String kode) { return dbBarang.remove(kode) != null; }
}

interface TransaksiRepository {
    void simpan(TransaksiPeminjaman t);
    TransaksiPeminjaman cariById(String id);
    List<TransaksiPeminjaman> cariSemua();
    void update(TransaksiPeminjaman t);
}