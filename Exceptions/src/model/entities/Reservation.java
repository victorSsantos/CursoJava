package model.entities;

import model.exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private final Integer roomNumber;
    private Date checkIn;
    private Date checkOut;
    private static final SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut){
        if (!checkOut.after(checkIn))
            throw new DomainException("Check-out date must be after check-in date");
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public long duration(){
        return TimeUnit.DAYS.convert(checkOut.getTime()-checkIn.getTime(), TimeUnit.MILLISECONDS);
    }

    public void updateDates( Date checkIn, Date checkOut){
        if(!this.checkIn.before(checkIn) || !this.checkOut.before(checkOut))
            throw new DomainException("Reservation dates for update must be future dates");
        if (!checkOut.after(checkIn))
            throw new DomainException("Check-out date must be after check-in date");

        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Room: " + roomNumber +
                ", check-in: " + fmt.format(checkIn) +
                ", check-out: " + fmt.format(checkOut) +
                ", " + duration() + " nights";
    }
}
