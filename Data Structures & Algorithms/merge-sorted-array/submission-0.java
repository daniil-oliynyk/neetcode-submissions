class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int last = m + n - 1;
        int i = m;
        int j = n;

        while (i > 0 && j > 0) {
            if (nums1[i-1] >= nums2[j-1]) {
                nums1[last] = nums1[i-1];
                i--;
            } else {
                nums1[last] = nums2[j-1];
                j--;
            }
            last--;

        }

        while (j > 0) {
            nums1[last] = nums2[j-1];
            j--;
            last--;

        }

    }
}

