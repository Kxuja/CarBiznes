package carBiznice;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ByCarService implements CarMarketInterface {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Car> carList = new ArrayList<>();
    ArrayList<User> userList = new ArrayList<User>();
    ArrayList<Admin> adminList = new ArrayList<>();

    int userIndex = -1;
    int adminIndex = -1;

    @Override
    public void sign() {
        System.out.println("email :");
        String email = scanner.next();
        System.out.println("password :");
        String password = scanner.next();
        System.out.println("User type :");
        System.out.println("1]" + UserType.User);
        System.out.println("2]" + UserType.Admin);
        System.out.println("Choose :");
        int choose = scanner.nextInt();
        switch (choose) {
            case 1 -> {
                boolean isHave = false;
                for (int i = 0; i < userList.size(); i++) {
                    if (userList.get(i).email.equals(email) && userList.get(i).password.equals(password)) {
                        userIndex = i;
                        isHave = true;
                        break;
                    }
                }
                if (isHave) {
                    while (true) {
                        System.out.println("1] My profile !");
                        System.out.println("2] Edit profile !");
                        System.out.println("3] add Balance !");
                        System.out.println("4] buy Car !");
                        System.out.println("5] My buy Cars !");
                        System.out.println("6] My balance !");
                        System.out.println("7] search Car !");
                        System.out.println("0] Log Out !");
                        int s = scanner.nextInt();
                        if (s == 1) {
                            myProfile();
                        } else if (s == 2) {
                            editProfile();
                        } else if (s == 3) {
                            addBalance();
                        } else if (s == 4) {
                            byCar();
                        } else if (s == 5) {
                            myCars();
                        } else if (s == 6) {
                            myBalance();
                        } else if (s == 7) {
                            searchCar();
                        } else if (s == 0) {
                            break;
                        }
                    }

                } else {
                    System.out.println("email or password  is invalid !");
                }
            }
            case 2 -> {
                boolean isHave = false;
                for (int i = 0; i < adminList.size(); i++) {
                    if (Objects.equals(adminList.get(i).email, email) && Objects.equals(adminList.get(i).password, password)) {
                        adminIndex = i;
                        isHave = true;
                    }
                }

                if (isHave) {
                    while (true) {
                        System.out.println("1] My profile !");
                        System.out.println("2] Edit profile !");
                        System.out.println("3] Add Car !");
                        System.out.println("4] Edit Car !");
                        System.out.println("5] Delete Car !");
                        System.out.println("6] Car List !");
                        System.out.println("0] Log Out !");
                        System.out.println("Choose :");
                        int num = scanner.nextInt();
                        if (1 == num) {
                            System.out.println("================Your profile =========================");
                            System.out.println("Your name : " + adminList.get(adminIndex).name);
                            System.out.println("Your password : " + adminList.get(adminIndex).password);
                            System.out.println("Your email : " + adminList.get(adminIndex).email);
                            System.out.println("==========================================================");

                        } else if (2 == num) {
                            System.out.println("new name :");
                            String newName = scanner.next();
                            System.out.println("new Email :");
                            String newEmail = scanner.next();
                            System.out.println("new Password :");
                            String newPassword = scanner.next();
                            adminList.get(adminIndex).email = newEmail;
                            adminList.get(adminIndex).password = newPassword;
                            adminList.get(adminIndex).name = newName;
                            System.out.println("Success !");
                        } else if (3 == num) {
                            addCar();
                        } else if (num == 4) {
                            editCar();
                        } else if (num == 5) {
                            deleteCar();
                        } else if (num == 6) {
                            if (carList.size() == 0) {
                                System.out.println("IS empty Car list ! :(");
                            } else {
                                for (int i = 0; i < carList.size(); i++) {
                                    System.out.println("==============" + (i + 1) + "====================");
                                    System.out.println("Car name :" + carList.get(i).name);
                                    System.out.println("Car price :" + carList.get(i).price);
                                    System.out.println("Car type :" + carList.get(i).carType);
                                    System.out.println("Car color type :" + carList.get(i).colorType);
                                    System.out.println("Car year  :" + carList.get(i).age);
                                    System.out.println("==========================================");
                                }
                            }
                        } else if (num == 0) {
                            break;
                        }

                    }
                }

            }
            default -> System.out.println("Invalid choose number !");
        }
    }

    @Override
    public void signUp() {
        User user = new User();
        Admin admin = new Admin();
        System.out.println("name :");
        String name = scanner.next();
        System.out.println("password :");
        String password = scanner.next();
        System.out.println("email :");
        String email = scanner.next();
        System.out.println("User Type :");
        System.out.println("1]" + UserType.User);
        System.out.println("2]" + UserType.Admin);
        System.out.println("Choose :");
        int choose = scanner.nextInt();
        switch (choose) {
            case 1 -> {
                System.out.println("Passport password");
                int pass=scanner.nextInt();
                System.out.println("Card number :");
                String cardNumber = scanner.next();
                System.out.println("CardType :");
                System.out.println("1]" + CardType.UzCard);
                System.out.println("2]" + CardType.MasterCard);
                System.out.println("3]" + CardType.Visa);
                System.out.println("4]" + CardType.Humo);
                System.out.println("Choose :");
                int cardChoose = scanner.nextInt();
                switch (cardChoose) {
                    case 1 -> {
                        System.out.println("Card balance :");
                        int balance = scanner.nextInt();
                        user.balance = balance;
                        user.cardNumber = cardNumber;
                        user.email = email;
                        user.password = password;
                        user.name = name;
                        user.cardType = CardType.UzCard;
                        userList.add(user);
                        System.out.println("Success !");

                    }
                    case 2 -> {
                        System.out.println("Card balance :");
                        int balance = scanner.nextInt();
                        user.balance = balance;
                        user.cardNumber = cardNumber;
                        user.email = email;
                        user.password = password;
                        user.name = name;
                        user.cardType = CardType.MasterCard;
                        userList.add(user);
                        System.out.println("Success !");

                    }
                    case 3 -> {
                        System.out.println("Card balance :");
                        int balance = scanner.nextInt();
                        user.balance = balance;
                        user.cardNumber = cardNumber;
                        user.email = email;
                        user.password = password;
                        user.name = name;
                        user.cardType = CardType.Visa;

                        userList.add(user);
                        System.out.println("Success !");

                    }
                    case 4 -> {
                        System.out.println("Card balance :");
                        int balance = scanner.nextInt();
                        user.balance = balance;
                        user.cardNumber = cardNumber;
                        user.email = email;
                        user.password = password;
                        user.name = name;
                        user.cardType = CardType.Humo;

                        userList.add(user);
                        System.out.println("Success !");

                    }
                    default -> System.out.println("Invalid choose number !");
                }
            }
            case 2 -> {
                admin.email = email;
                admin.name = name;
                admin.password = password;
                adminList.add(admin);
                System.out.println("Success !");

            }
        }
    }

    @Override
    public void addBalance() {
        System.out.println("Summa :");
        int sum = scanner.nextInt();
        userList.get(userIndex).balance += sum;
        System.out.println("Success !");
    }

    @Override
    public void myBalance() {
        System.out.println("==============================================");
        System.out.println("Your balance " + userList.get(userIndex).balance);
        System.out.println("==============================================");
    }

    @Override
    public void editCar() {

        if (carList.isEmpty()) {
            System.out.println(" mashina qo`shilmagan  !");
        } else {
            for (int i = 0; i < carList.size(); i++) {
                System.out.println("==============" + (i + 1) + "====================");
                System.out.println("Car name :" + carList.get(i).name);
                System.out.println("Car price :" + carList.get(i).price);
                System.out.println("Car type :" + carList.get(i).carType);
                System.out.println("Car color type :" + carList.get(i).colorType);
                System.out.println("Car year  :" + carList.get(i).age);
                System.out.println("==========================================");
            }
            System.out.println("Choose :");
            int byCarIndex = scanner.nextInt();
            if (3 + userList.size() > byCarIndex) {
                System.out.println("Car name :");
                String carName = scanner.next();
                System.out.println("Car price :");
                int carPrice = scanner.nextInt();
                System.out.println("Car age :");
                String age = scanner.next();
                System.out.println("Car Type :");
                System.out.println("1]" + CarType.Sedan);
                System.out.println("2]" + CarType.Track);
                System.out.println("3]" + CarType.Moto);
                int chooseType = scanner.nextInt();
                switch (chooseType) {
                    case 1 -> {
                        System.out.println("Car color type :");
                        System.out.println("1]" + CarColorType.Black);
                        System.out.println("2]" + CarColorType.White);
                        System.out.println("3]" + CarColorType.Yellow);
                        System.out.println("4]" + CarColorType.Red);
                        int colorType = scanner.nextInt();
                        if (colorType == 1) {
                            carList.get(byCarIndex - 1).age = age;
                            carList.get(byCarIndex - 1).colorType = CarColorType.Black;
                            carList.get(byCarIndex - 1).price = carPrice;
                            carList.get(byCarIndex - 1).name = carName;
                            carList.get(byCarIndex - 1).carType = CarType.Sedan;
                            System.out.println("Success !");
                        } else if (colorType == 2) {
                            carList.get(byCarIndex - 1).age = age;
                            carList.get(byCarIndex - 1).colorType = CarColorType.White;
                            carList.get(byCarIndex - 1).price = carPrice;
                            carList.get(byCarIndex - 1).name = carName;
                            carList.get(byCarIndex - 1).carType = CarType.Sedan;
                            System.out.println("Success !");
                        } else if (colorType == 3) {
                            carList.get(byCarIndex - 1).age = age;
                            carList.get(byCarIndex - 1).colorType = CarColorType.Yellow;
                            carList.get(byCarIndex - 1).price = carPrice;
                            carList.get(byCarIndex - 1).name = carName;
                            carList.get(byCarIndex - 1).carType = CarType.Sedan;
                            System.out.println("Success !");
                        } else if (colorType == 4) {
                            carList.get(byCarIndex - 1).age = age;
                            carList.get(byCarIndex - 1).colorType = CarColorType.Red;
                            carList.get(byCarIndex - 1).price = carPrice;
                            carList.get(byCarIndex - 1).name = carName;
                            carList.get(byCarIndex - 1).carType = CarType.Sedan;
                            System.out.println("Success !");
                        } else {
                            System.out.println("Choose number is invalid !");
                        }
                    }
                    case 2 -> {
                        System.out.println("Car color type :");
                        System.out.println("1]" + CarColorType.Black);
                        System.out.println("2]" + CarColorType.White);
                        System.out.println("3]" + CarColorType.Yellow);
                        System.out.println("4]" + CarColorType.Red);
                        int colorType = scanner.nextInt();
                        if (colorType == 1) {
                            carList.get(byCarIndex - 1).age = age;
                            carList.get(byCarIndex - 1).colorType = CarColorType.Black;
                            carList.get(byCarIndex - 1).price = carPrice;
                            carList.get(byCarIndex - 1).name = carName;
                            carList.get(byCarIndex - 1).carType = CarType.Track;
                            System.out.println("Success !");
                        } else if (colorType == 2) {
                            carList.get(byCarIndex - 1).age = age;
                            carList.get(byCarIndex - 1).colorType = CarColorType.White;
                            carList.get(byCarIndex - 1).price = carPrice;
                            carList.get(byCarIndex - 1).name = carName;
                            carList.get(byCarIndex - 1).carType = CarType.Track;
                            System.out.println("Success !");
                        } else if (colorType == 3) {
                            carList.get(byCarIndex - 1).age = age;
                            carList.get(byCarIndex - 1).colorType = CarColorType.Yellow;
                            carList.get(byCarIndex - 1).price = carPrice;
                            carList.get(byCarIndex - 1).name = carName;
                            carList.get(byCarIndex - 1).carType = CarType.Track;
                            System.out.println("Success !");
                        } else if (colorType == 4) {
                            carList.get(byCarIndex - 1).age = age;
                            carList.get(byCarIndex - 1).colorType = CarColorType.Red;
                            carList.get(byCarIndex - 1).price = carPrice;
                            carList.get(byCarIndex - 1).name = carName;
                            carList.get(byCarIndex - 1).carType = CarType.Track;
                            System.out.println("Success !");
                        } else {
                            System.out.println("Choose number is invalid !");
                        }
                    }
                    case 3 -> {
                        System.out.println("Car color type :");
                        System.out.println("1]" + CarColorType.Black);
                        System.out.println("2]" + CarColorType.White);
                        System.out.println("3]" + CarColorType.Yellow);
                        System.out.println("4]" + CarColorType.Red);
                        int colorType = scanner.nextInt();
                        if (colorType == 1) {
                            carList.get(byCarIndex - 1).age = age;
                            carList.get(byCarIndex - 1).colorType = CarColorType.Black;
                            carList.get(byCarIndex - 1).price = carPrice;
                            carList.get(byCarIndex - 1).name = carName;
                            carList.get(byCarIndex - 1).carType = CarType.Moto;
                            System.out.println("Success !");
                        } else if (colorType == 2) {
                            carList.get(byCarIndex - 1).age = age;
                            carList.get(byCarIndex - 1).colorType = CarColorType.White;
                            carList.get(byCarIndex - 1).price = carPrice;
                            carList.get(byCarIndex - 1).name = carName;
                            carList.get(byCarIndex - 1).carType = CarType.Moto;
                            System.out.println("Success !");
                        } else if (colorType == 3) {
                            carList.get(byCarIndex - 1).age = age;
                            carList.get(byCarIndex - 1).colorType = CarColorType.Yellow;
                            carList.get(byCarIndex - 1).price = carPrice;
                            carList.get(byCarIndex - 1).name = carName;
                            carList.get(byCarIndex - 1).carType = CarType.Moto;
                            System.out.println("Success !");
                        } else if (colorType == 4) {
                            carList.get(byCarIndex - 1).age = age;
                            carList.get(byCarIndex - 1).colorType = CarColorType.Red;
                            carList.get(byCarIndex - 1).price = carPrice;
                            carList.get(byCarIndex - 1).name = carName;
                            carList.get(byCarIndex - 1).carType = CarType.Moto;
                            System.out.println("Success !");
                        } else {
                            System.out.println("Choose number is invalid !");
                        }
                    }
                    default -> System.out.println("INVALID !");
                }
            } else {
                System.out.println("Choose number is invalid !");
            }
        }
    }

    @Override
    public void addCar() {
        Car car = new Car();
        System.out.println("Car name :");
        String carName = scanner.next();
        System.out.println("Car price :");
        int carPrice = scanner.nextInt();
        System.out.println("Car age :");
        String age = scanner.next();
        System.out.println("Car Type :");
        System.out.println("1]" + CarType.Sedan);
        System.out.println("2]" + CarType.Track);
        System.out.println("3]" + CarType.Moto);
        int chooseType = scanner.nextInt();
        switch (chooseType) {
            case 1 -> {
                System.out.println("Car color type :");
                System.out.println("1]" + CarColorType.Black);
                System.out.println("2]" + CarColorType.White);
                System.out.println("3]" + CarColorType.Yellow);
                System.out.println("4]" + CarColorType.Red);
                int colorType = scanner.nextInt();
                if (colorType == 1) {
                    car.age = age;
                    car.colorType = CarColorType.Black;
                    car.price = carPrice;
                    car.name = carName;
                    car.carType = CarType.Sedan;
                    carList.add(car);
                    System.out.println("Success !");
                } else if (colorType == 2) {
                    car.age = age;
                    car.colorType = CarColorType.White;
                    car.price = carPrice;
                    car.name = carName;
                    car.carType = CarType.Sedan;
                    carList.add(car);
                    System.out.println("Success !");
                } else if (colorType == 3) {
                    car.age = age;
                    car.colorType = CarColorType.Yellow;
                    car.price = carPrice;
                    car.name = carName;
                    car.carType = CarType.Sedan;
                    carList.add(car);
                    System.out.println("Success !");
                } else if (colorType == 4) {
                    car.age = age;
                    car.colorType = CarColorType.Red;
                    car.price = carPrice;
                    car.name = carName;
                    car.carType = CarType.Sedan;
                    carList.add(car);
                    System.out.println("Success !");
                } else {
                    System.out.println("Choose number is invalid !");
                }
            }
            case 2 -> {
                System.out.println("Car color type :");
                System.out.println("1]" + CarColorType.Black);
                System.out.println("2]" + CarColorType.White);
                System.out.println("3]" + CarColorType.Yellow);
                System.out.println("4]" + CarColorType.Red);
                int colorType = scanner.nextInt();
                if (colorType == 1) {
                    car.age = age;
                    car.colorType = CarColorType.Black;
                    car.price = carPrice;
                    car.name = carName;
                    car.carType = CarType.Track;
                    carList.add(car);
                    System.out.println("Success !");
                } else if (colorType == 2) {
                    car.age = age;
                    car.colorType = CarColorType.White;
                    car.price = carPrice;
                    car.name = carName;
                    car.carType = CarType.Track;
                    carList.add(car);
                    System.out.println("Success !");
                } else if (colorType == 3) {
                    car.age = age;
                    car.colorType = CarColorType.Yellow;
                    car.price = carPrice;
                    car.name = carName;
                    car.carType = CarType.Track;
                    carList.add(car);
                    System.out.println("Success !");
                } else if (colorType == 4) {
                    car.age = age;
                    car.colorType = CarColorType.Red;
                    car.price = carPrice;
                    car.name = carName;
                    car.carType = CarType.Track;
                    carList.add(car);
                    System.out.println("Success !");
                } else {
                    System.out.println("Choose number is invalid !");
                }
            }
            case 3 -> {
                System.out.println("Car color type :");
                System.out.println("1]" + CarColorType.Black);
                System.out.println("2]" + CarColorType.White);
                System.out.println("3]" + CarColorType.Yellow);
                System.out.println("4]" + CarColorType.Red);
                int colorType = scanner.nextInt();
                if (colorType == 1) {
                    car.age = age;
                    car.colorType = CarColorType.Black;
                    car.price = carPrice;
                    car.name = carName;
                    car.carType = CarType.Moto;
                    carList.add(car);
                    System.out.println("Success !");
                } else if (colorType == 2) {
                    car.age = age;
                    car.colorType = CarColorType.White;
                    car.price = carPrice;
                    car.name = carName;
                    car.carType = CarType.Moto;
                    carList.add(car);
                    System.out.println("Success !");
                } else if (colorType == 3) {
                    car.age = age;
                    car.colorType = CarColorType.Yellow;
                    car.price = carPrice;
                    car.name = carName;
                    car.carType = CarType.Moto;
                    carList.add(car);
                    System.out.println("Success !");
                } else if (colorType == 4) {
                    car.age = age;
                    car.colorType = CarColorType.Red;
                    car.price = carPrice;
                    car.name = carName;
                    car.carType = CarType.Moto;
                    carList.add(car);
                    System.out.println("Success !");
                } else {
                    System.out.println("Choose number is invalid !");
                }
            }
            default -> System.out.println("INVALID !");
        }
    }

    @Override
    public void deleteCar() {
        if (carList.size() == 0) {
            System.out.println("Bosh !");
        } else {
            for (int i = 0; i < carList.size(); i++) {
                System.out.println("==============" + (i + 1) + "====================");
                System.out.println("Car name :" + carList.get(i).name);
                System.out.println("Car price :" + carList.get(i).price);
                System.out.println("Car type :" + carList.get(i).carType);
                System.out.println("Car color type :" + carList.get(i).colorType);
                System.out.println("Car year  :" + carList.get(i).age);
                System.out.println("==========================================");
            }
            System.out.println("Choose :");
            int isDelete = scanner.nextInt();
            if (isDelete < userList.size() + 3) {
                carList.remove(isDelete - 1);
                System.out.println("Success !");
            } else {
                System.out.println("choose invalid !");
            }
        }
    }

    @Override
    public void editProfile() {
        System.out.println("new name :");
        String newName = scanner.next();
        System.out.println("new Email :");
        String newEmail = scanner.next();
        System.out.println("new Password :");
        String newPassword = scanner.next();
        userList.get(userIndex).email = newEmail;
        userList.get(userIndex).password = newPassword;
        userList.get(userIndex).name = newName;
        System.out.println("Success !");
    }

    @Override
    public void myProfile() {
        System.out.println("================Your profile =========================");
        System.out.println("Your name : " + userList.get(userIndex).name);
        System.out.println("Your password : " + userList.get(userIndex).password);
        System.out.println("Your email : " + userList.get(userIndex).email);
        System.out.println("Your card number : " + userList.get(userIndex).cardNumber);
        System.out.println("Your card Type : " + userList.get(userIndex).cardType);
        System.out.println("Your balance :" + userList.get(userIndex).balance);
        System.out.println("Your passport password: "+userList.get(userIndex).passport);
        System.out.println("==========================================================");

    }

    @Override
    public void byCar() {

        if (carList.isEmpty()) {
            System.out.println("Admin mashina qo`shmagan !");
        } else {
            for (int i = 0; i < carList.size(); i++) {
                System.out.println("==============" + (i + 1) + "====================");
                System.out.println("Car name :" + carList.get(i).name);
                System.out.println("Car price :" + carList.get(i).price);
                System.out.println("Car type :" + carList.get(i).carType);
                System.out.println("Car color type :" + carList.get(i).colorType);
                System.out.println("Car year  :" + carList.get(i).age);
                System.out.println("==========================================");
            }
            System.out.println("Choose :");
            int byCarIndex = scanner.nextInt();
            if (3 + userList.size() > byCarIndex) {
                if (carList.get(byCarIndex - 1).price < userList.get(userIndex).balance) {
                    MyCar myCar = new MyCar();
                    myCar.carType = carList.get(byCarIndex - 1).carType;
                    myCar.colorType = carList.get(byCarIndex - 1).colorType;
                    myCar.age = carList.get(byCarIndex - 1).age;
                    myCar.name = carList.get(byCarIndex - 1).name;
                    myCar.price = carList.get(byCarIndex - 1).price;
                    userList.get(userIndex).myCarArrayList.add(myCar);
                    userList.get(userIndex).balance -= carList.get(byCarIndex - 1).price;
                    System.out.println("Success !");

                } else {
                    System.out.println("Balancedagi summa yetarli emas !");
                }
            } else {
                System.out.println("Choose number is invalid !");
            }
        }
    }

    @Override
    public void myCars() {
        if (userList.get(userIndex).myCarArrayList.size() == 0) {
            System.out.println("Siz hali avtomobil  sotib olmagansiz !");
        } else {
            for (int i = 0; i < userList.get(userIndex).myCarArrayList.size(); i++) {
                System.out.println("==========================" + (i + 1) + "===============================");
                System.out.println("Car name :" + userList.get(userIndex).myCarArrayList.get(i).name);
                System.out.println("Car type :" + userList.get(userIndex).myCarArrayList.get(i).carType);
                System.out.println("Car color :" + userList.get(userIndex).myCarArrayList.get(i).colorType);
                System.out.println("Car price :" + userList.get(userIndex).myCarArrayList.get(i).price);
                System.out.println("Car year :" + userList.get(userIndex).myCarArrayList.get(i).age);
                System.out.println("=================================================================");
            }
        }
    }

    @Override
    public void searchCar() {
        System.out.println("Car name :");
        String searchCarName = scanner.next();
        boolean isSearch = false;
        int index = -1;
        for (int i = 0; i < carList.size(); i++) {
            if (Objects.equals(searchCarName, carList.get(i).name)) {
                isSearch = true;
                index = i;
            }
        }
        if (isSearch) {
                System.out.println("==================================");
                System.out.println("Car name :" + carList.get(index).name);
                System.out.println("Car price :" + carList.get(index).price);
                System.out.println("Car type :" + carList.get(index).carType);
                System.out.println("Car color type :" + carList.get(index).colorType);
                System.out.println("Car year  :" + carList.get(index).age);
                System.out.println("==========================================");


        }
        else{
                System.out.println("Bunday nomdagi mashina qoshilmagan ! :(");
            }
        }
    }

