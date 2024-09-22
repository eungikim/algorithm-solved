import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static Stack<Integer> STACK = new Stack<>();
    static int SEQUENCE = 0;
    static StringBuilder RESULT = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        STACK.push(0);


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int term = Integer.parseInt(st.nextToken());

            if (STACK.peek() < term) {
                pushStackTo(term);
                popStack();
            } else if (STACK.peek() == term) {
                popStack();
            } else {
                RESULT.setLength(0);
                RESULT.append("NO");
                break;
            }

        }

        System.out.println(RESULT);
        br.close();
    }

    public static void pushStackTo(int num) {
        for (int i = SEQUENCE; i < num; i++) {
            pushStack();
        }
    }

    public static void pushStack() {
        SEQUENCE++;
        RESULT.append('+').append('\n');
        STACK.push(SEQUENCE);
    }

    public static void popStack() {
        RESULT.append('-').append('\n');
        ;
        STACK.pop();
    }

}