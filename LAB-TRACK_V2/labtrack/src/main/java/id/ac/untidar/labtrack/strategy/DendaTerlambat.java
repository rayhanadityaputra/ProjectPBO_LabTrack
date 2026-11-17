/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.untidar.labtrack.strategy;

/**
 * Implementasi strategi denda harian akibat keterlambatan.
 */
class DendaTerlambat implements HitungDenda {
    private double tarifHarian;

    public DendaTerlambat(double tarifHarian) {
        this.tarifHarian = tarifHarian;
    }

    @Override
    public double hitungDenda(int hariTerlambat, double nilaiBarang) {
        if (hariTerlambat <= 0) return 0.0;
        return hariTerlambat * tarifHarian;
    }
}