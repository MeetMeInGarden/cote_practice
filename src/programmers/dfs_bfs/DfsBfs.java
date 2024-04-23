package programmers.dfs_bfs;

// 깊이/너비 우선 탐색(DFS/BFS) - 타겟 넘버
public class DfsBfs {
    int[] numbers_global;   // [사용할 수 있는 숫자가 담긴 배열]을 전역변수로 선언
    int target_global;      // [타겟 넘버]을 전역변수로 선언
    int count = 0;          // 최종 정답
    
    public int solution(int[] numbers, int target) {
        this.numbers_global = numbers;
        this.target_global = target;

        // dfs 함수 호출
        this.dfs(0, 0);
        
        return this.count;
    }
    
    private void dfs(int index, int sum) {
        
        int val = this.numbers_global[index];
        index += 1;
        if(index == numbers_global.length) {
            // 더 이상 탐색할게 없다. = 탐색이 모두 끝났다.
            if((sum + val) == target_global || (sum + val * -1) == target_global) {
                count = count + 1;
            }
            return;
        } else {
            // + 인 CASE
            dfs(index, (sum + val));
            // - 인 CASE
            dfs(index, (sum + (val * -1)));
        }
    }
}
