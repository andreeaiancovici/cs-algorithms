package strings;

public class BoyerMoore {

    private static int operations = 0;
    private static int maxCost = 0;

    public static void main(String[] args) {
//        int[][] events = new int[][] {{1,2},{2,3},{3,4}};
//        SegmentTree segmentTree = new SegmentTree(10);
//        segmentTree.build();
//
//        Arrays.sort(events, (a, b) -> a[1] - b[1]);
//
//        int countEvents = 0;
//
//        for(int[] event : events) {
//            int startDay = event[0];
//            int endDay = event[1];
//
//            int firstAvailable = segmentTree.query(startDay, endDay);
//            if (startDay <= firstAvailable && firstAvailable <= endDay) {
//                segmentTree.update(firstAvailable);
//                countEvents++;
//            }
//        }
//
//        System.out.println(countEvents);

        minIncrements(7, new int[]{1, 5, 2, 2, 3, 3, 1});
    }

    public static int minIncrements(int n, int[] cost) {
        maxCost = dfs(1, n, cost) + cost[0];
        dfsPostOrder(1, n, cost, 0);
        return operations;
    }

    private static int dfs(int i, int n, int[] cost) {
        int maxCost = 0;

        if (2 * i <= n) {
            maxCost = Math.max(maxCost, dfs(2 * i, n, cost) + cost[(2 * i) - 1]);
        }

        if (2 * i + 1 <= n) {
            maxCost = Math.max(maxCost, dfs(2 * i + 1, n, cost) + cost[(2 * i + 1) - 1]);
        }

        return maxCost;
    }

    private static int dfsPostOrder(int i, int n, int[] cost, int costSoFar) {
        if (n < i) return 0;

        costSoFar += cost[i - 1];

        int leftCost = 0;
        if (2 * i <= n) {
            leftCost = dfsPostOrder(2 * i, n, cost, costSoFar);
        }

        int rightCost = 0;
        if (2 * i + 1 <= n) {
            rightCost = dfsPostOrder(2 * i + 1, n, cost, costSoFar);
        }

        if (costSoFar + leftCost < maxCost || costSoFar + rightCost < maxCost) {
            int maxCostFromBranch = Math.max(leftCost, rightCost);
            int toAddCost = maxCost - costSoFar - maxCostFromBranch;

            operations += toAddCost;
            cost[i] += toAddCost;

            if (costSoFar + toAddCost + leftCost < maxCost) {
                int leftToAddCost = maxCost - (costSoFar + toAddCost + leftCost);
                operations += leftToAddCost;
                leftCost += leftToAddCost;
            }

            if (costSoFar + toAddCost + rightCost < maxCost) {
                int rightToAddCost = maxCost - (costSoFar + toAddCost + rightCost);
                operations += rightToAddCost;
                rightCost += rightToAddCost;
            }
        }

        return leftCost;// + (cost[i - 1] + toAddCost) + rightCost;
    }
}
