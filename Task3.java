import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class Task3 {
    // 1 задание
    public static boolean isStrangePair(String first, String second){
        if (first == "" || second == ""){
            return true;
        }
        return (first.charAt(0) == second.charAt(second.length() - 1) && first.charAt(first.length() - 1) == second.charAt(0));
    }

    // 2 задание
    public static Object[][] sale(Object[][] initial, int discount){
        float coefficient = (100 - discount) * .01f;
        int ind = 0;
        for (Object[] elem: initial){
            float newPrice = ((Integer) elem[1]) * coefficient;
            int priceInt = Math.round(newPrice);
            if (priceInt == 0){
                priceInt = 1;
            }
            initial[ind][1] = priceInt;
            ind++;
        }
        return initial;
    }

    // 3 задание
    public static boolean successShot(double x, double y, double r, double m, double n) {
        double distance = Math.sqrt(Math.pow(m - x, 2) + Math.pow(n - y, 2));
        return distance <= r;
    }
    // 4 задание
    public static boolean parityAnalysis(int num){
        boolean isNumEven=num%2==0;
        int sumOfDigits=0;
        int temp=num;
        while (temp>0){
            sumOfDigits+=temp%10;
            temp/=10;
        }
        boolean isSumEven=sumOfDigits%2==0;
        return isNumEven == isSumEven;
    }
    //5 задание
    public static String rps(String player1, String player2){
        if (player1.equals(player2)){
            return "Tie";
        }
        if (player1.equals("rock") && player2.equals("scissors")||
           player1.equals("scissors")&&player2.equals("paper")  ||
           player1.equals("paper")&& player2.equals("rock")){
            return "Player 1 wins";
        } else {
            return "Player 2 wins";
        }

    }
    // 6 задание

    public static int bugger(int num){
        int tmp;
        int cnt = 0;
        while (num > 10){
            tmp = 1;
            while (num != 0){
                tmp *= num % 10;
                num /= 10;
            }
            num = tmp;
            cnt++;
        }
        return cnt;
    }

    //7 задание
    public static String mostExpensive(Object[][] items){
        String itemName = "";
        int maxTotal = 0;

        for (Object[] elem: items){
            int totalPrice = (Integer) elem[1] * (Integer) elem[2];
            if (totalPrice > maxTotal){
                itemName = (String) elem[0];
                maxTotal = totalPrice;
            }
        }
        return String.format("%s - %d", itemName, maxTotal);
    }
    //8 задание
    public static String longestUnique(String str){
        String longestSubstring="";
        int start=0;
        int end=0;
        Set<Character> uniqueChars = new HashSet<>();
        while (end< str.length()){
            char currentChar=str.charAt(end);
            if (uniqueChars.add(currentChar)){
                end++;
                if (end-start>longestSubstring.length()){
                    longestSubstring=str.substring(start,end);
                }
            }else {
                uniqueChars.remove(str.charAt(start));
                start++;
            }
        }
        return longestSubstring;
    }
    //9 задание
    public static boolean isPrefix(String word,String prefix){
        if (prefix.endsWith("-")){
            prefix=prefix.substring(0,prefix.length()-1);
        }
        return word.startsWith(prefix);

    }
    public static boolean isSuffix(String word,String suffix){
        if (suffix.startsWith("-")){
            suffix=suffix.substring(1);
        }
        return word.endsWith(suffix);
    }
    //10задание
    public static boolean doesBrickFit(int a, int b, int c, int w, int h) {
        return (a <= w && b <= h) || (a <= h && b <= w) ||
                (a <= w && c <= h) || (a <= h && c <= w) ||
                (b <= w && c <= h) || (b <= h && c <= w);

    }

    public static void main(String[] args) {
        System.out.println(isStrangePair("ratio", "orator"));
        System.out.println(isStrangePair("sparkling", "groups"));
        System.out.println(isStrangePair("bush", "hubris"));
        System.out.println(isStrangePair("", ""));

        Object[][] answer = sale(new Object[][]{
                new Object[]{"Laptop", 124200},
                new Object[]{"Phone", 51450},
                new Object[]{"Headphones", 13800},
        }, 25);
        for (Object[] elem: answer){
            System.out.println(Arrays.toString(elem));
        }

        System.out.println(successShot(0, 0, 5, 2, 2));
        System.out.println(successShot(-2,-3,4,5,-6));

        System.out.println(parityAnalysis(243));
        System.out.println(parityAnalysis(12));
        System.out.println(parityAnalysis(3));


        System.out.println(rps("rock","paper"));
        System.out.println(rps("paper","rock"));
        System.out.println(rps("paper","scissors"));
        System.out.println(rps("scissors","scissors"));
        System.out.println(rps("scissors","paper"));


        System.out.println(bugger(39));
        System.out.println(bugger(999));
        System.out.println(bugger(4));

        Object[][] inventory={
                {"Скакалка",550,8},
                {"Шлем",3750,4},
                {"мяч",2900,10}
        };
        System.out.println(mostExpensive(inventory));
        System.out.println(longestUnique("abcba"));
        System.out.println(longestUnique("bbb"));


        System.out.println(isPrefix("automation","auto-"));
        System.out.println(isSuffix("arachnophobia","-phobia"));
        System.out.println(isPrefix("retrospect","sub-"));
        System.out.println(isSuffix("vocation","'logy"));

        System.out.println(doesBrickFit(1,1,1,1,1));
        System.out.println(doesBrickFit(1,2,1,1,1));
        System.out.println(doesBrickFit(1,2,2,1,1));


    }
}



