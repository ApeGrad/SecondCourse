package SecondLessonMassives;

import java.util.Arrays;

public class SecondMassiveChallenge {
    public static void main(String[] args) {
        int[] arr = new int[40];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 90) + 10;
        }
        System.out.println(Arrays.toString(arr));

        boolean sort = true;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] <= arr[i-1]){
                sort = false;
                break;
            }
        }
        if(sort){
            System.out.println("Массив является строго возрастающей последовательностью");
        } else {
            System.out.println("Массив не является строго возрастающей последовательностью");
        }
    }
}