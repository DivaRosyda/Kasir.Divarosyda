import java.io.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Customer {
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private int totalTransaction;

    public Customer(String name, String email, String phoneNumber, String address, int totalTransaction) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.totalTransaction = totalTransaction;
    }

    public static Customer loadFromFile(String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();;
            Customer customer = gson.fromJson(fileReader, Customer.class);
            fileReader.close();
            return customer;
        } catch (IOException e) {
            return null;
        }
    }

    public void saveToFile() {
        String fileName = name + ".json";
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(this, fileWriter);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public int getTotalTransaction() {
        return totalTransaction;
    }

    public void increaseTransactionCount() {
        totalTransaction++;
    }
}
