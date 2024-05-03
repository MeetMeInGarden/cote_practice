package bigtech.dfs_bfs.question026;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Collections;

// 문제026. DFS와 BFS 프로그램(1260)
public class Main {
	// 인접리스트
	static ArrayList<Integer>[] list;
	
	// 방문 배열 dfs
	static boolean[] visited_dfs;
	
	// 방문 배열 bfs
	static boolean[] visited_bfs;
	
	// 방문 배열 Queue
	static Queue<Integer> queue = new LinkedList<>();
	
	// dfs 탐색 순서
	static ArrayList<Integer> dfs_search = new ArrayList<>();
	
	// bfs 탐색 순서
	static ArrayList<Integer> bfs_search = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 첫 번째 줄 입력
		String[] arr = br.readLine().split(" ");
		
		// 정점의 개수
		int node = Integer.parseInt(arr[0]);
		// 간선의 개수
		int edge = Integer.parseInt(arr[1]);
		// 시작 정점
		int strt = Integer.parseInt(arr[2]);
		
		// dfs 방문 배열 초기화
		visited_dfs = new boolean[node + 1];
		
		// bfs 방문 배열 초기화
		visited_bfs = new boolean[node + 1];
		
		// 인접리스트 초기화
		list = new ArrayList[node + 1];
		for(int i = 1; i <= node; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		// 인접리스트 그래프 표현
		for(int i = 1; i <= edge; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int secon = Integer.parseInt(st.nextToken());
			// 양방향이므로 아래와 같이 정점을 연결
			list[first].add(secon);
			list[secon].add(first);
		}
		
		// 정렬 for 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문
		for (int i = 1; i < list.length; i++) {
			Collections.sort(list[i]);
		}
		
		dfs(strt);
		bfs(strt);
		
		StringBuilder dfsResult = new StringBuilder();
		for(int i = 0; i < dfs_search.size(); i++) {
			dfsResult.append(dfs_search.get(i));
			if(i < dfs_search.size() - 1) {
				dfsResult.append(" ");	
			}
		}
		
		StringBuilder bfsResult = new StringBuilder();
		for(int i = 0; i < bfs_search.size(); i++) {
			bfsResult.append(bfs_search.get(i));
			if(i < bfs_search.size() - 1) {
				bfsResult.append(" ");	
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(dfsResult.toString());
		bw.newLine();
		bw.write(bfsResult.toString());
		
		bw.flush(); // 남아있는 데이터를 모두 출력시킴
		bw.close();
	}
	
	public static void dfs(int node) {
		if(visited_dfs[node]) {
			return; // 방문했으면 return;
		}
		
		// 방문처리
		visited_dfs[node] = true;
		dfs_search.add(node);
		
		ArrayList<Integer> tmpList = list[node];
		
		for(int tmpNum : tmpList) {
			if(!visited_dfs[tmpNum]) {
				dfs(tmpNum);
			}
		}
		
	}
	public static void bfs(int node) {
		if(visited_bfs[node]) {
			return; // 방문했으면 return
		}
		
		// 방문처리
		visited_bfs[node] = true;
		queue.offer(node);
		bfs_search.add(node);
		
		ArrayList<Integer> tmpList = list[node];
		
		for(int tmpNum : tmpList) {
			if(!visited_bfs[tmpNum]) {
				queue.offer(tmpNum);	
			}
			if(!queue.isEmpty()) {
				bfs(queue.remove());
			}
		}
	}
}