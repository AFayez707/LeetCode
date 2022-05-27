package Amazon_OA.Finding_All_Combination_Of_Numbers_Sum_To_Target;

//Given a positive number, find out all combinations of positive numbers that adds up to that number.
// The program should print only combinations, not permutations. For example, for input 3, either 1, 2 or 2, 1 should be printed.

import java.util.ArrayList;
import java.util.List;

//        For example,
//        For n = 5, the following combinations are possible:
//
//        { 5 }
//        { 1, 4 }
//        { 2, 3 }
//        { 1, 1, 3 }
//        { 1, 2, 2 }
//        { 1, 1, 1, 2 }
//        { 1, 1, 1, 1, 1 }
//
//        For n = 4, the following combinations are possible:
//
//        { 4 }
//        { 1, 3 }
//        { 2, 2 }
//        { 1, 1, 2 }
//        { 1, 1, 1, 1 }
public class Solution {
    static ArrayList<ArrayList<Integer>> print_all_sum(int target) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        print_all_sum_rec(target, 0, 1, output, result);
        return output;
    }

    static void print_all_sum_rec(int target, int currentSum, int start,
                                  ArrayList<ArrayList<Integer>> output, ArrayList<Integer> result) {
        if (target == currentSum)
            output.add((ArrayList)result.clone());

        for (int i = start; i < target; ++i) {
            int tempSum = currentSum + i;
            if (tempSum <= target) {
                result.add(i);
                print_all_sum_rec(target, tempSum, i, output, result);
                result.remove(result.size() - 1);
            } else {
                return;
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        ArrayList<ArrayList<Integer>> result = print_all_sum(n);
        print(result);
    }

    static void print(ArrayList<ArrayList<Integer>> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.print("[");
            for (int j = 0; j < arr.get(i).size(); j++) {
                System.out.print(arr.get(i).get(j) + ", ");
            }
            System.out.println("]");
        }
    }

//    Explanation: https://www.educative.io/m/find-all-sum-combinations

}
