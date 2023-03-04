package ddd;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;


public class BankClient {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("localhost");
        IBankService bankservice = (IBankService) registry.lookup("BankService");

        bankservice.createAccount("Alice", 9000.0);
        bankservice.createAccount("Bob", 500.0);
        System.out.println("withdraw from Alice:");
        Scanner  alice = new Scanner(System.in);
        float al = alice.nextFloat();
        bankservice.withdraw(1, al);
        System.out.println("deposit in Bob:");
        bankservice.deposit(2, al);
        double aliceBalance = bankservice.getBalance(1);
        System.out.println("Alice's balance: " + aliceBalance);
        double bobBalance = bankservice.getBalance(2);
        System.out.println("Bob's balance: "+bobBalance);



        System.out.println("deposit in alice:");
        alice =new Scanner(System.in);
        al = alice.nextFloat();
        bankservice.deposit(1, al);
        aliceBalance = bankservice.getBalance(1);
        System.out.println("Alice's balance: " + aliceBalance);


        System.out.println("deposit in bob:");
        Scanner  bob1 =new Scanner(System.in);
        float bob01=bob1.nextFloat();
        bankservice.deposit(2, bob01);
         bobBalance = bankservice.getBalance(2);
        System.out.println("bob's balance: " + bobBalance);

    }}