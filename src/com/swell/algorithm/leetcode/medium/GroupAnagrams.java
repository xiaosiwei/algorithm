package com.swell.algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaosiwei on 16/7/14.
 * Refer to : https://leetcode.com/problems/anagrams/
 */
public class GroupAnagrams {
    Map<String, List<String>> map = new HashMap<String, List<String>>();

    public List<List<String>> groupAnagrams(String[] strs) {
        map.clear();
        for (int i = 0;i < strs.length;i++) {
            List<Integer> count = countNum(strs[i]);
            String minShow = getMinShow(count);

            List<String> tmpList = null;
            if (map.containsKey(minShow)) {
                tmpList = map.get(minShow);
            } else {
                tmpList = new ArrayList<String>();
            }

            tmpList.add(strs[i]);
            map.put(minShow, tmpList);
        }

        List<List<String>> result = new ArrayList<List<String>>();
        for (String key : map.keySet()) {
            List<String> tmpResult = map.get(key);
            result.add(tmpResult);
        }

        return result;
    }

    private String getMinShow(List<Integer> count) {
        StringBuilder result = new StringBuilder("");
        for (int i = 0;i < count.size();i++) {
            int length = count.get(i);
            while (length > 0) {
                result.append((char) ('a' + i));
                length--;
            }
        }
        return result.toString();
    }

    private List<Integer> countNum (String str) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0;i < 26;i++)  result.add(0);
        for (int i = 0;i < str.length();i++) {
            int value = Integer.valueOf(str.charAt(i)-'a');
            result.set(value, result.get(value)+1);
        }
        return result;
    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams.groupAnagrams(strs));
    }
}
