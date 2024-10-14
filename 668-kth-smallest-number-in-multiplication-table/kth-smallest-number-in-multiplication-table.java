class Pair{
    int val;
    int row;
    int col;
    Pair(int val,int r,int c){
        this.val=val;
        this.row=r;
        this.col=c;
    }
}
class Solution {
    public int findKthNumber(int m, int n, int k) {
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->{
            return a.val-b.val;
        });
        for(int row=1;row<=Math.min(m,k);row++){
            pq.offer(new Pair(row,row,1));
        }
        int ans=-1;
        for(int i=1;i<=k;i++){
            Pair top=pq.poll();
            ans=top.val;
            int row=top.row;
            int col=top.col;
            if(col+1<=n){
                pq.offer(new Pair((row*(col+1)),row,col+1));
            }
        }
        return ans;
    }
}


class Solution {
    public int countLessEqual(int m, int n, int target) {
        int count = 0;
        // Iterate through each row and count how many elements <= target
        for (int i = 1; i <= m; i++) {
            count += Math.min(n, target / i);
        }
        return count;
    }

    public int findKthNumber(int m, int n, int k) {
        int low = 1, high = m * n;

        while (low < high) {
            int mid = low + (high - low) / 2;
            // If the number of elements <= mid is less than k, search on the right half
            if (countLessEqual(m, n, mid) < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low; // 'low' will be the kth smallest element
    }
}
