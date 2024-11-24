import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Task5 {
    public static boolean sameLetterPattern(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        java.util.Map<Character, Character> map1 = new java.util.HashMap<>();
        java.util.Map<Character, Character> map2 = new java.util.HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if (map1.containsKey(c1) && map1.get(c1) != c2 || map2.containsKey(c2) && map2.get(c2) != c1) {
                return false;
            }

            map1.put(c1, c2);
            map2.put(c2, c1);
        }

        return true;
    }

    public static int memeSum(int a, int b) {
        String strA = Integer.toString(a);
        String strB = Integer.toString(b);

        int maxLength = Math.max(strA.length(), strB.length());

        strA = String.format("%" + maxLength + "s", strA).replace(' ', '0');
        strB = String.format("%" + maxLength + "s", strB).replace(' ', '0');

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < maxLength; i++) {
            int sum = (strA.charAt(i) - '0') + (strB.charAt(i) - '0');
            result.append(sum);
        }
        return Integer.parseInt(result.toString());
    }
    public static int digitsCount(long number) {
        if (number == 0) {
            return 1;
        }
        return (number / 10 == 0) ? 1 : 1 + digitsCount(number / 10);
    }



    public static int calculateScore(String scrambledWord, String[] guessedWords) {
            int totalScore = 0;
            Map<Character, Integer> letterCount = new HashMap<>();
            for (char c : scrambledWord.toCharArray()) {
                letterCount.put(c, letterCount.getOrDefault(c, 0) + 1);
            }
            for (String word : guessedWords) {
                if (isValidWord(word, letterCount)) {
                    totalScore += calculateWordScore(word);
                }
            }

            return totalScore;
        }
    public static boolean isValidWord(String word, Map<Character, Integer> letterCount) {
        Map<Character, Integer> wordCount = new HashMap<>();

        for (char c : word.toCharArray()) {
            wordCount.put(c, wordCount.getOrDefault(c, 0) + 1);
        }
        for (char c : wordCount.keySet()) {
            if (wordCount.get(c) > letterCount.getOrDefault(c, 0)) {
                return false;
            }
        }
        return true;
    }

    public static int calculateWordScore(String word) {
        int length = word.length();
        switch (length) {
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
                return 3;
            case 6:
                return 54;
            default:
                return 0;
        }
    }

    public static int longestRun(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int maxLength = 1;
        int currentLength = 1;
        for (int i = 1; i < arr.length; i++) {

            if (arr[i] == arr[i - 1] + 1 || arr[i] == arr[i - 1] - 1) {
                currentLength++;
            } else {
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 1;
            }
        }
        return Math.max(maxLength, currentLength);
    }

    public static String takeDownAverage(String[] grades) {
        int sum = 0;
        for (String grade : grades) {
            sum += Integer.parseInt(grade.replace("%", ""));
        }

        int numberOfStudents = grades.length;

        double averageWithoutYourGrade = (double) sum / numberOfStudents;

        double targetAverage = averageWithoutYourGrade - 5;
        double yourGrade = targetAverage * (numberOfStudents + 1) - sum;

        return yourGrade < 0 ? "0%" : Math.round(yourGrade) + "%";
    }

    public static boolean canMove(String piece, String start, String target) {
        int startX = start.charAt(0) - 'A';
        int startY = Character.getNumericValue(start.charAt(1)) - 1;

        int targetX = target.charAt(0) - 'A';
        int targetY = Character.getNumericValue(target.charAt(1)) - 1;

        switch (piece.toLowerCase()) {
            case "pawn":
                if (startX == targetX && targetY == startY + 1) {
                    return true;
                }
                return false;

            case "knight":
                int dx = Math.abs(startX - targetX);
                int dy = Math.abs(startY - targetY);
                return (dx == 2 && dy == 1) || (dx == 1 && dy == 2);

            case "bishop":
                return Math.abs(startX - targetX) == Math.abs(startY - targetY);

            case "rook":
                return startX == targetX || startY == targetY;

            case "queen":
                return (startX == targetX || startY == targetY) || Math.abs(startX - targetX) == Math.abs(startY - targetY);

            case "king":
                return Math.abs(startX - targetX) <= 1 && Math.abs(startY - targetY) <= 1;

            default:
                return false;
        }
    }
    public static int maxPossible(int num1, int num2) {
        String num1Str = Integer.toString(num1);
        String num2Str = Integer.toString(num2);
        char[] num1Chars = num1Str.toCharArray();
        char[] num2Chars = num2Str.toCharArray();

        Arrays.sort(num2Chars);
        reverseArray(num2Chars);

        int j = 0;

        for (int i = 0; i < num1Chars.length; i++) {

            if (j < num2Chars.length && num2Chars[j] > num1Chars[i]) {
                num1Chars[i] = num2Chars[j++];
            }
        }

        return Integer.parseInt(new String(num1Chars));
    }

    public static void reverseArray(char[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    private static final Map<String, Integer> GMT_OFFSETS = new HashMap<>();

    static {
        GMT_OFFSETS.put("Los Angeles", -8 * 60);
        GMT_OFFSETS.put("New York", -5 * 60);
        GMT_OFFSETS.put("Caracas", -4 * 60 - 30);
        GMT_OFFSETS.put("Buenos Aires", -3 * 60);
        GMT_OFFSETS.put("London", 0);
        GMT_OFFSETS.put("Rome", 1 * 60);
        GMT_OFFSETS.put("Moscow", 3 * 60);
        GMT_OFFSETS.put("Tehran", 3 * 60 + 30);
        GMT_OFFSETS.put("New Delhi", 5 * 60 + 30);
        GMT_OFFSETS.put("Beijing", 8 * 60);
        GMT_OFFSETS.put("Canberra", 10 * 60);
    }

    public static String timeDifference(String cityA, String timestamp, String cityB) {
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("MMMM d, yyyy HH:mm", Locale.US);
            inputFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

            Date date = inputFormat.parse(timestamp);

            int offsetA = GMT_OFFSETS.get(cityA);
            int offsetB = GMT_OFFSETS.get(cityB);

            int offsetDifference = offsetB - offsetA;

            long timeInMillis = date.getTime() + offsetDifference * 60 * 1000L;


            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-M-d HH:mm", Locale.US);
            outputFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

            return outputFormat.format(new Date(timeInMillis));
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid timestamp format", e);
        }
    }




    public static boolean isNew(int number) {

        String numStr = String.valueOf(number);


        for (int i = 1; i < number; i++) {

            if (isPermutation(String.valueOf(i), numStr)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isPermutation(String str1, String str2) {

        if (str1.length() != str2.length()) {
            return false;
        }

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return Arrays.equals(chars1, chars2);
    }







    public static void main(String[] args) {
        System.out.println(sameLetterPattern("ABAB", "CDCD"));
        System.out.println(sameLetterPattern("ABCBA", "BCDCB"));
        System.out.println(sameLetterPattern("FFGG", "CDCD"));
        System.out.println(sameLetterPattern("FFFF", "ABCD"));

        System.out.println(memeSum(26, 39));
        System.out.println(memeSum(122, 81));
        System.out.println(memeSum(1222, 30277));


        System.out.println(digitsCount(4666));
        System.out.println(digitsCount(544));
        System.out.println(digitsCount(121317));
        System.out.println(digitsCount(0));
        System.out.println(digitsCount(12345));
        System.out.println(digitsCount(1289396387328L));


        String scrambledWord = "recant";
        String[] guessedWords = {"trance", "recant"};

        int totalScore = calculateScore(scrambledWord, guessedWords);
        System.out.println("Total Score: " + totalScore);


        System.out.println(longestRun(new int[]{1, 2, 3, 5, 6, 7, 8, 9}));
        System.out.println(longestRun(new int[]{1, 2, 3, 10, 11, 15}));
        System.out.println(longestRun(new int[]{5, 4, 2, 1}));
        System.out.println(longestRun(new int[]{3, 5, 7, 10, 15}));

        System.out.println(takeDownAverage(new String[]{"95%", "83%", "90%", "87%", "88%", "93%"}));
        System.out.println(takeDownAverage(new String[]{"10%"}));
        System.out.println(takeDownAverage(new String[]{"53%", "79%"}));

        System.out.println(canMove("Rook", "A8", "H8"));
        System.out.println(canMove("Bishop", "A7", "G1"));
        System.out.println(canMove("Queen", "C4", "D6"));


        System.out.println(maxPossible(9328, 456));
        System.out.println(maxPossible(523, 76));
        System.out.println(maxPossible(9132, 5564));
        System.out.println(maxPossible(8732, 91255));

        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome"));
        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing"));



        System.out.println(isNew(3));
        System.out.println(isNew(30));
        System.out.println(isNew(321));
        System.out.println(isNew(123));
    }
}
