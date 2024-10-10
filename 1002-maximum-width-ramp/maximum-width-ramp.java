class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<nums.length;i++){
            if(st.isEmpty()|| nums[i]<nums[st.peek()]){
                st.push(i);
            }
        }
        int max=0;
        for(int j=nums.length-1;j>=0;j--){
            while(!st.isEmpty() && nums[j]>=nums[st.peek()]){
                max=Math.max(max,j-st.peek());
                st.pop();
            }
        }
        return max;
    }
} 