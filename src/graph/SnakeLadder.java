package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SnakeLadder {
    public static void main(String[] args) {
        int[] moves = new int[30];
        Arrays.fill(moves, -1);
        //Ladders
        moves[2] = 21;
        moves[4] = 7;
        moves[10] = 25;
        moves[19] = 28;

        //Snakes
        moves[26] = 0;
        moves[20] = 8;
        moves[16] = 3;
        moves[18] = 6;

        SnakeLadder sl = new SnakeLadder();
        System.out.println("Min Dice throws required is " + sl.minSteps(moves));
    }

    public int minSteps(int[] array) {
        Queue<Step> q = new LinkedList<>();
        boolean[] visited = new boolean[array.length];

        q.add(new Step(0, 0));
        visited[0] = true;

        while (!q.isEmpty()) {
            Step p = q.remove();

            if (p.i == array.length - 1) {
                return p.dist;
            }

            for (int j = p.i + 1; j <= p.i + 6 && j < array.length; j++) {
                if (!visited[j]) {
                    if (array[j] != -1) {
                        q.add(new Step(array[j], p.dist + 1));
                    } else {
                        q.add(new Step(j, p.dist + 1));
                    }
                    visited[j] = true;
                }
            }
        }

        return -1;
    }

    static class Step {
        int i;
        int dist;

        public Step(int i, int dist) {
            this.i = i;
            this.dist = dist;
        }

    }
}
