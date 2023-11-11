package com.pluralsight;

public class Program {
    public static void main(String[] args) {
//        UserInterface userInterface = new UserInterface();
//        userInterface.display();

        Contract contract = new LeaseContract("01/10/2000","Buba","buba123",
                new Vehicle(123,123,"bnla","bla","bla","vla",123,12.0));
        System.out.println(contract.getTotalPrice());
    }
}
