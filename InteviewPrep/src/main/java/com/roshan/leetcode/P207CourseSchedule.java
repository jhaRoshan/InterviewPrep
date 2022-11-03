package com.roshan.leetcode;

import java.util.*;

public class P207CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if(numCourses <2 || prerequisites.length == 0) return true;

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

        int index = 0;
        while(!queue.isEmpty()){
            index++;
            int poll = queue.poll();
            if(map.get(poll) != null){
                for(int p: map.get(poll)){
                    inDegree[p]--;
                    if(inDegree[p] == 0){
                        queue.add(p);
                    }
                }
            }
        }
        return index == numCourses;
    }



    public static void main(String[] args) {
        P207CourseSchedule p = new P207CourseSchedule();
        int c =3;
        int[][] arr= {{1,0} , {0,2} , {2,1}};
        System.out.println(p.canFinish(c , arr));
    }
}
