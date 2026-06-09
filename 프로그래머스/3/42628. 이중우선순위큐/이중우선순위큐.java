import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        List<Integer> inputList = new ArrayList<>();

        for(int i = 0; i < operations.length; i++){
            String inputCheck = operations[i].split(" ")[0];
            int inputNum = Integer.parseInt(operations[i].split(" ")[1]);

            if(inputCheck.equals("I")){
                inputList.add(inputNum);
            } else if(!inputList.isEmpty()){
                Collections.sort(inputList);
                if(inputNum == 1){
                    inputList.remove(inputList.size()-1);
                } else {
                    inputList.remove(0);
                }
            }
        }

        if(inputList.isEmpty()){
            answer = new int[]{0, 0};
        } else {
            Collections.sort(inputList, Collections.reverseOrder());
            answer = new int[]{inputList.get(0), inputList.get(inputList.size()-1)};
        }

        return answer;
    }
}