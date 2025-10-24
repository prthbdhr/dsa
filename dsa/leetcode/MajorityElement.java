public class MajorityElement {
    
    public int majorityElement(int[] nums) {

        int cnt = 0;

        int el = nums[0];

        for (int num: nums) {

            if (cnt == 0) {
                
                el = num;

                cnt = 1;
            }

            else if (el == num ) cnt++;

            else cnt--;
        }

        cnt = 0;

        for (int num: nums) {
            if (num == el) cnt++;
        }

        return cnt > nums.length / 2 ? el : -1;
    }
}
