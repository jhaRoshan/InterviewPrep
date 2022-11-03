package com.roshan.leetcode;

import java.util.*;

public class P210CourseSchedule2 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] inDegree = new int[numCourses];

        for(int i = 0 ; i < prerequisites.length ; i++){
            int course = prerequisites[i][0];
            int depCourse = prerequisites[i][1];
            inDegree[depCourse]++;
            map.putIfAbsent(course , new HashSet<>());
            map.get(course).add(depCourse);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i < numCourses ;i++ ){
            if(inDegree[i] == 0) queue.add(i);
        }

        int[] outPut = new int[numCourses];

        int index = 0;
        while(!queue.isEmpty()){
            index++;
            int poll = queue.poll();
            outPut[numCourses-index] = poll;
            if(map.get(poll) != null){
                for(int p: map.get(poll)){
                    inDegree[p]--;
                    if(inDegree[p] == 0){
                        queue.add(p);
                    }
                }
            }
        }

        if(index != numCourses){
            return new int[0];
        }
        return outPut;
    }

    public static void main(String[] args) {

        P210CourseSchedule2 p = new P210CourseSchedule2();
        int[][] in= {{1,0} , {2,3} , {3,1} , {3,2}};
        int[] arr = p.findOrder(4 , in);
        System.out.println(Arrays.toString(arr));

    }

}
