/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdaterange;
import java.time.LocalDate;
    
import java.time.LocalDate;
import java.util.Iterator;

public class DateRange implements Iterable<LocalDate> {
    
    LocalDate awal, akhir, sekarang;
        
    public DateRange(LocalDate awal, LocalDate akhir){
        this.awal = awal;
        this.akhir = akhir;
        this.sekarang = awal;
    }

    @Override
    public Iterator<LocalDate> iterator() {
        return new DateRangeIterator(this.awal,this.akhir);
    }
    
    public boolean contains(LocalDate localdate){
        return (localdate.isAfter(awal) && localdate.isBefore(akhir)) || localdate.equals(awal) || localdate.equals(akhir);
    }
    
    public boolean overlap(DateRange daterange){
        return contains(daterange.awal) || contains(daterange.akhir) || (daterange.awal.isBefore(this.awal) && daterange.akhir.isAfter(this.akhir));
    }
        
}
