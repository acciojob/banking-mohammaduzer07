package com.driver;

public class Main {
    public static void main(String[] args) {

        try{
            CurrentAccount currentAccount = new CurrentAccount("Elon Musk(aka Mars)", 6000, "LICENCE123");
            SavingsAccount savingsAccount = new SavingsAccount("Bill gates", 2000, 1000, 5);
            savingsAccount.deposit(1000);
            savingsAccount.withdraw(500);
            double SI = savingsAccount.getSimpleInterest(2);
            double CI = savingsAccount.getCompoundInterest(4, 3);
            StudentAccount studentAccount = new StudentAccount("Uzer", 1500, "MIT University");
            studentAccount.deposit(500);

            System.out.println("Current Account Info");
            System.out.println(currentAccount);
            System.out.println();

            System.out.println("Saving Account Info");
            System.out.println(savingsAccount);
            System.out.println();

            System.out.println("Student Account Info");
            System.out.println(studentAccount);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}