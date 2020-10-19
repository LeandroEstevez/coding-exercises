/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coding.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author leandroestevez
 */
public class CodingExercises {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int[] number = {9, 9};
        
        int[] result = plusOne(number);
        
        for(int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        
    }
    
    /**
     * Remove duplicates from sorted array
     * @param nums
     * @return length of the array without duplicates
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[j] != nums[i]) {
                nums[j + 1] = nums[i];
                j++;
            }
        }
        return j + 1;   
    }
    
    /**
     * 26 / 35 test cases passed by leetCode
     * Rotate the array to the right by k steps
     * @param nums
     * @param k 
     */
    public static void rotate(int[] nums, int k) {
        
        int step = nums.length - k;
        int loopLimit = 0;
        int temp;
        int j = 0;
        
        while(step < nums.length) {
            
            for(int i = step - 1; i >= loopLimit; i--) {
            
                temp = nums[step];
                nums[step] = nums[i];
                nums[i] = temp;

                step--;
            }
            
            j++;
            loopLimit++;
            step = (nums.length - k) + j;
        }
        
    }
    
    /**
     * Check if an array contains duplicates
     * @param nums
     * @return 
     */
    public static boolean containsDuplicate(int[] nums) {
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 1; i++) {
            
            if(nums[i] == nums[i + 1]) {
                
                return true;
                
            }
            
        }
        
        return false;
        
    }
    
    /**
     * Given a non-empty array of integers, 
     * every element appears twice except for one. Find that single one.
     * @param nums
     * @return 
     */
    public static int singleNumber(int[] nums) {
        
        Arrays.sort(nums);
        
        int i;
        
        for(i = 0; i < nums.length - 1; i++) {
            
            if(nums[i] != nums[i + 1]) {
                
                break;
                
            }
            
            i++;
            
        }
        
        return nums[i];
        
    }
    
    /**
     * Given two arrays, it compute their intersection
     * @param nums1 array number one
     * @param nums2 array number two
     * @return intersection of the two arrays
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        
        int l = 0;
        
        Map<Integer, Integer> arrNums1 = new TreeMap<>();
            
        for (int i = 0; i < nums1.length; i++) {

            if (arrNums1.get(nums1[i]) == null) {

                arrNums1.put(nums1[i], 1);

            } else {

                arrNums1.put(nums1[i], arrNums1.get(nums1[i]) + 1);

            }

        }
        
        List<Integer> intersections = new ArrayList<>();
        
        Arrays.sort(nums2);
        
        int nums1Reps = 0;
        int nums2Reps = 0;
        int lastOneDone = 0;
        
        for(int i = 0; i < nums2.length; i++) {
            
            if(arrNums1.get(nums2[i]) != null) {
                        
                if(!intersections.contains(nums2[i])) {
                    
                    intersections.add(nums2[i]);
                   
                    if(intersections.size() != 1) {
                       
                       if(nums1Reps < nums2Reps ) {
                           arrNums1.put(lastOneDone, nums1Reps);
                           l = l + nums1Reps;
                       } else {
                           arrNums1.put(lastOneDone, nums2Reps);
                           l = l + nums2Reps;
                       }
                       
                    }
                   
                    nums1Reps = arrNums1.get(nums2[i]);
                    nums2Reps = 0;
                   
                    lastOneDone = nums2[i];

                }
                
                arrNums1.put(nums2[i], arrNums1.get(nums2[i]) + 1);
                nums2Reps++;
                
            }
            
            if(i == nums2.length - 1) {
                if(nums1Reps < nums2Reps ) {
                    arrNums1.put(lastOneDone, nums1Reps);
                    l = l + nums1Reps;
                } else {
                    arrNums1.put(lastOneDone, nums2Reps);
                    l = l + nums2Reps;
                }
            }
            
        }
        
        int[] result = new int[l];
        int o = 0;
        
        for(int i = 0; i < intersections.size(); i++) {
            
            for(int j = 0; j < arrNums1.get(intersections.get(i)); j++) {
                
                result[o] = intersections.get(i);
                o++;
                
            }
            
        }
        
        return result;
        
    }
    
    /**
     * Given a non-empty array of digits representing a non-negative integer, 
     * increment one to the integer.
     * @param digits array of digits
     * @return result of sum by one
     */
    public static int[] plusOne(int[] digits) {
        
        int[] result;

        for(int i = digits.length - 1; i >= 0; i--) {
            
            if(digits[i] == 9) {
                
                if(i == 0) {
                    digits[i] = 0;
                    result = new int[digits.length + 1];
                    result[0] = 1;
                    System.arraycopy(digits, 0, result, 1, digits.length);
                    
                    return result;
                }
                
                if(digits.length == 1) {
                    
                    result = new int[2];
                    result[0] = 1;
                    result[1] = 0;
                    
                    return result;
                    
                } else {
                    
                    digits[i] = 0;
                    
                }
                
            } else {
                
                digits[i] = digits[i] + 1;
                
                break;
                
            }
            
        }
        
        return digits;
        
    }
    
}
