package bigtech.dfs_bfs.question027;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

// 문제027. 미로 탐색하기(2178) - 시도3
public class Main3 {
	// 그래프
	static ArrayList<Integer>[][] graph;
	// 방문
	static boolean[][] visited;
	// 이동한 칸 수
	static int step;
	// row 전체 사이즈
	static int rowSize;
	// col 전체 사이즈
	static int colSize;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// N, M
		String[] arr = br.readLine().split(" ");
		// 노드개수라고 생각하자
		int N = Integer.parseInt(arr[0]);
		int M = Integer.parseInt(arr[1]);
		graph = new ArrayList[N + 1][M + 1];
		visited = new boolean[N][M];
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				graph[i][j] = new ArrayList<Integer>();
			}
		}
		
		
		for(int i = 1 ; i <= N; i++) {
			int idx = 1;
			for(String tmp : br.readLine().split("")) {
				graph[i][idx].add(Integer.parseInt(tmp));
				graph[idx][i].add(Integer.parseInt(tmp));
				idx += 1;
			}
		}
		
		for(ArrayList<Integer>[] tmp : graph) {
			for(ArrayList<Integer> tmp2 : tmp) {
				System.out.println(tmp2);
			}
		}
//		 dfs(1, 0);
	}
	
//	public static void dfs(int row, int col) {
//		if(row > rowSize) {
//			return;
//		}
//		if(col >= colSize) {
//			return;
//		}
//		Queue<String> queue = new LinkedList<>();
//		String flag = graph[row][col];
//		if("0".equals(flag)) {
//			return;
//		} else {
//			queue.offer(flag);	
//		}
//		
//		for(int i = row; i <= rowSize; i++) {
//			
//		}
//		
//		for(int i = col; i < colSize; i++) {
//			
//		}
//	}
}
















