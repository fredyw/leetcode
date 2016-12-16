package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * https://leetcode.com/problems/pacific-atlantic-water-flow/
 */
public class Problem417 {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<>();
        if (matrix.length == 0) {
            return result;
        }
        int maxRow = matrix.length;
        int maxCol = matrix[0].length;
        Map<RowCol, Ocean> memo = new HashMap<>();
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                Ocean ocean = pacificAtlantic(matrix, maxRow, maxCol, row, col, memo);
                memo.put(new RowCol(row, col), ocean);
                if (ocean.atlantic && ocean.pacific) {
                    result.add(new int[]{row, col});
                }
            }
        }
        return result;
    }

    private static Ocean pacificAtlantic(int[][] matrix, int maxRow, int maxCol,
                                         int row, int col, Map<RowCol, Ocean> memo) {
        Ocean ocean = new Ocean();
        Set<RowCol> visited = new HashSet<>();
        LinkedList<RowCol> queue = new LinkedList<>();
        RowCol start = new RowCol(row, col);
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            if (ocean.pacific && ocean.atlantic) {
                return ocean;
            }
            RowCol rc = queue.remove();
            if (rc.row < 0 || rc.row >= maxRow || rc.col < 0 || rc.col >= maxCol) {
                if (rc.row < 0 || rc.col < 0) {
                    ocean.pacific = true;
                }
                if (rc.row >= maxRow || rc.col >= maxCol) {
                    ocean.atlantic = true;
                }
            } else {
                int val = matrix[rc.row][rc.col];
                RowCol up = new RowCol(rc.row - 1, rc.col);
                if (!visited.contains(up)) {
                    if (up.row < 0 || matrix[up.row][up.col] <= val) {
                        if (memo.containsKey(up)) {
                            Ocean o = memo.get(up);
                            if (o.pacific) {
                                ocean.pacific = o.pacific;
                            }
                            if (o.atlantic) {
                                ocean.atlantic = o.atlantic;
                            }
                        } else {
                            queue.add(up);
                            visited.add(up);
                        }
                    }
                }
                RowCol right = new RowCol(rc.row, rc.col + 1);
                if (!visited.contains(right)) {
                    if (right.col >= maxCol || matrix[right.row][right.col] <= val) {
                        if (memo.containsKey(right)) {
                            Ocean o = memo.get(right);
                            if (o.pacific) {
                                ocean.pacific = o.pacific;
                            }
                            if (o.atlantic) {
                                ocean.atlantic = o.atlantic;
                            }
                        } else {
                            queue.add(right);
                            visited.add(right);
                        }
                    }
                }
                RowCol down = new RowCol(rc.row + 1, rc.col);
                if (!visited.contains(down)) {
                    if (down.row >= maxRow || matrix[down.row][down.col] <= val) {
                        if (memo.containsKey(down)) {
                            Ocean o = memo.get(down);
                            if (o.pacific) {
                                ocean.pacific = o.pacific;
                            }
                            if (o.atlantic) {
                                ocean.atlantic = o.atlantic;
                            }
                        } else {
                            queue.add(down);
                            visited.add(down);
                        }
                    }
                }
                RowCol left = new RowCol(rc.row, rc.col - 1);
                if (!visited.contains(left)) {
                    if (left.col < 0 || matrix[left.row][left.col] <= val) {
                        if (memo.containsKey(left)) {
                            Ocean o = memo.get(left);
                            if (o.pacific) {
                                ocean.pacific = o.pacific;
                            }
                            if (o.atlantic) {
                                ocean.atlantic = o.atlantic;
                            }
                        } else {
                            queue.add(left);
                            visited.add(left);
                        }
                    }
                }
            }
        }
        return ocean;
    }

    private static class Ocean {
        private boolean pacific;
        private boolean atlantic;
    }

    private static class RowCol {
        private final int row;
        private final int col;

        public RowCol(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            RowCol rowCol = (RowCol) o;
            return row == rowCol.row &&
                col == rowCol.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }
}
