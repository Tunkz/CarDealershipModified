package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;

    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<Vehicle>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Dealership{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> listOfVehiclesByPrice = new ArrayList<Vehicle>();
        for (Vehicle v : this.inventory) {
            if (v.getPrice() >= min && v.getPrice() <= max) {
                listOfVehiclesByPrice.add(v);
            }

        }
        return listOfVehiclesByPrice;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> listVehiclesByMakeModel = new ArrayList<Vehicle>();
        for (Vehicle v : this.inventory){
            if (v.getMake().equalsIgnoreCase(make) || v.getModel().equalsIgnoreCase(model)){
                listVehiclesByMakeModel.add(v);
            }
        }
        return listVehiclesByMakeModel;
    }

    public List<Vehicle> getVehiclesByYear(int min, int max) {
        List<Vehicle> listOfVehiclesByYear = new ArrayList<Vehicle>();
        for (Vehicle v : this.inventory) {
            if (v.getYear() >= min && v.getYear() <= max) {
                listOfVehiclesByYear.add(v);
            }
        }
        return listOfVehiclesByYear;
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> listVehiclesByColor = new ArrayList<Vehicle>();
        for (Vehicle c : this.inventory) {
            if (c.getColor().equalsIgnoreCase(color)) {
                listVehiclesByColor.add(c);
            }
        }
        return listVehiclesByColor;
    }

    public List<Vehicle> getVehiclesByMileage(double min, double max) {
        List<Vehicle> listOfVehiclesByMileage = new ArrayList<Vehicle>();
        for (Vehicle v : this.inventory) {
            if (v.getOdometer() >= min && v.getOdometer() <= max) {
                listOfVehiclesByMileage.add(v);
            }
        }
        return listOfVehiclesByMileage;
    }

    public List<Vehicle> getVehiclesByType(String vehicleType) {
        List<Vehicle> listOfVehiclesByType = new ArrayList<Vehicle>();
        for (Vehicle v : this.inventory) {
            if (v.getVehicleType().equalsIgnoreCase(vehicleType)) {
                listOfVehiclesByType.add(v);
            }
        }
        return listOfVehiclesByType;
    }

    public List<Vehicle> getAllVehicles() {
        return this.inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        this.inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        this.inventory.remove(vehicle);
    }

}
