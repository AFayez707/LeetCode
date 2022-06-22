package Amazon.Graphs.Course_Schedule;

import java.util.*;
// Link: https://leetcode.com/problems/course-schedule/
// Time: O(V+E) E: Number of dependencies, V: Number of Courses
// Space: O(V+E) E: Number of dependencies, V: Number of Courses
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> inEdges = new HashMap<>();
        Map<Integer, Set<Integer>> outEdges = new HashMap<>();
        ArrayList<Integer> completedCourses = new ArrayList<>();
        for (int course = 0; course < numCourses; course++) {
            inEdges.put(course, new HashSet<>());
            outEdges.put(course, new HashSet<>());
        }
        for (int[] prerequisite : prerequisites) {
            inEdges.get(prerequisite[1]).add(prerequisite[0]);
            outEdges.get(prerequisite[0]).add(prerequisite[1]);
        }
        Queue<Integer> coursesWithNoDependencies = new LinkedList<>();
        // Check for courses that has no prerequisites to start with them
        for (int course = 0; course < numCourses; course++) {
            if (outEdges.get(course).isEmpty()) {
                coursesWithNoDependencies.add(course);
            }
        }
        while (!coursesWithNoDependencies.isEmpty()) {
            List<Integer> courses = new ArrayList<>();
            while (!coursesWithNoDependencies.isEmpty()) {
                Integer course = coursesWithNoDependencies.poll();
                courses.add(course);
                completedCourses.add(course);
            }
            // Check for the new completed courses if any of them satisfied the prerequisites of another course
            // If so, remove it's dependency and add them to courses without dependencies in order to take them.
            for (Integer course : courses) {
                Set<Integer> inDependencies = inEdges.get(course);
                for (Integer inDependency : inDependencies) {
                    outEdges.get(inDependency).remove(course);
                    if (outEdges.get(inDependency).isEmpty()) {
                        coursesWithNoDependencies.add(inDependency);
                    }
                }
            }
        }

        if (completedCourses.size() == numCourses) {
            return true;
        } else {
            return false;
        }
    }
}
