package carBiznice;

public class Car {
    int price;
    String name;
    String age;
    CarColorType colorType;
    CarType carType;

    public Car(int price, String name, String age, CarColorType colorType, CarType carType) {
        this.price = price;
        this.name = name;
        this.age = age;
        this.colorType = colorType;
        this.carType = carType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public CarColorType getColorType() {
        return colorType;
    }

    public void setColorType(CarColorType colorType) {
        this.colorType = colorType;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public Car() {
    }
}
