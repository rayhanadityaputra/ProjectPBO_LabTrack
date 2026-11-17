/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package id.ac.untidar.labtrack.strategy;

/**
 * Interface strategi perhitungan denda (Polimorfisme).
 */
interface HitungDenda {
    double hitungDenda(int hariTerlambat, double nilaiBarang);
}
