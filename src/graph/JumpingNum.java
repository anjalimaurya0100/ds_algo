package graph;

import java.util.LinkedList;
import java.util.Queue;

public class JumpingNum {
    public static void main(String[] args) {
        JumpingNum jn = new JumpingNum();
        jn.jumpingNum(6);
    }

    public void jumpingNum(int input) {
        System.out.println("0");
        for (int i = 1; i <= 9; i++) {
            bfs(i, input);
        }
    }

    private void bfs(int num, int input) {
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        while (!q.isEmpty()) {
            Integer u = q.remove();

            if (u <= input) {
                System.out.println(u);
                int lastDigit = u % 10;
                if (lastDigit == 0) {
                    q.add(u * 10 + lastDigit + 1);
                } else if (lastDigit == 9) {
                    q.add(u * 10 + lastDigit - 1);
                } else {
                    q.add(u * 10 + lastDigit + 1);
                    q.add(u * 10 + lastDigit - 1);
                }
            }
        }
    }
}
