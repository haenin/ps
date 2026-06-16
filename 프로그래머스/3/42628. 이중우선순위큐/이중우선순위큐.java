import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        HashSet<Integer> set = new HashSet<>(); 

        for(String op : operations){
            String cmd = op.split(" ")[0];
            int num = Integer.parseInt(op.split(" ")[1]);

            if(cmd.equals("I")){
                minQ.offer(num);
                maxQ.offer(num);
                set.add(num);
            } else if(!set.isEmpty()){
                if(num == 1){
                    int removed = maxQ.poll();
                    set.remove(removed);
                } else {
                    int removed = minQ.poll();
                    set.remove(removed);
                }
                while(!maxQ.isEmpty() && !set.contains(maxQ.peek())) maxQ.poll();
                while(!minQ.isEmpty() && !set.contains(minQ.peek())) minQ.poll();
            }
        }

        if(set.isEmpty()){
            return new int[]{0, 0};
        }
        return new int[]{maxQ.peek(), minQ.peek()};
    }
}