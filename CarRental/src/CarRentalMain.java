import org.carrental.CarRentalApp;
import org.carrental.model.Location;
import org.carrental.model.User;
import org.carrental.model.VehicleReservation;
import org.carrental.service.Store;

public class CarRentalMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Car Rental Service !");

        CarRentalApp carRentalApp =  new CarRentalApp();

        User user1 =  new User("Ashok","22B Baker Street","ashok@gmail.com",587587,"abc");
        User user2 =  new User("Bijlani","2 Louden Street","Bijlani@gmail.com",637911,"huigi");
        carRentalApp.addUser(user1);
        carRentalApp.addUser(user2);

        Store storeA = carRentalApp.addStore(new Location("Kolkata-South"));
        Store storeB = carRentalApp.addStore(new Location("Kolkata-North"));
        Store storeC = carRentalApp.addStore(new Location("Kolkata-Newtown"));

        System.out.println(carRentalApp.findUserById(user1.getAccountId()));

        //VehicleReservation vehicleReservationByAshok = carRentalApp.reserveVehicle()
    }
}