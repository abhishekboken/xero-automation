package com.xero.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DataProvider {

    public static Properties property;
    public static String dataFilePath = "src/test/resources/dataFile.properties";
    private String accountName;
    private String accountNumber;


    public static void initializePropertiesFile(){
        property = new Properties();
        try {
            InputStream stream = new FileInputStream(dataFilePath);
            property.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String bankAccountName) {
        this.accountName = bankAccountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String bankAccountNumber) {
        this.accountNumber = bankAccountNumber;
    }
}
