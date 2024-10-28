public class Task1 {

    private static final double GALLON_TO_LITER = 3.78541;

    public static double convert(int gallons) {
        return gallons * GALLON_TO_LITER;
    }

    public static int fitCalc(int minutes, int intensity) {
        int[] caloriesPerMinute = new int[3];

        for (int i = 0; i < 3; i++) {
            caloriesPerMinute[i] = i + 1;
        }

        return minutes * caloriesPerMinute[intensity - 1];
    }

    public static int containers(int boxes, int bags, int barrels) {
        int itemsInBox = 20;
        int itemsInBag = 50;
        int itemsInBarrel = 100;

        return (boxes * itemsInBox) + (bags * itemsInBag) + (barrels * itemsInBarrel);
    }
    public static String triangleType(int x, int y, int z) {
        if (x + y <= z || x + z <= y || y + z <= x) {
            return "не является треугольником";
        }

        if (x == y && y == z) {
            return "равносторонний";
        } else if (x == y || y == z || x == z) {
            return "равнобедренный";
        } else {
            return "разносторонний";
        }
    }
    public static int ternaryEvaluation(int a, int b) {
        return (a > b) ? a : b;
    }

    public static int howManyItems(int n, double w, double h) {
        double totalFabricArea = n / 2;
        double itemArea = w * h;

        return (int)(totalFabricArea / itemArea);
    }

    public static  int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    public static int nod(int a, int b) {
        int c0 = 1;
        int min = Math.min(a, b);

        for (int i = 1; i <= min; i++) {
            if (a % i == 0 && b % i == 0) {
                c0 = i;
            }
        }

        return c0;
    }
    public static double ticketSaler(int ticketsSold, double ticketPrice) {
        double commissionRate = 0.28;
        double netPrice = ticketPrice * (1 - commissionRate);
        return ticketsSold * netPrice;
    }
    public static int tables(int students, int existingTables) {
        int requiredTables = (students + 1) / 2;
        return requiredTables > existingTables ? requiredTables - existingTables : 0;
    }

    public static void main(String[] args) {
        System.out.println("5 галлонов = " + convert(5) + " литров");
        System.out.println("3 галлона = " + convert(3) + " литров");
        System.out.println("8 галлонов = " + convert(8) + " литров");


        System.out.println("Сожжено калорий: " + fitCalc(15, 1)); // ➞ 15
        System.out.println("Сожжено калорий: " + fitCalc(24, 2)); // ➞ 48
        System.out.println("Сожжено калорий: " + fitCalc(41, 3)); // ➞ 123


        System.out.println("Общее количество товаров: " + containers(3, 4, 2)); // ➞ 460
        System.out.println("Общее количество товаров: " + containers(5, 0, 2)); // ➞ 300
        System.out.println("Общее количество товаров: " + containers(4, 1, 4)); // ➞ 530

        System.out.println(triangleType(5, 5, 5));
        System.out.println(triangleType(5, 4, 5));
        System.out.println(triangleType(3, 4, 5));
        System.out.println(triangleType(5, 1, 1));

        System.out.println(ternaryEvaluation(8, 4));
        System.out.println(ternaryEvaluation(1, 11));
        System.out.println(ternaryEvaluation(5, 9));

        System.out.println(howManyItems(22, 1.4, 2));
        System.out.println(howManyItems(45, 1.8, 1.9));
        System.out.println(howManyItems(100, 2, 2));

        System.out.println(factorial(3));
        System.out.println(factorial(5));
        System.out.println(factorial(7));

        System.out.println(nod(48, 18));
        System.out.println(nod(52, 8));
        System.out.println(nod(259, 28));

        System.out.println(ticketSaler(70, 1500));
        System.out.println(ticketSaler(24, 950));
        System.out.println(ticketSaler(53, 1250));

        System.out.println(tables(5, 2));
        System.out.println(tables(31, 20));
        System.out.println(tables(123, 58));

    }
}
//https://github.com/srGOLD78/Java-labs