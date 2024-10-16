class Pair{
    int val1;
    int val2;
    Pair(int val1, int val2){
        this.val1=val1;
        this.val2=val2;
    }
}
class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        ArrayList<Pair>list=new ArrayList<>();
        for(int i=0;i<nums1.length;i++){
            list.add(new Pair(nums1[i],nums2[i]));
        }
        list.sort((p1,p2)->{
            return p2.val2-p1.val2;
        });
        long sum=0;
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        for(int i=0;i<k;i++){
            sum+=list.get(i).val1;
            pq.offer(list.get(i).val1);
        }
        long result=sum*list.get(k-1).val2;
        for(int i=k;i<nums1.length;i++){
            sum+=list.get(i).val1-pq.poll();
            pq.offer(list.get(i).val1);
            result=Math.max(result,sum*list.get(i).val2);
        }
        return result;
    }
}