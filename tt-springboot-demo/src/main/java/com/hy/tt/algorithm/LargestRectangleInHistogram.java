package com.hy.tt.algorithm;

import java.util.Stack;

/**
 * @author thy
 * @date 2020/8/17
 */
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] height = { 2, 1, 5, 6, 2, 3 };
        int maxRectangle = getMaxRectangle(height);
        System.out.println(maxRectangle);
    }

    private static int getMaxRectangle(int[] height){
        if(height == null || height.length == 0){
            return 0;
        }
        int area = 0;
        Stack<Integer> stack = new Stack<> ();
        for (int i = 0; i < height.length; i++) {
            if(stack.empty() || height[stack.peek()] <= height[i]){
                stack.push(i);
            }else{
                int h = stack.pop();
                int w = stack.empty() ? i : i-stack.peek()- 1;
                area = Math.max(area,height[h]*w);
                i--;
            }
        }

        while (!stack.isEmpty()){
            int h = stack.pop();
            int w = stack.isEmpty() ? height.length : height.length - stack.peek() - 1;
            area = Math.max(area,height[h]*w);
        }

        return area;
    }
}
