class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> sample=new Stack<>();
        for(String operation : operations) {
            if(operation.equals("D")) {
                sample.push(sample.peek()*2);
            } else if(operation.equals("C")) {
                sample.pop();
            }else if(operation.equals("+")) {
                Integer temp = sample.pop();
                Integer last= sample.peek();
                sample.push(temp);
                sample.push(last+temp);
            } else {
                sample.push(Integer.valueOf(operation));
            }
        }
        int sum = 0;
        while(!sample.isEmpty()) {
            sum += sample.pop();
        }
        return sum;
    }
}