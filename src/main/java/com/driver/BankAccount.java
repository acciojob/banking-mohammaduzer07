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
        if (digits * 9 < sum) {
            throw new Exception("Account Number cannot be generated");
        }
        int[] accountNumber = new int[digits];
        int currSum = 0;
        for (int i = 0; i < digits; i++) {
            int digit = Math.min(9, sum);
            accountNumber[i] = digit;
            sum -= digit;
        }
        StringBuilder accountNumberStr = new StringBuilder();
        for (int digit : accountNumber) {
            accountNumberStr.append(digit);
        }
        return accountNumberStr.toString();
//        if (digits * 9 < sum) {
//            throw new Exception("Account Number cannot be generated");
//        }
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
//        return null;
    }
    public void deposit(double amount) {
        //add amount to balance
        balance += amount;
    }
    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if(balance - amount < minBalance){
            throw new Exception("Insufficient Balance");
        }
        balance -= amount;
//        if(amount > this.balance) { //*****
//            throw new Exception("Amount exceeds available balance");
//        } else if(this.balance - amount < this.minBalance) {
//            throw new Exception("Insufficient Balance");
//        }
//        this.balance -= amount;
    }
    @Override
    public String toString() { // ****
        return "Bank Account Information:\nName: " + name + "\nBalance: " + balance + "\nMinimum Balance: " + minBalance;
    }
}
