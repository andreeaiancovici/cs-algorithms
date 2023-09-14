
public class AndroidUnlockPatterns {
    private static final int[][] directions = new int[][]{{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {-1, 1}, {0, -1}, {-1, -1}};
    private static final int[][] directionsDiagonal = new int[][]{{-2, 1}, {2, -1}, {-2, -1}, {2, 1}, {-1, 2}, {1, -2}, {1, 2}, {-1, -2}};
    private static final int[][] directions2Step = new int[][]{{-2, 0}, {-2, 2}, {0, 2}, {2, 2}, {2, 0}, {2, -2}, {0, -2}, {-2, -2}};
    private static final int[][] directions1Step = new int[][]{{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

    public static void main(String[] args) {
        System.out.println(androidUnlockPattern(1, 1));
        System.out.println(androidUnlockPattern(1, 2));
    }

    private static int androidUnlockPattern(int m, int n) {
        boolean[][] visited = new boolean[3][3];

        int unlockPatterns = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                visited[i][j] = true;
                unlockPatterns += dfs(visited, i, j, 1, m, n);
                visited[i][j] = false;
            }
        }

        return unlockPatterns;
    }

    private static int dfs(boolean[][] visited, int i, int j, int keys, int m, int n) {
        if (n < keys) return 0;

        int count = 0;

        if (m <= keys) count += 1;

        for (int[] direction : directions) {
            int I = i + direction[0];
            int J = j + direction[1];

            if (!(0 <= I && I < 3 && 0 <= J && J < 3)) continue;
            if (visited[I][J]) continue;

            visited[I][J] = true;
            count += dfs(visited, I, J, keys + 1, m, n);
            visited[I][J] = false;
        }

        for (int[] direction : directionsDiagonal) {
            int I = i + direction[0];
            int J = j + direction[1];

            if (!(0 <= I && I < 3 && 0 <= J && J < 3)) continue;
            if (visited[I][J]) continue;

            visited[I][J] = true;
            count += dfs(visited, I, J, keys + 1, m, n);
            visited[I][J] = false;
        }

        for (int s = 0; s < directions2Step.length; s++) {
            int I = i + directions2Step[s][0];
            int J = j + directions2Step[s][1];

            if (!(0 <= I && I < 3 && 0 <= J && J < 3)) continue;
            if (visited[I][J]) continue;
            if (!visited[i + directions1Step[s][0]][j + directions1Step[s][1]]) continue;

            visited[I][J] = true;
            count += dfs(visited, I, J, keys + 1, m, n);
            visited[I][J] = false;
        }

        return count;
    }
}
