import java.util.Scanner;

public class javaLopsII {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int quantityNumbers = sc.nextInt();

        for (int i = 0; i < quantityNumbers; i++) {

            String result = "";

            int inputA = sc.nextInt();
            int inputB = sc.nextInt();
            int inputC = sc.nextInt();

            int sum = inputA + inputB;
            int base = 1;
            result += sum;
            System.out.println(result);


            for (int y = 1; y < inputC; y++) {
                base *= 2 ;
                sum += base * inputB;
                result += " " + sum;
            }
            System.out.println(result);
        }
        sc.close();
    }
}
