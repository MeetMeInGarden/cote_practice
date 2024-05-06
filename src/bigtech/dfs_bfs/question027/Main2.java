package bigtech.dfs_bfs.question027;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;

// 문제027. 미로 탐색하기(2178)
public class Main2 {
	// 그래프
	static Node[][] graph;
	// 방문
	static boolean[][] visited;
	// 이동한 칸 수
	static int step;
	// 이동한 칸을 담은 Queue
	// Queue.size()로 출력값을 하면 될 듯
	// static Queue<Node> stepQueue = new LinkedList<>();
	// row 전체 사이즈
	static int rowSize;
	// col 전체 사이즈
	static int colSize;

	// alt + shift + s
	public static class Node {
		// 0 or 1
		public int value;
		// 행(일종의 좌표 값)
		public int row;
		// 열(일종의 좌표 값)
		public int col;
		public Node(int value, int row, int col) {
			this.value 	= value;
			this.row 	= row;
			this.col 	= col;
		}
		public int getValue() {
			return value;
		}
		public int getRow() {
			return row;
		}
		public int getCol() {
			return col;
		}

	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// N, M
		String[] arr = br.readLine().split(" ");
		int N = Integer.parseInt(arr[0]);
		int M = Integer.parseInt(arr[1]);
		graph = new Node[N + 1][M];
		visited = new boolean[N + 1][M];
		rowSize = N;
		colSize = M;
		
		for(int i = 1 ; i <= N; i++) {
			int idx = 0;
			for(String tmp : br.readLine().split("")) {
				int tmpCol = Integer.parseInt(tmp);
				graph[i][idx] = new Node(tmpCol, i, tmpCol);
				idx += 1;
				// 마지막 끝 점 표시
				if(i == N && idx == M) {
					graph[i][idx - 1] = new Node(2, i, tmpCol);
				}
			}
		}
		
//		for(Node[] tmp : graph) {
//			for(Node tmp2 : tmp) {
//				if(tmp2 != null) {
//					System.out.print(tmp2.getValue());
//					System.out.print(tmp2.getRow());
//					System.out.print(tmp2.getCol());
//					System.out.println("----");
//				}
//			}
//		}
		Queue<Node> stepQueue = new LinkedList<>();
		dfs(stepQueue, 1, 0);
	}
	
	public static void dfs(Queue<Node> queue, int row, int col) {
		if(row > rowSize) {
			System.out.println("row");
			System.out.println(queue.size());
			return;
		}
		if(col >= colSize) {
			System.out.println("col");
			System.out.println(queue.size());
			return;
		}
		
		// 방문 처리
		visited[row][col] = true;
		Node node = graph[row][col];
		// 옮길 수 있는 칸
		if(node.getValue() > 0) {
			queue.offer(node);
			dfs(queue, row, col + 1);
		} else {
			dfs(queue, row + 1, col);
		}
	}
}
















