package bigtech.dfs_bfs.question023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

// 문제023 연결 요소의 개수 구하기
public class DfsBfsMain {
	// 1. 인접 리스트로 그래프 표현
	static ArrayList<Integer>[] A;
	// 2. 방문 배열 초기화
	static boolean visited[];
	
	// 3. 스택에 시작 노트 삽입
	// TODO
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 노드 개수
		int node = Integer.parseInt(st.nextToken());
		// 엣지 개수
		int edge = Integer.parseInt(st.nextToken());
		
		A = new ArrayList[node + 1];
		visited = new boolean[node + 1];
		
		for(int i = 1; i < node + 1; i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			A[s].add(e);
			A[e].add(s);
		}
		
		int count = 0;
		for(int i = 1; i < node + 1; i ++) {
			if(!visited[i]) {
				count++;
				DFS(i);
			}
		}
		
		System.out.println("count : " + count);
		
		
	}
	
	private static void DFS(int num) {
		if(visited[num]) {
			return;
		}
		visited[num] = true;
		for(int i : A[num]) {
			if(visited[i] == false) {
				System.out.println("i : " + i);
				DFS(i); // 재귀함수
			}
		}
		
	}
	// 꺼낸 노드를 탐색 순서에 기입한다. ==> 적어도 이 문제에서는 무시해도 될 듯
	// 꺼낸 노드의 인접 노드를 스택에 삽입하며 이를 방문 배열에 체크한다.
	// 스택에 삽입할 때 방문 배열과 대조해 이미 방문한 노드는 또 삽입(방문)하지 않게 주의
}

/*
 *
6 5
1 2
2 5
5 1
3 4
4 6
 *
 */

/*
 *
6 8
1 2
2 5
5 1
3 4
4 6
5 4
2 4
2 3
 *
 */

/*
 *
1 - 2, 5
2 - 1, 5
3 - 4
4 - 3, 6
5 - 2, 1
6 - 4
 *
 */











