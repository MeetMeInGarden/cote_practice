package bigtech.dfs_bfs.question023;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

// ====================== [정답] ======================
// 문제023 연결 요소의 개수 구하기(내가 직접 풀고 있는 중)
// 이미 난 이 문제에 찌들었어...
// 이제는 안 보고도 풀 수 있을 정도야
public class DfsBfsMain_2 {
	static ArrayList<Integer>[] graph;
	static boolean[] visit;
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 정점
		int node = Integer.parseInt(st.nextToken());
		// 간선
		int edge = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[node + 1];
		visit = new boolean[node + 1];
		
		for(int i = 1; i < graph.length; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		for(int i = 1; i <= edge; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			graph[v].add(u);
			graph[u].add(v);
		}
		
		for(int i = 1; i <= node; i++) {
			if(visit[i]) {
				continue;
			} else {
				count += 1;
				dfs(i);	
			}
		}
		
		System.out.println("count : " + count);
	}
	
	static void dfs(int num) {
		if(visit[num]) {
			return;
		}
		visit[num] = true;
		ArrayList<Integer> tmp = graph[num];
		
		for(int itg : tmp) {
			if(visit[itg]) {
				continue;
			} else {
				dfs(itg);
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