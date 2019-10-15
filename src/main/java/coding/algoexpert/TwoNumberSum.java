package coding.algoexpert;

public class TwoNumberSum {
    public static int[] twoNumberSum(int[] array, int targetSum) {
        int[] solution = null;

        for (int x1 : array) {
            for (int x2 : array) {
                if (x1 + x2 == targetSum) {
                    if (x1 < x2) {
                        solution = new int[2];
                        solution[0] = x1;
                        solution[1] = x2;
                        break;
                    }
                }
            }

            if (solution != null) {
                break;
            }
        }

        if (solution == null)
            return new int[0];
        else
            return solution;
    }
}
