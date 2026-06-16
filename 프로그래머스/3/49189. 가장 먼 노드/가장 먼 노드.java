import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        // 1. 그래프 초기화 (인접 리스트)
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 2. 간선 정보 입력 (양방향)
        for (int[] e : edge) {
            int a = e[0], b = e[1];
            graph[a].add(b);
            graph[b].add(a);
        }

        // 3. BFS 준비
        int[] dist = new int[n + 1];   // 거리 기록
        Arrays.fill(dist, -1);         // -1 = 아직 방문 안 함
        Queue<Integer> q = new ArrayDeque<>();

        // 시작은 1번 노드
        q.offer(1);
        dist[1] = 0;

        // 4. BFS 실행
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nxt : graph[cur]) {
                if (dist[nxt] != -1) continue; // 이미 방문
                dist[nxt] = dist[cur] + 1;     // 거리 갱신
                q.offer(nxt);
            }
        }

        // 5. 최대 거리 찾기
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dist[i]);
        }

        // 6. 최대 거리를 가진 노드 개수 세기
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == max) count++;
        }

        return count;
    }
}