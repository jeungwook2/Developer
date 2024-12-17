class Solution {
    public int[] solution(int[] arr, int n) {
        int[] sortedArr = new int[arr.length];

        //정렬하기
        int diff = Integer.MAX_VALUE;
        int target = -1;
        int targetIdx = -1;
        
        for(int i=0; i < arr.length; i++) {
        	int diffTemp = Math.abs(n - arr[i]);
        	
            if(diff > diffTemp) {
            	target = arr[i];
            	targetIdx = i;
            }
        }
        
        
        
        return sortedArr;
    }
}