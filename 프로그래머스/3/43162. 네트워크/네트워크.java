class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for(int i =0; i < n; i++){
            if(!visited[i]){
                dfs(computers, visited, i);
                answer++;
            }
        }
        return answer;
    }
    
    private void dfs(int[][] computers, boolean[] visited, int node) {
        visited[node] = true;
        for(int j = 0; j < computers.length; j ++){
            if(!visited[j] && computers[node][j] == 1){
                dfs(computers, visited, j);
            }
        }
    }
}