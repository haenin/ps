import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> countType = new HashMap<>();
        
        for (String[] cloth : clothes) {
            String type = cloth[1];
            countType.put(type, countType.getOrDefault(type, 0) + 1);
        }
        
        int answer = 1;
        for (int count : countType.values()) {
            answer *= (count + 1);
        }
        
        return answer - 1;
    }
}