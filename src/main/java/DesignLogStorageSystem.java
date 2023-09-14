import java.util.*;

public class DesignLogStorageSystem {

    public static void main(String[] args) {
        LogStorageSystem logStorageSystem = new LogStorageSystem();
        logStorageSystem.Put(1, "2017:01:01:23:59:59");
        logStorageSystem.Put(2, "2017:01:01:22:59:59");
        logStorageSystem.Put(3, "2016:01:01:00:00:00");
        System.out.println(Arrays.toString(logStorageSystem.Retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Year")));
        System.out.println(Arrays.toString(logStorageSystem.Retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Hour")));
    }

    static class LogStorageSystem {

        private final TreeMap<String, List<Integer>> timestampToId = new TreeMap<>();
        private final Map<String, Integer> granularityIdx = new HashMap<>() {{
            put("Year", 4);
            put("Month", 7);
            put("Day", 10);
            put("Hour", 13);
            put("Minute", 16);
        }};
        private final String minTimestamp = "2000:01:01:00:00:00";
        private final String maxTimestamp = "2017:12:31:23:59:59";

        void Put(int id, String timestamp) {
            timestampToId.computeIfAbsent(timestamp, k -> new ArrayList<>()).add(id);
        }

        int[] Retrieve(String start, String end, String granularity) {
            List<Integer> list = new ArrayList<>();

            String minTimestampGranular = start.substring(0, granularityIdx.get(granularity)) + minTimestamp.substring(granularityIdx.get(granularity));
            String maxTimestampGranular = end.substring(0, granularityIdx.get(granularity)) + maxTimestamp.substring(granularityIdx.get(granularity));

            for (Map.Entry<String, List<Integer>> entry : timestampToId.entrySet()) {
                if (minTimestampGranular.compareTo(entry.getKey()) <= 0 && maxTimestampGranular.compareTo(entry.getKey()) >= 0) {
                    list.addAll(entry.getValue());
                }
            }

            return list.stream().mapToInt(i -> i).toArray();
        }
    }
}
