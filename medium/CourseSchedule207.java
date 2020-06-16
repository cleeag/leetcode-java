import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CourseSchedule207 {
    public static void main(String[] args) {
        int numCourses = 4;
//        int[][] prerequisites = new int[][]{{0, 2}, {1, 2}, {2, 0}};
        int[][] prerequisites = new int[][]{{2, 0}, {1, 0}, {3, 1}, {3, 2}, {1, 3}};
        CourseSchedule207 tmp = new CourseSchedule207();
        System.out.println(tmp.canFinish(numCourses, prerequisites));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> courses = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) courses.add(new LinkedList<>());
        for (int[] prerequisite : prerequisites) {
            courses.get(prerequisite[1]).add(prerequisite[0]);
        }
        boolean[] visited = new boolean[numCourses];
        for (List<Integer> course : courses) System.out.println(course.toString());

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, visited, courses)) return false;
        }
        return true;
    }

    public boolean dfs(int idx, boolean[] visited, List<List<Integer>> courses) {
        System.out.println(idx);
        System.out.println();
        if (visited[idx]) return false;
        visited[idx] = true;
        for (int courseIdx : courses.get(idx)) {
            if (!dfs(courseIdx, visited, courses)) return false;
        }
        visited[idx] = false;
        return true;
    }
}

