package ddd;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IBankService extends Remote {
    public void createAccount(String name, double balance) throws RemoteException;
    public double getBalance(int accountNumber) throws RemoteException;
    public void deposit(int accountNumber, double amount) throws RemoteException;
    public void withdraw(int accountNumber, double amount) throws RemoteException;
}