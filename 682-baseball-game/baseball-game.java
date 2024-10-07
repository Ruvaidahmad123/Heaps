class Solution {
    public static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public int calPoints(String[] operations) {
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<operations.length;i++){
            if(isInteger(operations[i])){
                st.push(Integer.parseInt(operations[i]));
            }
            else if(operations[i].equals("D")){
                int peek=st.peek();
                st.push(peek*2);
            }
            else if(operations[i].equals("C")){
                st.pop();
            }
            else{
                int peek1=0;
                int peek2=0;
                if(!st.isEmpty())
                peek1=st.pop();
                if(!st.isEmpty())
                peek2=st.pop();
                st.push(peek2);
                st.push(peek1);
                st.push(peek1+peek2);
            }
        }
        int ans=0;
        while(!st.isEmpty()){
            ans+=st.pop();
        }
        return ans;
    }
}