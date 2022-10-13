package com.rideshare.service;

import com.rideshare.model.Ride;
import com.rideshare.model.User;
import com.rideshare.model.Vehicle;
import com.rideshare.repo.RideRepository;

import java.text.*;
import java.util.*;

public class RideService {

    private static RideRepository rideRepository = new RideRepository();

    public static Ride offerRide(String ownerName, String regNo, int availableSeats, String origin,
                                 String destination, String startTime, int duration) throws ParseException {
        User user = UserService.getUserByNameAndRegNo(ownerName,regNo);
        if(user == null){
            System.out.println("user "+ownerName+" has no such vehicle "+regNo+" so cannot offer such ride");
            return null;
        }

        Vehicle vehicle = UserService.getVehicleByRegNo(regNo);
        if(vehicle == null)
        {
            System.out.println("No vehicle found with Reg No :" + regNo);
            return null;
        }
        DateFormat format = new SimpleDateFormat("d MMM, yyyy HH", Locale.ENGLISH);
        Date date = format.parse(startTime);

        Ride ride = new Ride(user,vehicle,availableSeats,origin,destination,date,duration);

        user.setRideOffered(user.getRideOffered()+1);
        rideRepository.getAllOffers().add(ride);
        return ride;
    }

    public static void totalRidesByUser() {
        UserService.getUserRepository().
                getAllUsers().stream().forEach(
                        user ->
                System.out.println(user.getName() +" " + user.getRidesTaken() + " : Taken "+ user.getRideOffered() + " : Offered"));
    }

    private static List<Ride> getAllAvailableRidesWithSourceAndDestinationForUser(User user, String origin, String destination){
        List<Ride> specificRides = new ArrayList<>();

        for(Ride ride :rideRepository.getAllOffers()){
            if(!user.getId().equals(ride.getRideGiver().getId()) && ride.getOrigin().equals(origin)
                    && ride.getDestination().equals(destination) && ride.getAvailableSeats()>0){

                specificRides.add(ride);
            }
        }

        return specificRides;
    }

    private static Ride selectRideService(User user, String origin, String destination, String type){
        List<Ride> specificRides = getAllAvailableRidesWithSourceAndDestinationForUser(user,origin,destination);

        if(specificRides.isEmpty())
            return null;

        switch (type) {
            case "Fastest_Ride" :
                Collections.sort(specificRides,new FastestRide());
                return specificRides.get(0);
            case "Earliest_Ride" :
                specificRides.sort(new EarliestRide());
                return specificRides.get(0);
            default:
                return null;
        }
    }

    public static Ride selectRide(String name, String origin, String destination, String type){
        User user = UserService.getUserByName(name);

        if(user == null){
            System.out.println("No such user is there "+ name);
            return null;
        }

        Ride ride = selectRideService(user,origin,destination,type);

        if(ride == null){
            System.out.println("No such ride is there with origin " + origin+ " Destination " +destination+" and type "+type);
            return null;
        }

        ride.setAvailableSeats(ride.getAvailableSeats()-1);
        user.setRidesTaken(user.getRidesTaken()+1);

        rideRepository.getAllRidesTaken().putIfAbsent(user, new ArrayList<>());
        rideRepository.getAllRidesTaken().get(user).add(ride);

        System.out.println("Ride given by "+ ride.getRideGiver().getName() + " With vehicle "
                + ride.getRideVehicle().getRegistrationNumber() + " to " + user.getName());

        return ride;
    }
}
