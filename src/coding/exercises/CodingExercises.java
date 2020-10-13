/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coding.exercises;

import java.util.Arrays;

/**
 *
 * @author leandroestevez
 */
public class CodingExercises {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
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
    public boolean containsDuplicate(int[] nums) {
        
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
    public int singleNumber(int[] nums) {
        
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
    
}
