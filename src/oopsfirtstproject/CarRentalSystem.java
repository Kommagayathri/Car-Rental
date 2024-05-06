package oopsfirtstproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalSystem {
    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;

    public CarRentalSystem() {
        cars=new ArrayList<>();
        customers=new ArrayList<>();
        rentals=new ArrayList<>();
    }
    public void addCar(Car car){
        cars.add(car);
    }
    public void addCustomer( Customer customer){
        customers.add(customer);
    }
    public void rentCar(Car car, Customer customer,int days){
        if(car.isAvailabe()){
            car.rent();
            rentals.add(new Rental(car,customer,days));
        }
        else{
            System.out.println("car is not available fpr rent");
        }
    }
    public void returnCar( Car car){
        car.returnCar();
        Rental rentalToRemove =null;
        for(Rental rentals:rentals)
        {

            if(rentals.getCar()==car){
                rentalToRemove=rentals;
                break;
            }
        }
        if(rentalToRemove!=null){
            rentals.remove(rentalToRemove);
        }
        else{
            System.out.println("Car was not rented");
        }
    }
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("===== Car Rentqal System =====");
            System.out.println("1. Rent a Car");
            System.out.println("2. Return a Car");
            System.out.println("3. Exit");
            System.out.println("ENTER YOUR CHOICE: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            String customerName = null;
            if (choice == 1) {
                System.out.println("\n == Rent a Car");
                System.out.println("Enter your name:");
                customerName = scanner.nextLine();
                System.out.println("\n Available Cars:");
                for (Car car : cars) {
                    if (car.isAvailabe()) {
                        System.out.println(car.getCarId() + " - " + car.getBrand() + " - " + car.getModel());
                    }
                }

                System.out.println("\n Enter the car ID you want to rent:");
                String carID = scanner.nextLine();
                System.out.println("Enter the no.of days for rental: ");
                int rentalDays = scanner.nextInt();
                scanner.nextLine();


                Customer newCustomer = new Customer("CUS" + (customers.size() + 1), customerName);
                addCustomer(newCustomer);

                Car selectedCar = null;
                for (Car car : cars) {
                    if (car.getCarId().equals(carID) && car.isAvailabe()) {
                        selectedCar = car;
                        break;

                    }

                }
                if (selectedCar != null) {
                    double totalprice = selectedCar.calculatePrice(rentalDays);
                    System.out.println("\n == Rental Informationb ==\n");
                    System.out.println("Customer Id:" + newCustomer.getCustomerId());
                    System.out.println("Customer Name:" + newCustomer.getName());
                    System.out.println("Car:" + selectedCar.getBrand() + " " + selectedCar.getModel());
                    System.out.println("Rental Dayas:" + rentalDays);
                    System.out.println("Total Price: " + totalprice);

                    System.out.println("\n Confirm rental (Y/N)");
                    String confirm = scanner.nextLine();

                    if (confirm.equalsIgnoreCase(("Y"))) {
                        rentCar(selectedCar, newCustomer, rentalDays);
                        System.out.println("\n Car rented successfully");

                    } else {
                        System.out.println("\n Rental Canceled");
                    }


                } else {
                    System.out.println("\n Invalid car selection or car not available for rent");
                }


            }
            else if(choice==2){
                System.out.println("\n == Return a Car ==\n");
                System.out.println("Enter the car ID you want to return:");
                String carId= scanner.nextLine();
                 Car carToReturn= null;
                 for(Car car : cars){

                     if(car.getCarId().equals(carId)&& !car.isAvailabe()){
                         carToReturn=car;
                         break;
                     }
                 }
                 if(carToReturn!=null){
                     Customer customer =null;
                     for(Rental rental: rentals){
                         if(rental.getCar()==carToReturn){
                             customer=rental.getCustomer();
                             break;
                         }

                     }
                     if(customer!=null){
                         returnCar(carToReturn);
                         System.out.println("car returned successfully by"+ customer.getName());
                     }
                     else {
                         System.out.println("Invalid car Id or car is not rented");
                     }

                 }else if(choice==3){
                     break;
                 }
                 else{
                     System.out.println("Invalid choice. please enter a valid option");
                 }
                 }



            }
            System.out.println("\n THANK YOU for using the Car Rental System!");



        }

    }



