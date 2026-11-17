/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.untidar.labtrack.strategy;

/**
 * Implementasi strategi denda akibat kerusakan fisik atau kehilangan barang.
 */
class DendaKerusakan implements HitungDenda {
    private double persentaseKerusakan; // Contoh: 0.5 (50%), 1.0 (100%)

    public DendaKerusakan(double persentaseKerusakan) {
        this.persentaseKerusakan = persentaseKerusakan;
    }

    @Override
    public double hitungDenda(int hariTerlambat, double nilaiBarang) {
        return nilaiBarang * persentaseKerusakan;
    }
}