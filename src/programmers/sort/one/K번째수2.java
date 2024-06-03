package programmers.sort.one;

import java.util.Arrays;

// 정렬 - K번째수 풀이2
class K번째수2 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int q = 0; q < commands.length; q++) {
            int[] comArr = commands[q];
            
            int i = comArr[0] - 1;
            int j = comArr[1] - 1;
            int k = comArr[2] - 1;
            
            int[] tmpArr = new int[j - i + 1];
            int idx = 0;
            for(int x = i; x <= j; x++) {
                tmpArr[idx++] = array[x];
            }
            Arrays.sort(tmpArr);
            answer[q] = tmpArr[k];
        }
        return answer;
    }
}