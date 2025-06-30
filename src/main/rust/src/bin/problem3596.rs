// https://leetcode.com/problems/minimum-cost-path-with-alternating-directions-i/description/
pub fn min_cost(m: i32, n: i32) -> i32 {
    fn min_cost(
        num_rows: i32,
        num_cols: i32,
        row: i32,
        col: i32,
        dest: (usize, usize),
        step: i32,
    ) -> i32 {
        if row < 0 || col < 0 || row == num_rows || col == num_cols {
            return i32::MAX;
        }
        let val = (row + 1) * (col + 1);
        if row as usize == dest.0 && col as usize == dest.1 {
            return val;
        }
        let cost = if step % 2 == 0 {
            let left = min_cost(num_rows, num_cols, row, col - 1, dest, step + 1);
            let up = min_cost(num_rows, num_cols, row - 1, col, dest, step + 1);
            left.min(up)
        } else {
            let right = min_cost(num_rows, num_cols, row, col + 1, dest, step + 1);
            let down = min_cost(num_rows, num_cols, row + 1, col, dest, step + 1);
            right.min(down)
        };
        if cost == i32::MAX {
            cost
        } else {
            cost + val
        }
    }

    let cost = min_cost(m, n, 0, 0, (m as usize - 1, n as usize - 1), 1);
    if cost == i32::MAX {
        -1
    } else {
        cost
    }
}

fn main() {
    // println!("{}", min_cost(1, 1)); // 1
    // println!("{}", min_cost(2, 1)); // 3
    println!("{}", min_cost(2, 2)); // -1
}
