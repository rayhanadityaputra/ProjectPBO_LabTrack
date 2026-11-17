/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.untidar.labtrack.repository;

import id.ac.untidar.labtrack.model.TransaksiPeminjaman;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MemoryTransaksiRepository implements TransaksiRepository {
    private Map<String, TransaksiPeminjaman> dbTransaksi = new HashMap<>();

    public void simpan(TransaksiPeminjaman t) { dbTransaksi.put(t.getIdTransaksi(), t); }
    public TransaksiPeminjaman cariById(String id) { return dbTransaksi.get(id); }
    public List<TransaksiPeminjaman> cariSemua() { return new ArrayList<>(dbTransaksi.values()); }
    public void update(TransaksiPeminjaman t) { dbTransaksi.put(t.getIdTransaksi(), t); }
}
