package ddd;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class BankService extends UnicastRemoteObject implements IBankService {
    private Map<Integer, Double> accounts;

    public BankService() throws RemoteException {
        accounts = new HashMap<>();
    }

    public void createAccount(String name, double balance) throws RemoteException {
        int accountNumber = accounts.size() + 1;
        accounts.put(accountNumber, balance);
        System.out.println("Account created: " + accountNumber + ", Name: " + name + ", Balance: " + balance);
    }

    public double getBalance(int accountNumber) throws RemoteException {
        Double balance = accounts.get(accountNumber);
        if (balance == null) {
            throw new RemoteException("Invalid account number: " + accountNumber);
        }
        return balance;
    }

    public void deposit(int accountNumber, double amount) throws RemoteException {
        Double balance = accounts.get(accountNumber);
        if (balance == null) {
            throw new RemoteException("Invalid account number: " + accountNumber);
        }
        accounts.put(accountNumber, balance + amount);
        System.out.println(amount + " deposited to account " + accountNumber + ", new balance: " + accounts.get(accountNumber));
    }

    public void withdraw(int accountNumber, double amount) throws RemoteException {
        Double balance = accounts.get(accountNumber);
        if (balance == null) {
            throw new RemoteException("Invalid account number: " + accountNumber);
        }
        if (balance < amount) {
            throw new RemoteException("Insufficient balance in account " + accountNumber + ", current balance: " + balance);
        }
        accounts.put(accountNumber, balance - amount);
        System.out.println(amount + " withdrawn from account " + accountNumber + ", new balance: " + accounts.get(accountNumber));
    }
}