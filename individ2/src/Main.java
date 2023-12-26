import java.util.Scanner;
//определит интерфейс Pair с методами арифметическими операциями. Реализуй интерфейс в классах FuzzyNumber(нечеткие чилса представляются следующим образом: X=(x-e1,x,x+e2). Арифметические операции для них A+B=(A+B-a1-b1,A+B,A+B+a1+b1),A-B=(A-B-a1-b1,A-B,A-B+a2+b2),A*B=(A*B-B*a1-A*b1+a1*b1,A*B,A*B+B*a2+A*b2+a2*b2), A/B=(A-a1)/(B+b2),A/B,(A+a2)/(B-b1) и Complex
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Input chisla for A:");
        double x=sc.nextDouble();
        double e1=sc.nextDouble();
        double e2=sc.nextDouble();
        FuzzyNumber A = new FuzzyNumber(x, e1, e2);
        System.out.println("Input chisla for B:");
        double x2=sc.nextDouble();
        double e3=sc.nextDouble();
        double e4=sc.nextDouble();
        FuzzyNumber B = new FuzzyNumber(x2, e3, e4);

        Pair sum = A.add(B);
        Pair difference = A.subtract(B);
        Pair product = A.multiply(B);
        Pair quotient = A.divide(B);

        System.out.println("Сумма: " + sum);
        System.out.println("Разность: " + difference);
        System.out.println("Произведение: " + product);
        System.out.println("Частное: " + quotient);
    }
}