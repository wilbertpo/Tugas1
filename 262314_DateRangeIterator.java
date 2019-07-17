/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdaterange;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Asus
 */
public class DateRangeIterator implements Iterator<LocalDate> {
    LocalDate awal,akhir,sekarang;
    
    public DateRangeIterator(LocalDate awal, LocalDate akhir){
        this.awal = awal;
        this.akhir = akhir;
        this.sekarang = awal;
    }

    public boolean hasNext() {
        return sekarang.plusDays(1).isBefore(akhir);
    }

    @Override
    public LocalDate next() {
        if (!hasNext()) throw new NoSuchElementException();
        LocalDate now = this.sekarang;
        this.sekarang = this.sekarang.plusDays(1);
        return now;
    }
    
}
