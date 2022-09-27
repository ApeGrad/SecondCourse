public class Calc {
     public static void main(String[] args) {
        int ab = Integer.parseInt(args[0]);
        String ba = args[1];
        int cb = Integer.parseInt(args[2]);
        int rec = ab * cb;
        int dec = ab / cb;
        int meq = ab - cb;
        int res = ab + cb;
        if (ba.equals("Plus")) {
            System.out.println(res);
        }
        if(ba.equals("Minus")){
            System.out.println(meq);
        }
        if (ba.equals("Multiply")){
            System.out.println(rec);
        }
        if (ba.equals("Divide")){
            System.out.println(dec);
        }


    }
}
