package org.test;

import org.model.account.Account;
import org.model.account.Admin;
import org.model.parking.*;
import org.model.util.ParkingSpotType;
import org.model.util.VehicleType;
import org.model.vehicle.Car;
import org.model.vehicle.MotorBike;
import org.model.vehicle.Vehicle;

import java.util.UUID;

public class ParkingLotApplication {
    public static void main(String[] args) throws Exception {

        ParkingLot parkinglot = ParkingLot.getInstance();

        Address address = new Address();
        address.setAddressLine1("BMZ Complex");
        address.setStreet("BG Road");
        address.setCity("Bangalore");
        address.setState("Karnataka");
        address.setCountry("India");
        address.setPinCode("711004");

        parkinglot.setAddress(address);

        Account adminAccount = new Admin();

        ((Admin) adminAccount).addParkingFloor(new ParkingFloor("1"));
        ((Admin) adminAccount).addParkingFloor(new ParkingFloor("2"));

        EntrancePanel entrancePanel = new EntrancePanel("1");
        ((Admin) adminAccount).addEntrancePanel(entrancePanel);

        ExitPanel exitPanel = new ExitPanel("1");
        ((Admin) adminAccount).addExitpanel(exitPanel);

        //System.out.println(parkinglot.getParkingFloors().size());
        String floorId = parkinglot.getParkingFloors().get(0).getFloorId();

        ParkingSpot carSpot = new CarParkingSpot("c1");
        ((Admin) adminAccount).addParkingSpot(floorId,carSpot);

        ParkingSpot bikeSport = new MotorBikeParkingSpot("b1");
        ((Admin) adminAccount).addParkingSpot(floorId, bikeSport);

        ParkingSpot carSpot2 = new CarParkingSpot("c2");
        ((Admin) adminAccount).addParkingSpot(floorId, carSpot2);

        // Test case 1 - check for availability of parking lot - TRUE
        System.out.println("Is CAR vehicle can be parked : "+parkinglot.canPark(VehicleType.CAR));

        // Test case 2 - check for availability of parking lot - FALSE
        System.out.println("Is EV vehicle can be parked : "+parkinglot.canPark(VehicleType.EV));

        // Test case 3 - check for availability of parking lot - TRUE
        System.out.println("Is MOTORBIKE vehicle can be parked : "+parkinglot.canPark(VehicleType.MOTORBIKE));

        // TEST case 4 - Check if full
        System.out.println("Is parking lot full : "+parkinglot.isFull());

        // Test case 5 - get parking spot
        Vehicle car = new Car("WB670970");
        ParkingTicket parkingTicket = entrancePanel.getParkingTicket(car);
        System.out.println("Allocated spot for vehicle number "+parkingTicket.getLicensePlateNumber() +" : "+parkingTicket.getAllocatedSpotId());

        //((Admin) adminAccount).addParkingSpot(floorId, carSpot);

        // Test case 6 - Should be able to get ticket

        ParkingTicket tkt = entrancePanel.getParkingTicket(new Car("ka04rb8458"));
        System.out.println("Allocated spot for vehicle number "+tkt.getLicensePlateNumber() +" : "+tkt.getAllocatedSpotId());

        // Test case - 7 - Should be able to get parking ticket
        //Now Car its Full
        //Will NOt be able to parkCar
        //This will throw an Exception as there is no parking spot available
//        Vehicle newCar = new Car("KA02MR6355");
//        ParkingTicket parkingTicket1 = entrancePanel.getParkingTicket(newCar);
//        System.out.println("newCar "+ parkingTicket1.getAllocatedSpotId());

        // Test case 8 - Should be able to get ticket
        ParkingTicket mtrTkt = entrancePanel.getParkingTicket(new MotorBike("ka01ee4901"));
        System.out.println("Allocated spot for vehicle number "+mtrTkt.getLicensePlateNumber() +" : "+mtrTkt.getAllocatedSpotId());

        // Test case 9 - should be able to vacate parking spot
        mtrTkt = exitPanel.scanAndVacate(mtrTkt);
        System.out.println("Motorbike charge : "+mtrTkt.getCharge());
        System.out.println("Is motorbike charge more than 0 : "+ (mtrTkt.getCharge()>0));

        // Test case 10 - park on vacated spot
        ParkingTicket mtrTkt1 = entrancePanel.getParkingTicket(new MotorBike("ka01ee7791"));
        System.out.println("Allocated spot for vehicle number "+mtrTkt1.getLicensePlateNumber() +" : "+mtrTkt1.getAllocatedSpotId());

        // Test case 11 - park when spot is not available
        // Exception as no bike spot is left to park
        //ParkingTicket unavaialbemTkt =
        //         entrancePanel.getParkingTicket(new MotorBike("ka01ee4455"));
        // System.out.println(null == unavaialbemTkt);

        // Test cast 12 - vacate car
        parkingTicket = exitPanel.scanAndVacate(parkingTicket);
        System.out.println("car charge : "+parkingTicket.getCharge());
        System.out.println("Is car charge more than 0 : "+ (parkingTicket.getCharge() > 0));

        //Test case 13 - Now should be able to park car
        System.out.println("Can car be parked > "+ParkingLot.getInstance().canPark(VehicleType.CAR));

        //Test case 14 - check for slots count
        System.out.println("Free sots : "+ParkingLot.getInstance().getParkingFloors()
                .get(0).getParkingSpots().get(ParkingSpotType.CAR).size());

        //Test case 19 - Payment
        Payment payment = new Payment(UUID.randomUUID().toString(),
                parkingTicket.getTicketNumber(), parkingTicket.getCharge());
        payment.makePayment();
        System.out.println("Payment status : "+payment.getPaymentStatus());

    }
}
