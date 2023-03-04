package ddd;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class BankServer {
    public static void main(String[] args) throws Exception {
        IBankService bankService = new BankService();
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("BankService", bankService);
        System.out.println("Bank service is running...");
    }
}