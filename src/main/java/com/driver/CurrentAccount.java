package com.driver;

import java.util.Arrays;

public class CurrentAccount extends BankAccount {
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name, balance, 5000);
        this.tradeLicenseId = tradeLicenseId;

        if (balance < 5000) {
            throw new Exception("Insufficient Balance");
        }
    }
    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        if (!isValidLicenseIdCheck()) {
            tradeLicenseId = rearrangeLicenseId(tradeLicenseId);
            if (!isValidLicenseIdCheck()) {
                throw new Exception("Valid License can not be generated");
            }
        }
//        System.out.println(tradeLicenseId);
    }
    private boolean isValidLicenseIdCheck() {
        for (int i = 0; i < tradeLicenseId.length()-1 ; i++) {
            if (tradeLicenseId.charAt(i) == tradeLicenseId.charAt(i+1)) {
                return false;
            }
        }
        return true;
    }
    private String rearrangeLicenseId(String str) {
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        tradeLicenseId = new String(ch);
        for (int i = 0; i < ch.length - 1; i++) {
            if (ch[i] == ch[i + 1]) {
                for (int j = i + 2; j < ch.length; j++) {
                    if (ch[j] != ch[i]) {
                        char temp = ch[i + 1];
                        ch[i + 1] = ch[j];
                        ch[j] = temp;
                        break;
                    }
                }
            }
        }
        return new String(ch);
    }
    public String getTradeLicenseId() {
        return tradeLicenseId;
    }
    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }
//    @Override
//    public String toString(){ //******
//        return super.toString()+ "\ntradeLicenseId: " + tradeLicenseId;
//    }
}

