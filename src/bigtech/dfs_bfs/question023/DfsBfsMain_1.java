package bigtech.dfs_bfs.question023;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

// 문제023 연결 요소의 개수 구하기(내가 직접 풀고 있는 중)
public class DfsBfsMain_1 {
	// 인접 리스트로 그래프 표현
	static ArrayList<Integer>[] graph;
	
	// 방문 배열 초기화(전역변수이기에 false로 초기화 됨)
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int node = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		
		// (index = 0) 제외, node의 개수만큼 visited 배열 사이즈 설정
		visited = new boolean[node + 1];
		// (index = 0) 제외, node의 개수만큼 graph 배열 사이즈 설정
		graph = new ArrayList[node + 1];
		
		// 이거 안 해주면 nullException 발생함
		for(int i = 1; i < node + 1; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		// 간선의 양 끝점 u와 v
		for(int i = 1; i <= edge; i++) {
			// 둘째 줄부터 M개의 줄에 간선의 양 끝점 입력받기
			st = new StringTokenizer(br.readLine());
			// 끝점 u
			int u = Integer.parseInt(st.nextToken());
			// 끝점 v
			int v = Integer.parseInt(st.nextToken());
			
			// 방향이 없는 그래프라고 했으므로 (u-v), (v-u) 방식으로 연결해줘야 한다.
			/*
			 * 간선의 양 끝점이 (1, 2) 라고 했을 때 이를 그림으로 나타내면 다음과 같다.	===> 1 - 2
			 * 하지만 이것을 반대로 보면 2 또한 1과 연결돼 있는 것이다.				===> 2 - 1
			 * 1의 입장에서 봤으면, 2의 입장에서도 봐야한다는 의미 = u의 입장에서 봤으면, v의 입장에서도 봐야한다는 의미
			 */
			graph[u].add(v);
			graph[v].add(u);
		}
		
		for(ArrayList<Integer> tmp : graph) {
			System.out.println(tmp);
		}
		
		// 최종 결과값(연결 요소의 개수)
		int count = 0;
		
		// 방문 배열로 탐색 시작
		for(int i = 1; i < visited.length; i++) {
			// 탐색이 끝난 노드는 dfs 함수 호출 x = 탐색하지 않는다. 
			if(!visited[i]) {
				dfs(i);
				// 해당 if 문에 들어왔다는 것은 연결 요소가 어쨌든 1개 있다는 의미이므로 +1 을 한다.
				count += 1;
			}
		}
		
		System.out.println("count : " + count);
	}
	
	// 재귀함수
	private static void dfs(int i) {
		if(visited[i]) {
			return; // 탐색이 끝난 노드는 밑의 코드 실행 x = 탐색 x
		}
		// 탐색이 끝난 노드는 true 처리
		visited[i] = true;
		
		ArrayList<Integer> tl = graph[i];
		
		for(int num : tl) {
			// 탐색이 끝나지 않은 노드만 다시 탐색 시작
			if(!visited[num]) {
				dfs(num);
			}
		}
	}
}
/*
6 5
1 2
2 5
5 1
3 4
4 6
*/

/*
6 8
1 2
2 5
5 1
3 4
4 6
5 4
2 4
2 3
*/