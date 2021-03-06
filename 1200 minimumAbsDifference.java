class Solution1 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        int n = arr.length;
        Arrays.sort(arr);
        int min = arr[1] - arr[0];
        List<Integer> cur = new ArrayList<>();
        cur.add(arr[0]);
        cur.add(arr[1]);
        res.add(cur);

        for(int i = 1; i < n - 1; i++) {
            int curMin = arr[i + 1] - arr[i];
            if(curMin == min) {
                cur = new ArrayList<>();
                cur.add(arr[i]);
                cur.add(arr[i + 1]);
                res.add(cur);
            }

            if(curMin < min) {
                min = curMin;
                res = new ArrayList<>();
                cur = new ArrayList<>();
                cur.add(arr[i]);
                cur.add(arr[i + 1]);
                res.add(cur);
            }
        }

        return res;
    }
}

class Solution2 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            if(diff < min) {
                min = diff;
                ans = new ArrayList<>();
            }

            if(diff == min) {
                List<Integer> cur = new ArrayList<>();
                cur.add(arr[i]);
                cur.add(arr[i + 1]);
                ans.add(cur);
            }
                
        }

        return ans;
    }
}
