package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractFileManager {
    public void saveContract(Contract contract) {
        try {
            BufferedWriter bf = new BufferedWriter(new FileWriter("Contracts.csv", true));
            if (contract instanceof SalesContract) {
                String finance = ((SalesContract) contract).isFinance() ? "yes" : "no";
                bf.write("Sale" + "|" + contract.getDate() + "|" + contract.getCustomerName() + "|" + contract.getCustomerEmail()
                        + "|" + contract.getVehicle().getVin() + "|" + contract.getVehicle().getYear() + "|" + contract.getVehicle().getMake() + "|" + contract.getVehicle().getModel() + "|" +
                        contract.getVehicle().getVehicleType() + "|" + contract.getVehicle().getColor() + "|" + contract.getVehicle().getOdometer() + "|" + contract.getVehicle().getPrice() + "|" + ((SalesContract) contract).getSalesTaxAmount() + "|" +
                        ((SalesContract) contract).getRecordingFee() + "|" + ((SalesContract) contract).getTotalPrice() + "|" + finance + "|" + ((SalesContract) contract).getMonthlyPayment());
                bf.newLine();
            } else if (contract instanceof LeaseContract) {
                bf.write("Lease" + "|" + contract.getDate() + "|" + contract.getCustomerName() + "|" + contract.getCustomerEmail()
                        + "|" + contract.getVehicle().getVin() + "|" + contract.getVehicle().getYear() + "|" + contract.getVehicle().getMake() + "|" + contract.getVehicle().getModel() + "|" + contract.getVehicle().getVehicleType() + "|" +
                        contract.getVehicle().getColor() + "|" + contract.getVehicle().getOdometer() + "|" + contract.getVehicle().getPrice() + "|" + ((LeaseContract) contract).getExpectedEndingValue() + "|" +
                        ((LeaseContract) contract).getLeaseFee() + "|" + ((LeaseContract) contract).getTotalPrice() + "|" + ((LeaseContract) contract).getMonthlyPayment());
                bf.newLine();
            }
            bf.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
