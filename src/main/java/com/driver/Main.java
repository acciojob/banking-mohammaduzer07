package com.driver;

public class Main {
    public static void main(String[] args) {

        try{
            BankAccount bankAccount = new BankAccount("Aves", 4000, 2500);
            String AccountNo = bankAccount.generateAccountNumber(8, 69);
            CurrentAccount currentAccount = new CurrentAccount("Elon Musk(aka Mars)", 6000, "AABBCCDDE");
            currentAccount.validateLicenseId();
            SavingsAccount savingsAccount = new SavingsAccount("Bill gates", 2000, 1000, 10);

            savingsAccount.deposit(1000);
            savingsAccount.withdraw(500);
            double SI = savingsAccount.getSimpleInterest(2);
            double CI = savingsAccount.getCompoundInterest(4, 3);

            StudentAccount studentAccount = new StudentAccount("Uzer", 1500, "MIT University");
            studentAccount.deposit(500);

            System.out.println("Bank Account Info");
            System.out.println("Generated account no :" + AccountNo);
            System.out.println((bankAccount));
            System.out.println();
            System.out.println("Current Account Info");
            System.out.println(currentAccount);
            System.out.println();

            System.out.println("Saving Account Info");
            System.out.println(savingsAccount);
            System.out.println("Simple Interest: " + SI);
            System.out.println("Compound Interest: " + CI);
            System.out.println();

            System.out.println("Student Account Info");
            System.out.println(studentAccount);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}