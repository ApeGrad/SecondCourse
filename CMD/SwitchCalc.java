public class SwitchCalc {
   public static void main(String[] args){
        int firstNumber = Integer.parseInt(args[0]);
        int secondNumber = Integer.parseInt(args[2]);
        char operator = args[1].charAt(0);
        switch (operator) {
            case '+':
                System.out.println(firstNumber + secondNumber);
                break;
            case '-':
                System.out.println(firstNumber - secondNumber);
                break;
            case '*':
                System.out.println(firstNumber * secondNumber);
                break;
            case '/':
                System.out.println(firstNumber / secondNumber);
                break;
        }
    }
}