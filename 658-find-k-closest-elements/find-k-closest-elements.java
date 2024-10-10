class Pair{
    int diff;
    int val;
    Pair(int diff,int val){
        this.diff=diff;
        this.val=val;
    }
}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->{
            if(a.diff!=b.diff){
                return Integer.compare(b.diff,a.diff);
            }
            else{
                return Integer.compare(b.val,a.val);
            }
        });
        for(int i=0;i<arr.length;i++){
            pq.add(new Pair(Math.abs(arr[i]-x),arr[i]));
            if(pq.size()>k){
                pq.poll();
            }
        }
        List<Integer>ans=new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.poll().val);
        }
        Collections.sort(ans);
        return ans;
    }
}


class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer>ans=new ArrayList<>();
        int i=findfloor(arr,x);
        int j=i+1;
        while(j<arr.length && i>=0 && k>0){
            if(Math.abs(x-arr[i])<=Math.abs(x-arr[j])){
                ans.add(arr[i]);
                i--;
            }
            else{
                ans.add(arr[j]);
                j++;
            }
            k--;
        }
        while(j<arr.length && k>0){
            ans.add(arr[j]);
            j++;
            k--;
        }
        while(i>=0 && k>0){
            ans.add(arr[i]);
            i--;
            k--;
        }
        Collections.sort(ans);
        return ans;
    }
    public int findfloor(int arr[],int x){
        int low=0;
        int high=arr.length-1;
        int ans=0;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==x){
                return mid;
            }
            if(arr[mid]<x){
                ans=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
}

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - k;
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {   //mid starting of window    
                                                        //mid+k first index after ending or window
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
