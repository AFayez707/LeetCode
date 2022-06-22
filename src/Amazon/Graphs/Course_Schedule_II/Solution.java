package Amazon.Graphs.Course_Schedule_II;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] orderOfCourses = new int[numCourses];
        int courseIndex = 0;

        // This array will hold how many prerequisites are required for each course.
        int[] numOfRemainingPrerequisites = new int[numCourses];

        // Go through the prerequisites, and increment the number of required prerequisite for each course.
        for(int[] prerequisite : prerequisites)
            numOfRemainingPrerequisites[prerequisite[0]]++;

        // A HashSet to hold the current course we are able to take (Prerequisites has been achieved)
        Set<Integer> coursesWithoutRemainingPrerequisites = new HashSet<>();
        // Go through numOfRemainingPrerequisites, and add to the HashSet courses we can now take.
        for(int i = 0; i < numCourses; i++)
            if(numOfRemainingPrerequisites[i] == 0)
                coursesWithoutRemainingPrerequisites.add(i);

        // Check if there's no course we can take now,
        // if true we return false as we will never be able to take all the courses
        if(coursesWithoutRemainingPrerequisites.isEmpty())
            return new int[]{};

        while(!coursesWithoutRemainingPrerequisites.isEmpty()) {
            // Get a course without required prerequisites and remove it from the set
            Iterator<Integer> iterator = coursesWithoutRemainingPrerequisites.iterator();
            int course = iterator.next();
            coursesWithoutRemainingPrerequisites.remove(course);
            // Add the current course to the answer.
            orderOfCourses[courseIndex++] = course;
            // Loop through all the gives prerequisites
            for(int[] prerequisite : prerequisites) {
                // if the current course was a prerequisite for something
                if(course == prerequisite[1]) {
                    // Remove it as a requirement, because we already took it.
                    numOfRemainingPrerequisites[prerequisite[0]]--;
                    // if a course because with 0 required prerequisite, add it to the courses we can take.
                    if(numOfRemainingPrerequisites[prerequisite[0]] == 0)
                        coursesWithoutRemainingPrerequisites.add(prerequisite[0]);
                }
            }
        }
        for(int numOfPrerequisites : numOfRemainingPrerequisites)
            if(numOfPrerequisites != 0)
                return new int[]{};

        return orderOfCourses;
    }
}
