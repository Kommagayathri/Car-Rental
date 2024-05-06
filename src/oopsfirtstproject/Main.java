package oopsfirtstproject;

public class Main {
    public static void main(String[] args) {
        CarRentalSystem rentalSystem = new CarRentalSystem();
        Car car1= new Car("C001","bmw","X1",500);
        Car car2 = new Car("B201","Honda","Accord",150);
        Car car3= new Car("Z008","Mahindra","Thar",100);

        rentalSystem.addCar(car1);
        rentalSystem.addCar(car2);
        rentalSystem.addCar(car3);

        rentalSystem.menu();


    }
}
