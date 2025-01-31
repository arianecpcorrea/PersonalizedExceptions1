package application;


import entities.Account;
import exceptions.BusinessException;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        //Account acc = new Account();

        System.out.println("Inform the account datas: ");
        System.out.print("Number: ");
        int number = sc.nextInt();
        System.out.print("Holder: ");
        sc.nextLine(); // para consumir o nextint que ficou no buffer de entrada depois do enter
        String holder = sc.nextLine();
        System.out.print("Initial Balance: ");
        double balance = sc.nextDouble();
        System.out.print("Withdrawal limit: ");
        double withdrawLimit = sc.nextDouble();

        Account acc = new Account(number, holder, balance, withdrawLimit);

        System.out.println();
        System.out.print("Inform the withdrawal amount: ");
        double amount = sc.nextDouble();

        //código linear, se estourar uma exceção, vc pega ela no catch
        try {
            acc.withdraw(amount);
            System.out.printf("New balance: %.2f%n", acc.getBalance());// ou
            System.out.println("New balance: " + String.format("%.2f", acc.getBalance()));   
        }
        catch (BusinessException e) { //precisa importar
            System.out.println(e.getMessage());            
        }
           
        sc.close();
    }
}
