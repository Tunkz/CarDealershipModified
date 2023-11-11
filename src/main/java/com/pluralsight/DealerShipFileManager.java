package com.pluralsight;

import java.io.*;

public class DealerShipFileManager {
    public Dealership getDealership() {
        Dealership dealership1 = new Dealership("", "", "");
        String line;

        int lineNumber = 1;

        try {
            BufferedReader br = new BufferedReader(new FileReader("inventory.csv"));

            while ((line = br.readLine()) != null) {
                String[] pipes = line.split("\\|");

                if (lineNumber == 1) {
                    String name = pipes[0];
                    dealership1.setName(name);
                    String address = pipes[1];
                    dealership1.setAddress(address);
                    String phoneNumber = pipes[2];
                    dealership1.setPhone(phoneNumber);
                } else {
                    int vin = Integer.parseInt(pipes[0]);
                    int year = Integer.parseInt(pipes[1]);
                    String make = pipes[2];
                    String model = pipes[3];
                    String vehicleType = pipes[4];
                    String color = pipes[5];
                    int odometer = Integer.parseInt(pipes[6]);
                    double price = Double.parseDouble(pipes[7]);
                    Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                    dealership1.addVehicle(vehicle);

                }

                lineNumber++;


            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println("Error: unidentified error. Please try again");
        }

        return dealership1;
    }

    public void saveDealership(Dealership dealership) {
        String dealershipName = String.format("%1s|%1s|%1s", dealership.getName(), dealership.getAddress(), dealership.getPhone());
        try {
            BufferedWriter nameWriter = new BufferedWriter(new FileWriter("inventory.csv"));
            nameWriter.write(dealershipName + "\n");
            nameWriter.close();
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("inventory.csv", true));
                for (Vehicle x : dealership.getAllVehicles()) {
                    String vehicleFormat = x.getVin() + "|" + x.getYear() + "|" + x.getMake() + "|" + x.getModel() +
                            "|" + x.getVehicleType() + "|" + x.getColor() + "|" + x.getOdometer() + "|"
                            + x.getPrice() + "\n";
                    writer.write(vehicleFormat);
                }
                writer.close();
            } catch (IOException e) {
                System.out.println(e);
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}