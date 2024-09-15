import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int howManyNum = Integer.parseInt(scanner.nextLine());
        String inputString = scanner.nextLine();

        int[] classScore = Arrays.stream(inputString.split(" ")).mapToInt(Integer::parseInt).toArray();
        int sumClassScore = Arrays.stream(classScore).sum();
        int maxClassScore = Arrays.stream(classScore).max().getAsInt();
        double result = (double) (sumClassScore * 100) / maxClassScore / howManyNum;
        System.out.println(result);
    }
}
