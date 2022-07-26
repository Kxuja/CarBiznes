package carBiznice;

public class MyCar {
    int price;
    String name;
    String age;
    CarColorType colorType;
    CarType carType;

    public MyCar(int price, String name, String age, CarColorType colorType, CarType carType) {
        this.price = price;
        this.name = name;
        this.age = age;
        this.colorType = colorType;
        this.carType = carType;
    }

    public MyCar() {
    }
}
