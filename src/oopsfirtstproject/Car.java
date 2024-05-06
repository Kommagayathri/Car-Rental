package oopsfirtstproject;

public class Car {
    private String carId;
    private String brand;
    private String model;
    private double basepriceperday;
    private boolean isAvailabe;


    public Car(String carId,String brand,String model,double basepriceperday){
        this.carId=carId;
        this.brand =brand;
        this.model=model;
        this.basepriceperday=basepriceperday;
        this.isAvailabe=true;
    }

    public String getCarId() {
        return carId;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }


    public double calculatePrice(int rentalDays){
        return basepriceperday*rentalDays;
    }

    public boolean isAvailabe() {
        return isAvailabe;
    }
    public void rent(){
        isAvailabe =false;

    }
    public void returnCar(){
        isAvailabe=true;
    }


}
