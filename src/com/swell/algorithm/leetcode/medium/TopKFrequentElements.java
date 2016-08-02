package com.swell.algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaosiwei on 16/8/2.
 * Refer to : https://leetcode.com/problems/top-k-frequent-elements/
 */
public class TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i <= nums.length; i++) list.add(new ArrayList<Integer>());
        for (Integer key : map.keySet()) {
            Integer value = map.get(key);
            List tmpList = list.get(value);
            tmpList.add(key);
            list.set(value, tmpList);
        }

        List<Integer> result = new ArrayList<Integer>();
        for (int i = nums.length; i > 0 && k > 0;i--) {
            List<Integer> tmpList = list.get(i);
            if (tmpList.size() > 0) {
                for (Integer num : tmpList) {
                    result.add(num);
                    k--;
                    if (k == 0) break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        System.out.println(topKFrequentElements.topKFrequent(nums, 1));
    }

}
