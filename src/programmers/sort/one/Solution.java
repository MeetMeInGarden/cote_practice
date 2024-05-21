package programmers.sort.one;

import java.util.ArrayList;
import java.util.Collections;

// 정렬 - K번째수 풀이1
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int q = 0; q < commands.length; q++) {
            int[] tmp = commands[q];
            ArrayList<Integer> list = new ArrayList<>();

            int i = tmp[0] - 1;
            int j = tmp[1] - 1;
            int k = tmp[2] - 1;

            for(int x = i; x <= j; x++) {
                list.add(array[x]);
            }
            Collections.sort(list);
            answer[q] = list.get(k);
        }
        return answer;
    }
}