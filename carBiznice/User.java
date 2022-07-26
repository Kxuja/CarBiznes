package carBiznice;

import java.util.ArrayList;

public class User {
    String name;
    String email;
    String password;
    int balance;
    String cardNumber;
    CardType cardType;
    String passport;
    ArrayList<MyCar> myCarArrayList = new ArrayList<>();

    public User() {
    }

    public User(String name, String email, String password, int balance, String cardNumber, CardType cardType, ArrayList<MyCar> myCarArrayList) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.myCarArrayList = myCarArrayList;
    }


}
