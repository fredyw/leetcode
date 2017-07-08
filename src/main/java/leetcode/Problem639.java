package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/design-log-storage-system/
 */
public class Problem639 {
    public static class LogSystem {
//        private final PriorityQueue<Timestamp> list = new PriorityQueue<>((a, b) -> {
//            int cmp = Integer.compare(a.year, b.year);
//            if (cmp == 0) {
//                cmp = Integer.compare(a.month, b.month);
//                if (cmp == 0) {
//                    cmp = Integer.compare(a.day, b.day);
//                    if (cmp == 0) {
//                        cmp = Integer.compare(a.hour, b.hour);
//                        if (cmp == 0) {
//                            cmp = Integer.compare(a.minute, b.minute);
//                            if (cmp == 0) {
//                                cmp = Integer.compare(a.second, b.second);
//                            }
//                        }
//                    }
//                }
//            }
//            return cmp;
//        });
        private final List<Timestamp> list = new ArrayList<>();

        private static class Timestamp {
            private final int id;
            private final int year;
            private final int month;
            private final int day;
            private final int hour;
            private final int minute;
            private final int second;

            public Timestamp(int id, int year, int month, int day, int hour, int minute, int second) {
                this.id = id;
                this.year = year;
                this.month = month;
                this.day = day;
                this.hour = hour;
                this.minute = minute;
                this.second = second;
            }

            @Override
            public String toString() {
                return String.format("%d -> %d:%d:%d:%d:%d:%d", id, year, month, day, hour, minute, second);
            }
        }

        public LogSystem() {
        }

        public void put(int id, String timestamp) {
            String[] split = timestamp.split(":");
            Timestamp ts = new Timestamp(
                id,
                Integer.parseInt(split[0]),
                Integer.parseInt(split[1]),
                Integer.parseInt(split[2]),
                Integer.parseInt(split[3]),
                Integer.parseInt(split[4]),
                Integer.parseInt(split[5]));
            list.add(ts);
        }

        public List<Integer> retrieve(String s, String e, String gra) {
            String[] startSplit = s.split(":");
            String[] endSplit = e.split(":");
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                Timestamp ts = list.get(i);
                if (Integer.parseInt(startSplit[0]) <= ts.year &&
                    Integer.parseInt(endSplit[0]) >= ts.year) {
                    if ((gra.equals("Year") &&
                        (Integer.parseInt(startSplit[0]) == ts.year ||
                            Integer.parseInt(endSplit[0]) == ts.year)) ||
                        Integer.parseInt(startSplit[0]) < ts.year &&
                            Integer.parseInt(endSplit[0]) > ts.year) {
                        result.add(ts.id);
                        continue;
                    }
                    if (Integer.parseInt(startSplit[1]) <= ts.month &&
                        Integer.parseInt(endSplit[1]) >= ts.month) {
                        if ((gra.equals("Month") &&
                            (Integer.parseInt(startSplit[1]) == ts.month ||
                                Integer.parseInt(endSplit[1]) == ts.month)) ||
                            Integer.parseInt(startSplit[1]) < ts.month &&
                                Integer.parseInt(endSplit[1]) > ts.month) {
                            result.add(ts.id);
                            continue;
                        }
                        if (Integer.parseInt(startSplit[2]) <= ts.day &&
                            Integer.parseInt(endSplit[2]) >= ts.day) {
                            if ((gra.equals("Day") &&
                                (Integer.parseInt(startSplit[2]) == ts.day ||
                                    Integer.parseInt(endSplit[2]) == ts.day)) ||
                                Integer.parseInt(startSplit[2]) < ts.day &&
                                    Integer.parseInt(endSplit[2]) > ts.day) {
                                result.add(ts.id);
                                continue;
                            }
                            if (Integer.parseInt(startSplit[3]) <= ts.hour &&
                                Integer.parseInt(endSplit[3]) >= ts.hour) {
                                if ((gra.equals("Hour") &&
                                    (Integer.parseInt(startSplit[3]) == ts.hour ||
                                        Integer.parseInt(endSplit[3]) == ts.hour)) ||
                                    Integer.parseInt(startSplit[3]) < ts.hour &&
                                        Integer.parseInt(endSplit[3]) > ts.hour) {
                                    result.add(ts.id);
                                    continue;
                                }
                                if (Integer.parseInt(startSplit[4]) <= ts.minute &&
                                    Integer.parseInt(endSplit[4]) >= ts.minute) {
                                    if ((gra.equals("Minute") &&
                                        (Integer.parseInt(startSplit[4]) == ts.minute ||
                                            Integer.parseInt(endSplit[4]) == ts.minute)) ||
                                        Integer.parseInt(startSplit[4]) < ts.minute &&
                                            Integer.parseInt(endSplit[4]) > ts.minute) {
                                        result.add(ts.id);
                                        continue;
                                    }
                                    if (Integer.parseInt(startSplit[5]) <= ts.second &&
                                        Integer.parseInt(endSplit[5]) >= ts.second) {
                                        result.add(ts.id);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        LogSystem log = new LogSystem();
        log.put(1, "2017:01:01:23:59:59");
        log.put(2, "2017:01:01:22:59:59");
        log.put(3, "2016:01:01:00:00:00");
        System.out.println(log.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Year")); // [1,2,3]
        System.out.println(log.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Hour")); // [1,2]
        System.out.println(log.retrieve("2014:01:01:01:01:01", "2018:01:01:23:00:00", "Hour")); // [1,2,3]
        System.out.println(log.retrieve("2017:01:01:23:00:00", "2017:01:01:23:59:59", "Second")); // [1]
    }
}
