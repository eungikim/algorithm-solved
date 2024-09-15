import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int howManyNum = scanner.nextInt();
        String numString = scanner.next();
        char[] numCharArr = numString.toCharArray();

        int answer = 0;
        for (int i = 0; i < howManyNum; i++) {
            answer += (numCharArr[i] - '0');
        }
        System.out.printf(String.valueOf(answer));
    }
}
