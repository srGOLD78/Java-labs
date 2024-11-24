import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
public class Task2 {

    public static String duplicateChars(String str1, String str2) {
        String filter = "[" + str2.toLowerCase() + "]";
        return str1.toLowerCase().replaceAll(filter, "");
    }
    public static int dividedByThree(int[] numbers) {
        int count = 0;

        // Проходим по каждому элементу массива
        for (int number : numbers) {
            // Проверяем, является ли число нечетным и кратным 3
            if (number % 2 != 0 && number % 3 == 0) {
                count++;
            }
        }

        return count;
    }

    public static String getInitials(String fullName) {
        // Разделяем строку на части
        String[] parts = fullName.split(" ");

        // Получаем первую букву имени и отчества с точкой
        String initials = parts[1].substring(0, 1).toUpperCase() + "."
                + parts[2].substring(0, 1).toUpperCase() + ".";

        // Преобразуем фамилию: первая буква заглавная, остальные - строчные
        String surname = parts[0].substring(0, 1).toUpperCase() + parts[0].substring(1).toLowerCase();

        // Собираем результат
        return initials + " " + surname;
    }


    public static double[] normalizator(double[] array) {
        double min = array[0];
        double max = array[0];
        double[] ans = new double[array.length];
        // Находим минимальное и максимальное значения в массиве
        for (double num : array) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }
        // Если max == min, возвращаем массив, заполненный нулями
        for(int i = 0; i < array.length; i++){
            if (array[i] == min){
                ans[i] = 0;
            } else if (array[i] == max){
                ans[i] = 1;
            } else {
                ans[i] = (array[i] - min) / (max - min);
            }
        }
        return ans;
    }


    public static double[] compressNumbers(double[] nums) {
        List<Double> nonZeroList = new ArrayList<>();

        // Сбор ненулевых чисел
        for (double num : nums) {
            if (num != 0) {
                nonZeroList.add(num);
            }
        }

        // Преобразование списка в массив
        double[] nonZeroArray = new double[nonZeroList.size()];
        for (int i = 0; i < nonZeroList.size(); i++) {
            nonZeroArray[i] = nonZeroList.get(i);
        }

        // Сортировка массива
        Arrays.sort(nonZeroArray);

        return nonZeroArray;
    }


    public static String camelToSnake(String str) {


        // Используем регулярное выражение для замены заглавных букв
        // Мы добавляем подчеркивание перед заглавной буквой, если она не в начале строки
        return str.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();


    }

    public static int findSecondBiggest(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length - 2];
    }
    public static String localReverse(String s, char marker) {
        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < s.length()) {
            // Если текущий символ - маркер, ищем следующую пару
            if (s.charAt(i) == marker) {
                // Добавляем текущий маркер
                result.append(marker);
                i++; // Переход к следующему символу

                // Начинаем искать конец пары маркерных символов
                int start = i;
                while (i < s.length() && s.charAt(i) != marker) {
                    i++;
                }

                // Если нашли пару маркеров
                if (i < s.length()) {
                    // Разворачиваем часть между маркерами
                    for (int j = i - 1; j >= start; j--) {
                        result.append(s.charAt(j));
                    }
                    // Добавляем второй маркер
                    result.append(marker);
                    i++; // Переход к следующему символу после второго маркера
                }
            } else {
                // Добавляем текущий символ в результат
                result.append(s.charAt(i));
                i++;
            }
        }

        return result.toString();
    }


    public static int equal(int a, int b, int c) {
        // Если все три числа равны
        if (a == b && b == c) {
            return 3;
        }
        // Если хотя бы два числа равны
        else if (a == b || a == c || b == c) {
            return 2;
        }
        return 0;
    }



    public static boolean isAnagram(String str1, String str2) {
        // Убираем все пробелы и знаки пунктуации, а также приводим к нижнему регистру
        String cleanStr1 = str1.replaceAll("[^a-zA-Z]", "").toLowerCase();
        String cleanStr2 = str2.replaceAll("[^a-zA-Z]", "").toLowerCase();

        // Если длины строк не совпадают, то они точно не анаграммы
        if (cleanStr1.length() != cleanStr2.length()) {
            return false;
        }

        // Преобразуем строки в массивы символов
        char[] charArray1 = cleanStr1.toCharArray();
        char[] charArray2 = cleanStr2.toCharArray();

        // Сортируем оба массива
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        // Сравниваем отсортированные массивы символов
        return Arrays.equals(charArray1, charArray2);
    }

    public static void main(String[] args) {
        String result = duplicateChars("Barack", "Obama");
        System.out.println(result);


        int[] numbers = {3, 12, 7, 81, 52};
        int result1 = dividedByThree(numbers);
        System.out.println(result1);



        String result2 = getInitials("simonov sergei evgenievich");
        System.out.println(result2);  // Output: "S.E. Simonov"

        String result3 = getInitials("kozhevnikova tatiana vitalevna");
        System.out.println(result3);  // Output: "T.V. Kozhevnikova"


        double[] array1 = {3.5, 7.0, 1.5, 9.0, 5.5};
        double[] result4 = normalizator(array1);
        System.out.println(Arrays.toString(result4));

        double[] array2 = {10.0, 10.0, 10.0, 10.0};
        double[] result5 = normalizator(array2);
        System.out.println(Arrays.toString(result5));


        double[] input = {1.6, 0, 212.3, 34.8, 0, 27.5};
        double[] compressed = compressNumbers(input);
        System.out.println(Arrays.toString(compressed));


        String camelCaseString = "helloWorld";
        String snakeCaseString = camelToSnake(camelCaseString);
        System.out.println(snakeCaseString); // hello_world



        int[] numbers2 = {3, 5, 8, 1, 2, 4};
        int secondBiggest = findSecondBiggest(numbers2);

        System.out.println("Второй по величине элемент: " + secondBiggest);


        System.out.println(localReverse("baobab", 'b'));
        System.out.println(localReverse("Hello, I'm under the water, please help me", 'e'));



        System.out.println(equal(8, 1, 8));
        System.out.println(equal(5, 5, 5));
        System.out.println(equal(4, 9, 6));



        System.out.println(isAnagram("LISTEN", "silent"));
        System.out.println(isAnagram("Eleven plus two?", "Twelve plus one!"));
        System.out.println(isAnagram("hello", "world"));
    }
}
