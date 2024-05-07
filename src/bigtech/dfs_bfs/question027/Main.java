package bigtech.dfs_bfs.question027;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;

// 문제027. 미로 탐색하기(2178) - 시도1
public class Main {
	// 그래프
	static String[][] graph;
	// 이동한 칸 수
	static int step;
	// row 전체 사이즈
	static int rowSize;
	// col 전체 사이즈
	static int colSize;
	
	public class Node {
		// 0 or 1
		public boolean value;
		// 행
		public int row;
		// 열
		public int col;
		
		public Node(boolean value, int row, int col) {
			this.value 	= value;
			this.row 	= row;
			this.col 	= col;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// N, M
		String[] arr = br.readLine().split(" ");
		int N = Integer.parseInt(arr[0]);
		int M = Integer.parseInt(arr[1]);
		graph = new String[N + 1][M];
		rowSize = N;
		colSize = M;
		
		System.out.println("=================== 1");
		
		for(int i = 1 ; i <= N; i++) {
			String tmp = br.readLine();
			graph[i] = tmp.split("");
//			if(i == N) {
//				// (N, M)의 위치 표시
//				graph[i][graph[i].length - 1] = "2";
//			}
		}
		dfs(1, 0);
	}
	
	public static void dfs(int row, int col) {
		if(row > rowSize) {
			return;
		}
		if(col >= colSize) {
			return;
		}
		Queue<String> queue = new LinkedList<>();
		String flag = graph[row][col];
		if("0".equals(flag)) {
			return;
		} else {
			queue.offer(flag);	
		}
		
		for(int i = row; i <= rowSize; i++) {
			
		}
		
		for(int i = col; i < colSize; i++) {
			
		}
	}
}
















