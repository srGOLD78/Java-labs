// Абстрактный класс "Транспортное средство" Реализация абстракции
abstract class Transport {////Абстрактный класс не может быть создан напрямую,от него могут только наследоваться
    // Реализация инкапсуляции .Поля скрыты от внешнего доступа и доступ к ним осуществляется через геттеры и сеттеры.
    private String make; //приватное поле-переменная,доступ которой ограничен только самим классом.
    private String model;
    private int year;
    private static int totalCount = 0;

    // Конструктор-метод,который используется для инициализации нового обьекта класса
    public Transport(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
        totalCount++;
    }

    // Конструктор по умолчанию
    public Transport() {
        totalCount++;
    }

    // Геттеры и сеттеры .Метод получения значений полей.Метод установки значений полей.
    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    // Метод для вывода информации
    public String info() {
        return year + " " + make + " " + model;
    }

    // Перегрузка метода info
    public String info(String prefix) {
        return prefix + ": " + year + " " + make + " " + model;
    }

    // Статический метод для получения количества созданных объектов
    public static int getTotalCount() {
        return totalCount;
    }
    //абстрактный метод
    public void move() {
        System.out.println(info() + " is moving.");
    }
}
// Класс "Легковой автомобиль", наследует "Моторное транспортное средство"
class Car extends Transport {

    private int doors; // Приватное поле
    // Конструктор
    public Car(String make, String model, int year, int doors) {
        super(make, model, year);
        this.doors = doors;
    }
    // Конструктор по умолчанию
    public Car() {
        super();
    }
    @Override
    // Переопределение абстрактного метода.Реализация полиморфизма.Разные классы имеют свою реализаию одного и того же метода.
    public void move() {
        System.out.println(info() + " is driving on the road.");
    }
    // Геттеры и сеттеры для количества дверей
    public int getDoors() {
        return doors;
    }
    public void setDoors(int doors) {
        this.doors = doors;
    }
    // Переопределение метода info
    @Override
    public String info() {
        return super.info() + " with " + doors + " doors.";
    }
}

// Класс "Грузовой автомобиль", наследует "Моторное транспортное средство"
class Truck extends Transport {
    private double loadCapacity; // Приватное поле
    // Конструктор
    public Truck(String make, String model, int year, double loadCapacity) {
        super(make, model, year);
        this.loadCapacity = loadCapacity;
    }
    // Конструктор по умолчанию
    public Truck() {
        super();
    }
    @Override
    // Переопределение абстрактного метода
    public void move() {
        System.out.println(info() + " is transporting goods.");
    }
    // Геттеры и сеттеры для грузоподъемности
    public double getLoadCapacity() {
        return loadCapacity;
    }
    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
    // Переопределение метода info
    @Override
    public String info() {
        return super.info() + " with load capacity " + loadCapacity + " tons.";
    }
}

// Класс "Мотоцикл", наследует "Моторное транспортное средство"
class Motorcycle extends Transport {
    private double engineVolume; // Приватное поле
    // Конструктор
    public Motorcycle(String make, String model, int year, double engineVolume) {
        super(make, model, year);
        this.engineVolume = engineVolume;
    }
    // Конструктор по умолчанию
    public Motorcycle() {
        super();
    }
    @Override
    // Переопределение абстрактного метода
    public void move() {
        System.out.println(info() + " is speeding down the highway.");
    }
    // Геттеры и сеттеры для объема двигателя
    public double getEngineVolume() {
        return engineVolume;
    }
    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }
    // Переопределение метода info
    @Override
    public String info() {
        return super.info() + " with engine volume " + engineVolume + " cc.";
    }
}

// Основной класс для тестирования
public class Main {
    public static void main(String[] args) {
        // Создание объектов
        Car car = new Car("Toyota", "Camry", 2020, 4);
        Truck truck = new Truck("Volvo", "FH16", 2018, 20.5);
        Motorcycle motorcycle = new Motorcycle("Yamaha", "R1", 2021, 998);
        // Вызов методов
        car.move();
        truck.move();
        motorcycle.move();
        // Вывод информации о каждом объекте
        System.out.println(car.info("Car info"));
        System.out.println(truck.info("Car info"));
        System.out.println(motorcycle.info("Car info"));
        // Вывод количества созданных объектов
        System.out.println("Total transport vehicles created: " + truck.getTotalCount());
    }
}
//static является частью класса , а не экземпляром.Вызывается через имя класса. на принадлежность члена класса к самому классу, а не к его объектам, обеспечивая общий доступ и упрощая некоторые задачи.
//Наследование — это механизм, позволяющий создавать новые классы на основе существующих.
//Полиморфизм позволяет использовать один и тот же интерфейс для различных классов,(возможность переопределять методы в дочерних классах)Это принцип,который
//Инкапсуляция подразумевает объединение данных и методов, работающих с этими данными, в единую сущность — объект.сокрытие обьектов от других методов
//Абстракция позволяет сосредоточиться на основных характеристиках объекта, скрывая при этом ненужные детали.
// Вызов Transport.getTotalCount() работает с классом в целом и возвращает информацию о количестве созданных объектов всех типов, наследующих от Transport,  не затрагивая состояние отдельных объектов.
// детерменированный
// Статические методы доступны через любой экземпляр класса, но на самом деле они не связаны с конкретным экземпляром.  Они работают с общим состоянием класса.