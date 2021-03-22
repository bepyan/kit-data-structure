import java.util.Scanner;
import java.util.Stack;

public class History {
    private Stack<String> historyStack = new Stack<>();
    private Stack<String> forwardStack = new Stack<>();

    // 현 페이지
    public String getCurURL() {
        if (historyStack.empty())
            return "no url";

        return historyStack.peek();
    }

    // 페이지 이동하기
    public void go(String url) {
        historyStack.push(url);
        forwardStack.clear();
    }

    // 이전 페이지 이동하기
    public String back() {
        if (historyStack.size() < 2)
            return "no url";

        String url = historyStack.pop();
        forwardStack.push(url);
        return historyStack.peek();
    }

    // 앞 페이지 이동하기
    public String forward() {
        if (forwardStack.empty())
            return "no url";

        String url = forwardStack.pop();
        historyStack.push(url);
        return url;
    }

    public void print() {
        System.out.print("History: ");
        for (String s : historyStack)
            System.out.print(s + " ");
        System.out.print("\n");

        System.out.print("Forward: ");
        for (String s : forwardStack)
            System.out.print(s);
        System.out.print("\n");

    }

    public void run() {
        System.out.println("\nG string: push url, B: go back url, F: go front url, Q: quit");
        String input = "";
        Scanner scan = new Scanner(System.in);
        while (!input.equals("q")) {
            print();
            System.out.print("\n$ ");

            input = scan.nextLine();
            switch (input.charAt(0)) {
            case 'G':
                String url = input.substring(1);
                go(url);
                break;
            case 'B':
                System.out.println(back());
                break;
            case 'F':
                System.out.println(forward());
                break;
            default:
                System.out.println("Plese use right command");
            }
        }
        scan.close();
    }

    public static void main(String[] args) {
        History HN = new History();
        HN.run();
    }
}
