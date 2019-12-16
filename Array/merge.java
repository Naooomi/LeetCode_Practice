package Array;

/**
	Description:
	Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 */

public class merge {
    public void solution(int[] nums1, int m, int[] nums2, int n) {

        // insert from the m+n-1 position at the bigger array
        // keep 3 pointers: one at the insertion point
        // one at the end of nums1; one at the end of nums2
        int insertP = m + n -1;
        int nums1P = m - 1;
        int nums2P = n - 1;

        while (nums1P >= 0 && nums2P >= 0) {
            if (nums1[nums1P] > nums2[nums2P]) {
                nums1[insertP--] = nums1[nums1P--];
            } else {
                nums1[insertP--] = nums2[nums2P--];
            }
        }
        while (nums2P >= 0) {
            nums1[insertP--] = nums2[nums2P--];
        }
    }
}
