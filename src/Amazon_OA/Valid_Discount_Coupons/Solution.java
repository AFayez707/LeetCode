package Amazon_OA.Valid_Discount_Coupons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
//    Link: https://cybergeeksquad.co/2022/02/valid-discount-coupons-amazon-oa.html
//    Link: https://leetcode.com/discuss/interview-question/1557009/Amazon-or-OA-or-Valid-string
//    Time: O(N * K)
//    Space: O(K)

    public List<Integer> findValidCoupons(List<String> discountCoupons) {
        List<Integer> result = new ArrayList<>(discountCoupons.size());
        for(String coupon : discountCoupons)
            result.add(checkValidCoupon(coupon));
        return result;
    }

    private Integer checkValidCoupon(String couponCode) {
        Stack<Character> stack = new Stack<>();
        for(char c : couponCode.toCharArray()) {
            if(stack.empty()) {
                stack.push(c);
            } else if(stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().findValidCoupons(Arrays.asList("", "vv", "xbbx", "bbccdd", "xyffyxdd")));
        System.out.println(new Solution().findValidCoupons(Arrays.asList("xyx", "yx", "y", "xxxyyxx")));
    }
}
