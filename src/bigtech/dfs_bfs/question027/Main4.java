package bigtech.dfs_bfs.question027;

import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 문제027. 미로 탐색하기(2178) - 해답지 보고 작성
public class Main4 {
	// 상하좌우 탐색을 위한 배열
	static int[] dx = {0, 1, 0, -1};
	// 상하좌우 탐색을 위한 배열
	static int[] dy = {1, 0, -1, 0};
	// 방문 배열
	static boolean[][] visited;
	// 이차원 배열(미로)
	static int [][]A;
	// 첫째 줄에 두 정수 입력값
	static int N, M;
	// 탐색 깊이
	static int depth= 1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		A = new int[N][M];
		visited = new boolean[N][M];
		
		// 이차원 배열 생성
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for(int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(line.substring(j, j + 1));
			}
		}
		
		bfs(0, 0);
		/**
		 * 깊이 업데이트를 하다보면 결국에는 (N, M)의 위치로 도달할 것
		 * 그때 해당 깊이 값을 출력하기 위해 아래와 같은 코드 작성
		 * A[N][M]는 indexoutofboundsexception 발생
		 */
		System.out.println(A[N - 1][M - 1]);
		System.out.printf("depth : %d", depth);
		// 4 6
		// A[4 - 1][6 - 1] => A[3][5]
	}
	
	static void bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		// 탐색 할 노드
		queue.offer(new int[]{i, j});
		// 해당 노드 방문 여부 true 로 변경
		visited[i][j] = true;
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for(int k = 0; k < 4; k++) {
				int x = now[0] + dx[k];
				int y = now[1] + dy[k];
				 System.out.printf("x: %d, y: %d \n", x, y);
				if(x >= 0 && y >= 0 && x < N && y < M) {	// 좌표 유효성 검사
					if(A[x][y] > 0 && !visited[x][y]) {		// 이동할 수 있는 칸 && 방문하지 않았다면
						visited[x][y] = true;				// 해당 노드 방문 여부 true 로 변경
						A[x][y] = A[now[0]][now[1]] + 1;	// 깊이 업데이트
						
						/**
						 * 해당 if 문 구절에 들어왔다는 것은
						 * - 이동할 수 있는 칸(=1) 이라는 의미
						 * - 어차피 0 이상이면 이동할 수 있는 칸을 의미하는 것이므로
						 * - 깊이 값을 이런 방식으로 업데이트 하는 듯
						 */
						queue.offer(new int[]{x, y});
						depth += 1;
					}
				}
			}
		}
	}
}