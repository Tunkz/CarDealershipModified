package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private Scanner Userinput = new Scanner(System.in);


    public UserInterface() {
    }

    public void display() {
        Scanner scanner = new Scanner(System.in);
        init();

        boolean running = true;
        while (running) {
            System.out.println("Welcome to the main menu. \nPlease select an option: ");
            System.out.println("1) Find vehicles within a price range");
            System.out.println("2) Find vehicles by make / model");
            System.out.println("3) Find vehicles by year range");
            System.out.println("4) Find vehicles by color");
            System.out.println("5) Find vehicles by mileage range");
            System.out.println("6) Find vehicles by type(car,truck,SUV,van");
            System.out.println("7) List ALL vehicles");
            System.out.println("8) Add a vehicle");
            System.out.println("9) Remove a vehicle");
            System.out.println("99) Quit");

            String input = scanner.nextLine().trim();
            switch (input) {
                case "1":
                    processGetByPriceRequest();
                    break;
                case "2":
                    processGetByMakeModelRequest();
                    break;
                case "3":
                    processGetByYearRequest();
                    break;
                case "4":
                    processGetByColorRequest();
                    break;
                case "5":
                    processGetByMileageRequest();
                    break;
                case "6":
                    processGetByVehicleTypeRequest();
                    break;
                case "7":
                    processGetAllVehicleRequest();
                    break;
                case "8":
                    processAddVehicleRequest();
                    break;
                case "9":
                    processRemoveVehicleRequest();
                    break;
                case "10":
                    processSaleOrLeaseVehicle();
                    break;
                case "99":
                    System.out.println();
                    running = false;
                default:
                    System.out.println("Invalid option. Please select the right option.");
                    break;
            }
        }
    }

    private void helperDisplayVehicles(List<Vehicle> listOfVehicles) {
        for (Vehicle vehicle : listOfVehicles) {
            System.out.println(vehicle);
        }
    }

    private void init() {
        DealerShipFileManager shipFileManager = new DealerShipFileManager();
        dealership = shipFileManager.getDealership();
    }

    public void processGetByPriceRequest() {
        System.out.println("Please type in the minimum price: ");
        double minimumPrice = Userinput.nextDouble();
        Userinput.nextLine();
        System.out.println("PLease type the maximum price: ");
        double maximumPrice = Userinput.nextDouble();
        Userinput.nextLine();
        helperDisplayVehicles(dealership.getVehiclesByPrice(minimumPrice, maximumPrice));
    }

    public void processGetByMakeModelRequest() {
        System.out.println("Please enter the vehicle by make: ");
        String vehicleByMake = Userinput.nextLine();
        System.out.println("Please enter vehicle by model: ");
        String vehicleByModel = Userinput.nextLine();
        helperDisplayVehicles(dealership.getVehiclesByMakeModel(vehicleByMake, vehicleByModel));
    }

    public void processGetByYearRequest() {
        System.out.println("Please enter the minimum year model of car you're looking for: ");
        int minCarYear = Userinput.nextInt();
        Userinput.nextLine();
        System.out.println("Please enter the maximum year model of car you're looking for: ");
        int maxCarYear = Userinput.nextInt();
        Userinput.nextLine();
        helperDisplayVehicles(dealership.getVehiclesByYear(minCarYear, maxCarYear));

    }

    public void processGetByColorRequest() {
        System.out.println("Please select the color of the car you want: ");
        String carColor = Userinput.nextLine();
        helperDisplayVehicles(dealership.getVehiclesByColor(carColor));

    }

    public void processGetByMileageRequest() {
        System.out.println("Please select the minimum mileage you want for your car: ");
        double minCarMileage = Userinput.nextDouble();
        Userinput.next();
        System.out.println("Please select the maximum mileage you want for your car: ");
        double maxCarMileage = Userinput.nextDouble();
        Userinput.next();
        helperDisplayVehicles(dealership.getVehiclesByMileage(minCarMileage, maxCarMileage));

    }

    public void processGetByVehicleTypeRequest() {
        System.out.println("Please enter the type of vehicle you're looking for: ");
        String vehicleType = Userinput.nextLine();
        helperDisplayVehicles(dealership.getVehiclesByType(vehicleType));

    }

    public void processGetAllVehicleRequest() {
        helperDisplayVehicles(dealership.getAllVehicles());
    }

    public void processAddVehicleRequest() {

        System.out.println("Please fill in the information needed to add a vehicle: " +
                "\n Please type in the vin number");
        int vin = Userinput.nextInt();
        Userinput.nextLine();

        System.out.println("please add the year: ");
        int year = Userinput.nextInt();
        Userinput.nextLine();

        System.out.println("Please enter the make: ");
        String carMake = Userinput.nextLine();

        System.out.println("Please enter the model: ");
        String carModel = Userinput.nextLine();

        System.out.println("Please enter the type: ");
        String carType = Userinput.nextLine();

        System.out.println("Please enter the color: ");
        String carColor = Userinput.nextLine();

        System.out.println("Please enter the mileage: ");
        int odometer = Userinput.nextInt();
        Userinput.nextLine();

        System.out.println("Please enter the price: ");
        double carPrice = Userinput.nextDouble();
        Userinput.nextLine();


        Vehicle vehicle = new Vehicle(vin, year, carMake, carModel, carType, carColor, odometer, carPrice);
        dealership.addVehicle(vehicle);
    }

    public void processRemoveVehicleRequest() {
        System.out.println("Please enter the vin number: ");
        int vinNo = Userinput.nextInt();
        Userinput.nextLine();
        for (Vehicle v : dealership.getAllVehicles()) {
            if (v.getVin() == vinNo) {
                dealership.removeVehicle(v);
            }
        }

    }

    public void processSaleOrLeaseVehicle() {
        List<Vehicle> dealershipVehicles = dealership.getAllVehicles();
        System.out.println("Please enter the date: ");
        String date = Userinput.nextLine();

        System.out.println("Please enter your name: ");
        String customerName = Userinput.nextLine();

        System.out.println("Please enter your email: ");
        String customerEmail = Userinput.nextLine();

        System.out.println("Please enter the vehicle ID type: ");
        int vehicleVin = Userinput.nextInt();
        Userinput.nextLine();
        Vehicle ve = null;
        for (Vehicle v : dealershipVehicles) {
            if (vehicleVin == v.getVin()) {
                ve = v;
            }
        }
        System.out.println("Would you like to lease/buy the Vehicle? ");
        String userInput = Userinput.nextLine();
        Contract contract = null;
        if (userInput.equalsIgnoreCase("lease")) {
            contract = new LeaseContract(date, customerName, customerEmail, ve);
        } else if (userInput.equalsIgnoreCase("buy")) {
            System.out.println("Would you like to finance the vehicle? ");
            boolean financing = Userinput.nextBoolean();
            contract = new SalesContract(date, customerName, customerEmail, ve, financing);
        }

        ContractFileManager contractFileManager = new ContractFileManager();
        contractFileManager.saveContract(contract);
        dealership.removeVehicle(ve);

        DealerShipFileManager dealerShipFileManager = new DealerShipFileManager();
        dealerShipFileManager.saveDealership(dealership);
    }


}
