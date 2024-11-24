import java.util.*;


public class Task4 {
    public static String nonRepeat(String s) {
        String answer = "";
        HashMap<Character, Integer> map = new HashMap<>();


        for (char c: s.toCharArray()) {
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
        }


        for (char c: s.toCharArray()) {
            if (map.get(c) <= 3) {
                answer += c;
            }
        }
        return answer;
    }


    public static List<String> bruteForce(int n, int k){
        if(n>k){
            return new ArrayList<>();
        }
        List<String>combinations=new ArrayList<>();
        generateCombinations(n,k,"",combinations);
        return combinations;
    }

    private static void generateCombinations(int n,int k,String current,List<String> combinations){
        if (current.length()==n){
            combinations.add(current);
            return;
        }
        for (int i=0;i<k;i++){
            char c=(char)('0'+i);
            if (current.indexOf(c)==-1){
                generateCombinations(n,k,current+c,combinations);
            }
        }
    }

    public static int[] decode(String message, String key) {
        int[] result = new int[message.length()];

        for (int i = 0; i < message.length(); i++) {
            // XOR между символами сообщения и ключа
            result[i] = message.charAt(i) ^ key.charAt(i);
        }

        return result;
    }

    public static String encode(int[] codes, String key) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < codes.length; i++) {
            // Восстановление символа из числового значения через XOR с ключом
            char decodedChar = (char) (codes[i] ^ key.charAt(i % key.length()));
            result.append(decodedChar);
        }

        return result.toString();
    }

    public static List<String> split(String str){
        List<String> clusters= new ArrayList<>();
        int curr=0;
        StringBuilder cluster = new StringBuilder();
        for (char c: str.toCharArray()){
            cluster.append(c);
            if (c=='('){curr++;}
            if (c==')'){curr--;}
            if (curr==0){
                clusters.add(cluster.toString());
                cluster.setLength(0);
            }
        }
        return clusters;
    }

    public static String shortHand(String str){
        StringBuilder result = new StringBuilder();
        int c=1;
        for (int i=0;i<str.length();i++){
            if (i<str.length()-1 && str.charAt(i)==str.charAt(i+1)){
                c++;
            }else {
                result.append(str.charAt(i));
                if (c>1){
                    result.append("*").append(c);
                }
                c=1;
            }
        }
        return result.toString();

    }

    public static String convertToRome(int start){
        StringBuilder roman=new StringBuilder();
        int[]values={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] symbols={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        for (int i =0;i<values.length;i++){
            while(start>=values[i]){
                roman.append(symbols[i]);
                start-=values[i];
            }
        }
        return roman.toString();
    }

    public static String uniqueSubstring(String digits){
        Map<Character,Integer> countMap=new HashMap<>();
        for(char c:digits.toCharArray()){
            countMap.put(c,countMap.getOrDefault(c,0)+1);
        }
        int maxCount=0;
        int maxIndex=-1;
        for(int i=0;i<digits.length();i++){
            char c=digits.charAt(i);
            int count=countMap.get(c);
            if (count>maxCount){
                maxCount=count;
                maxIndex=i;
            }
        }
        return(maxIndex%2==0) ? "чет" : "нечет";
    }
    public static String[] labirint(int[][]labyrinth){
        int n=labyrinth.length;
        int[][] cost=new int[n][n];
        String[][] path =new String[n][n];
        for (int i=0;i<n;i++){
            Arrays.fill(cost[i],Integer.MAX_VALUE);
            Arrays.fill(path[i],"");
        }
        if (labyrinth[n-1][n-1]>=0){
            cost[n-1][n-1]=labyrinth[n-1][n-1];
            path[n-1][n-1]=Integer.toString(labyrinth[n-1][n-1]);

        }else {
            return new String[]{"Прохода нет"};
        }
        for (int i=n-1;i>=0;i--){
            for (int j=n-1;j>=0;j--){
                if(labyrinth[i][j]<0) continue;
                if (i>0 && cost[i][j]+labyrinth[i-1][j]>=0){
                    int newCost=cost[i][j]+labyrinth[i-1][j];
                    if(newCost<cost[i-i][j]){
                        cost[i-1][j]=newCost;
                        path[i-1][j]=path[i][j]+"-"+labyrinth[i-1][j];
                    }
                }
                if (j>0&&cost[i][j]+labyrinth[i][j-1]>=0){
                    int newCost=cost[i][j]+labyrinth[i][j-1];
                    if (newCost <cost[i][j-1]){
                        cost[i][j-1]=newCost;
                        path[i][j-1]=path[i][j]+"-"+labyrinth[i][j-1];
                    }
                }
            }
        }
        if (cost[0][0]==Integer.MAX_VALUE){
            return new String[]{"прохода нет"};
        }else{
            return new String[]{path[0][0],Integer.toString(cost[0][0])};
        }
    }
    public static String numericOrder(String str){
        String[] words = str.split(" ");
        String [] wordsOrdered = new String[words.length];
        for(String s: words){
            String word = "";
            String numString= "";
            for (char c: s.toCharArray()){
                if (Character.isDigit(c)) {
                    numString += c;
                } else {
                    word += c;
                }
            }
            wordsOrdered[Integer.parseInt(numString) - 1] = word;
        }
        return String.join(" ",  wordsOrdered);
    }

    public static boolean fibString(String str) {
        // Подсчет количества каждого символа
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : str.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        int[] fibNums = isFibonacci(charCount.size());
        int[] seenNums = new int[charCount.size()];
        int i = 0;
        for (Map.Entry<Character, Integer> entry: charCount.entrySet()){
            seenNums[i] = entry.getValue();
            i++;
        }
        Arrays.sort(seenNums);
        return Arrays.equals(seenNums, fibNums);
    }

    // Метод для проверки, является ли число Фибоначчи
    private static int[] isFibonacci(int num) {
        int[] answ = new int[num];
        int first = 1, second = 1;
        for(int i = 0; i < num; i++){
            answ[i] = first;
            second = first + second;
            first = second - first;
        }
        return answ;
    }

    public static void main(String[] args){
        System.out.println(bruteForce(1,5));
        System.out.println(bruteForce(2,2));
        System.out.println(bruteForce(5,3));

        System.out.println(nonRepeat("abracadabra"));
        System.out.println(nonRepeat("abababcac"));

        System.out.println(encode(new int[]{0, 31, 28, 10, 29}, "MKIIT"));
        System.out.println(Arrays.toString(decode("MTUCI","MKIIT")));

        System.out.println(split("()()()"));
        System.out.println(split("((()))"));
        System.out.println(split("((()))(())()()(()())"));
        System.out.println(split("((())())(()(()()))"));


        System.out.println(shortHand("abbccc"));
        System.out.println(shortHand("vvvvaajaaaaa"));
        System.out.println(shortHand("hellooo"));

        System.out.println(convertToRome(8));
        System.out.println(convertToRome(1234));
        System.out.println(convertToRome(52));

        System.out.println(uniqueSubstring("31312131"));
        System.out.println(uniqueSubstring("1111111"));
        System.out.println(uniqueSubstring("12223234333"));

        int[][] labyrinth1 = {
                {1, 3, 1},
                {1, -1, 1},
                {4, 2, 1}
        };

        int[][] labyrinth2 = {
                {2, -7, 3},
                {-4, -1, 8},
                {4, 5, 9}
        };

        System.out.println(Arrays.toString(labirint(labyrinth1)));
        System.out.println(Arrays.toString(labirint(labyrinth2)));

        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));

        System.out.println(fibString("CCCABDD"));
        System.out.println(fibString("ABC"));
    }

}

