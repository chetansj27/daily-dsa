package arrays;

public class Searcha2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(searchMatrix(matrix, 23));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length * (matrix[0].length) - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int row = mid / matrix[0].length;
            int col = mid % matrix[0].length;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}
