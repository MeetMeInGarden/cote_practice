package bigtech.dfs_bfs.question027;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

// 문제027. 미로 탐색하기(2178) - 해답지 본 후 스스로 풀어봄
// 단, A[x][y] = A[now[0]][now[1]] + 1; => 이 방법 안 씀
// depth 를 직접 구함
public class Main5 {
	// 방문 배열
	static boolean[][] visited;
	// 미로
	static int[][] maze;
	// row
	static int N;
	// col
	static int M;
	// 최종 출력 값
	static int result = 1;
	// coordinate = 좌표 => 좌표 기준 [상, 우, 하, 좌(시계 방향)]
	// x 좌표
	static int[] cx = {0, 1, 0, -1};
	// y 좌표
	static int[] cy = {1, 0, -1, 0};
	
	// 각 '칸'을 의미 
	static class Node {
		int x; // X 좌표 값
		int y; // Y 좌표 값
		int d; // depth
		
		public Node(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
		
		public int getX() {
			return this.x;
		}
		
		public int getY() {
			return this.y;
		}
		
		public int getD() {
			return this.d;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 방문 배열 초기화
		visited = new boolean[N][M];
		// 미로 초기화
		maze 	= new int[N][M];
		
		// 미로 배열에 값 넣기
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int j = 0;
			for(String str : st.nextToken().split("")) {
				maze[i][j] = Integer.parseInt(str);
				j += 1;
			}
		}
		
		// 넓이 탐색 시작
		bfs(0, 0, 1);
		
		// 최종 출력
		System.out.println(result);
	}
	
	public static void bfs(int x, int y, int d) {
		// 방문 처리
		visited[x][y] = true;
		
		Queue<Node> queue = new LinkedList<>();
		// (상, 우, 하, 좌)를 탐색할 기준 Node 넣기
		queue.offer(new Node(x, y, d));
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			// 탐색 종료
			if((node.getX() == N - 1) && (node.getY() == M - 1)) {
				result = node.getD();
				return;
			}
			
			for(int i = 0; i < 4; i++) {
				// (상, 우, 하, 좌) 좌표 값 구하기
				int xx = node.getX() + cx[i];
				int yy = node.getY() + cy[i];
				
				if(xx >= 0 && yy >= 0 && xx < N && yy < M) {			// 좌표 유효성 검사
					if(!visited[xx][yy] && maze[xx][yy] > 0) {			// 이동할 수 있는 칸 && 방문하지 않았다면
						visited[xx][yy] = true;							// 해당 칸으로 이동 && 방문 여부 true 처리
						queue.offer(new Node(xx, yy, node.getD() + 1));	// 바로 위에서 방문 여부 true 처리 한 칸 다시 Queue 넣기 by 그 칸을 기준으로 또 (상, 우, 하, 좌) 탐색해야 하니까
																		// node.getD() + 1 ==> depth 값 업데이트
					}
				}
			}
		}
	}
}