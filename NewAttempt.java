package SecondLessonMassives;

import java.util.Arrays;

public class NewAttempt {
    public static void main(String[] args) {
        int[] arr = {1,3,3,4,5,6,3,6,3,3};
        int deleteNumber=3;
        System.out.println("Перед удалением :" + Arrays.toString(arr));
        int count =0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == deleteNumber) {
                count++;
            }
        }
        int [] another = new int [arr.length - count];
        count = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != deleteNumber){
                another[count] = arr[i];
                count++;
                for(int k = i; k < arr.length - 1; k++){
                    arr[k] = arr[k+1];
                }
                i--;
            }
        }

        System.out.print("После удаления :" );
        System.out.println(Arrays.toString(another));

    }
}