class Solution1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums1.length];

        for(int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }

        for(int i = 0; i < nums1.length; i++) {
            int ptr = map.get(nums1[i]);

            while(nums2[ptr] <= nums1[i]) {
                ptr++;

                if(ptr == nums2.length) {
                    res[i] = -1;
                    break;
                }

                else {
                    res[i] = nums2[ptr];
                }
            }
        }

        return res;
    }
}

class Solution2 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> deque = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums1.length];

        for(int i = nums2.length - 1; i >= 0; i--) {
            int x = nums2[i];

            while(!deque.isEmpty() && deque.peekLast() <= x)
                deque.pollLast();

            map.put(nums2[i], deque.isEmpty() ? -1 : deque.peekLast());
            deque.addLast(nums2[i]);
        }

        for(int i = 0; i < nums1.length; i++)
            res[i] = map.get(nums1[i]);

        return res;
    }
}
