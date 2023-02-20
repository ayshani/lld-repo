package org.bms.providers;

import org.bms.exception.SeatTemporaryUnavailableException;
import org.bms.model.Seat;
import org.bms.model.SeatLock;
import org.bms.model.Show;

import java.util.*;

public class InMemorySeatLockProvider  implements SeatLockProvider{
    private final Integer lockTimeOut;
    private final Map<Show, Map<Seat, SeatLock>> locks;

    public InMemorySeatLockProvider(Integer lockTimeOut) {
        this.lockTimeOut = lockTimeOut;
        this.locks = new HashMap<>();
    }

    @Override
    synchronized public void lockSeats(Show show, List<Seat> seats, String user) {
        for(Seat seat: seats){
            if(isSeatLocked(show, seat)){
                throw new SeatTemporaryUnavailableException();
            }
        }
        for(Seat seat: seats){
            lockSeat(show, seat, user, lockTimeOut);
        }
    }

    private boolean isSeatLocked(Show show, Seat seat) {
        return locks.containsKey(show) && locks.get(show).containsKey(seat)  && !locks.get(show).get(seat).isLockExpired();
    }

    private void lockSeat(Show show, Seat seat, String user, Integer lockTimeOut) {
        locks.putIfAbsent(show, new HashMap<>());

        final SeatLock seatLock = new SeatLock(seat,show,lockTimeOut,new Date(),user);
        locks.get(show).put(seat,seatLock);
    }

    @Override
    public void unlockSeats(Show show, List<Seat> seats, String user) {
        for(Seat seat : seats){
            if(validateLock(show,seat,user)){
                unlockSeat(show, seat);
            }
        }
    }

    private void unlockSeat(Show show, Seat seat) {
        if(!locks.containsKey(show))
            return;
        locks.get(show).remove(seat);
    }

    @Override
    public boolean validateLock(Show show, Seat seat, String user) {
        return isSeatLocked(show,seat) && locks.get(show).get(seat).getLockedBy().equals(user);
    }

    @Override
    public List<Seat> getLockedSeats(Show show) {
        final List<Seat> lockedSeats = new ArrayList<>();
        if(!locks.containsKey(show))
            return lockedSeats;

        for(Seat seat : locks.get(show).keySet()){
            if(isSeatLocked(show,seat)){
                lockedSeats.add(seat);
            }
        }
        return lockedSeats;
    }
}
