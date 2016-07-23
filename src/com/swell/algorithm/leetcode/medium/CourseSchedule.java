package com.swell.algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiaosiwei on 16/7/23.
 * Refer to : https://leetcode.com/problems/course-schedule/
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        boolean[] used = new boolean[numCourses];
        List<List> graph = new ArrayList<List>();

        for (int i = 0;i < numCourses;i++) {
            inDegree[i] = 0;
            used[i] = false;
            graph.add(new LinkedList());
        }

        for (int i = 0;i < prerequisites.length;i++) {
            int from = prerequisites[i][0];
            int to = prerequisites[i][1];
            LinkedList<Integer> list = (LinkedList) graph.get(from);
            list.add(to);
        }

        for (int i = 0;i < numCourses;i++) {
            LinkedList<Integer> list = (LinkedList) graph.get(i);
            for (Integer to : list) {
                inDegree[to]++;
            }
        }

        int loops = numCourses;
        while (loops > 0) {
            for (int i = 0;i < numCourses;i++) {
                if (inDegree[i] == 0 && !used[i]) {
                    used[i] = true;
                    LinkedList<Integer> list = (LinkedList) graph.get(i);
                    for (Integer to : list) {
                        inDegree[to]--;
                    }
                }
            }
            loops--;
        }

        for (int i = 0;i < numCourses;i++) {
            if (inDegree[i] > 0)    return false;
        }

        return true;
    }

    public static void main(String[] args) {
        CourseSchedule courseSchedule = new CourseSchedule();
        int[][] req = new int[][]{{1,0}};
        courseSchedule.canFinish(2,req);
    }
}
