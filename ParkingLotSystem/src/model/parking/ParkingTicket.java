package model.parking;

import lombok.Getter;
import lombok.Setter;
import model.util.TicketStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class ParkingTicket {
    private String ticketNumber;
    private String licensePlateNumber;
    private String allocatedSpotId;
    private LocalDateTime issuedAt;
    private LocalDateTime vacatedAt;
    private double charge;
    private TicketStatus ticketStatus;
}
