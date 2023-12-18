package com.driver;

import java.util.Arrays;

public class CurrentAccount extends BankAccount {
    String tradeLicenseId; //consists of Uppercase English characters only

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }
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
            rearrangeLicenseId();
            if (!isValidLicenseIdCheck()) {
                throw new Exception("Valid License can not be generated");
            }
        }
    }
    private boolean isValidLicenseIdCheck() {
        for (int i = 1; i < tradeLicenseId.length() ; i++) {
            if (tradeLicenseId.charAt(i) == tradeLicenseId.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }
    private void rearrangeLicenseId() {
        char[] licenseIdChars = tradeLicenseId.toCharArray();
        Arrays.sort(licenseIdChars);
        for (int i = 0; i < licenseIdChars.length - 1; i++) {
            if (licenseIdChars[i] == licenseIdChars[i + 1]) {
                for (int j = i + 2; j < licenseIdChars.length; j++) {
                    if (licenseIdChars[j] != licenseIdChars[i]) {
                        char temp = licenseIdChars[i + 1];
                        licenseIdChars[i + 1] = licenseIdChars[j];
                        licenseIdChars[j] = temp;
                        break;
                    }
                }
            }
        }
        tradeLicenseId = new String(licenseIdChars);
    }
    @Override
    public String toString(){ //******
        return super.toString()+ "\ntradeLicenseId: " + tradeLicenseId;
    }
}

