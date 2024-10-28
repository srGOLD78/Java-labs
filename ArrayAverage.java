public class ArrayAverage {
    public static void main(String [] args){
        Object[]arr={1,2,3,4,5};
        int sum=0;
        int c=0;

        try{
            for (int i=0;i<arr.length;i++){
                if (arr[i] instanceof Integer){
                    sum+=(int) arr[i];
                    c++;
                }else{
                    throw new NumberFormatException("Элемент не является числом: " + arr[i]);
                }
            }
            if (c>0){
                double average =(double) sum/c;
                System.out.println("Среднее арифметическое: " + average);
            }else {
                System.out.println("В массиве нет числовых значений для вычисления среднего");
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Ошибка: выход за пределы массива");
        }catch (NumberFormatException e){
            System.out.println("Ошибка: "+ e.getMessage());
        }
    }
}
