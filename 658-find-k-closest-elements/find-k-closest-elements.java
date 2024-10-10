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