package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setBalance(double balance) {//*****
        this.balance = balance;
    }
    public double getBalance() { //***
        return balance;
    }
    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }
    public double getMinBalance() {
        return minBalance;
    }
    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;

    }
    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
//        int[] accountNumber = new int[digits];
//        int currSum = 0;
//        for(int i=0; i<digits; i++){
//            int randomDig = (int) (Math.random() * 10);
//            accountNumber[i] = randomDig;
//            currSum += randomDig;
//        }
//        if(currSum != sum){
//            throw new Exception("Account Number can not be generated");
//        }
//        StringBuilder accountNumberStr = new StringBuilder();
//        for (int digit : accountNumber) {
//            accountNumberStr.append(digit);
//        }
//        return accountNumberStr.toString();
        try {
            int accountNo = digits;
            int sumOfDigit = 0;
            while(accountNo > 0) {
                int digit = accountNo%10;
                sumOfDigit += digit;
                accountNo /= 10;
            }
            if(sumOfDigit == sum) {
                return Integer.toString(digits);
            } else {
                throw new Exception("Account Number can not be generated");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public void deposit(double amount) {
        //add amount to balance
        balance += amount;
    }
    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
//        if(balance - amount < minBalance){
//            throw new Exception("Insufficient Balance");
//        }
//        balance -= amount;
        try{
            if(amount < this.balance) {
                if(this.balance - amount >= this.minBalance) {
                    this.balance -= amount;
                } else {
                    throw new Exception("Insufficient Balance");
                }
            } else {
                throw new Exception("Amount exceeds available balance");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public String toString() { // ****
        return "Bank Account Information:\nName: " + name + "\nBalance: " + balance + "\nMinimum Balance: " + minBalance;
    }
}
