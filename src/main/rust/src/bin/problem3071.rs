use std::collections::HashSet;

// https://leetcode.com/problems/minimum-operations-to-write-the-letter-y-on-a-grid/description/
pub fn minimum_operations_to_write_y(grid: Vec<Vec<i32>>) -> i32 {
    #[derive(Debug)]
    struct Count {
        zero: i32,
        one: i32,
        two: i32,
    }

    let n = grid.len();
    let mut y_indexes: HashSet<(usize, usize)> = HashSet::new();
    let mut row = 0;
    let mut col = 0;
    while col < n / 2 {
        y_indexes.insert((row, col));
        y_indexes.insert((row, n - 1 - col));
        row += 1;
        col += 1;
    }
    while row < n {
        y_indexes.insert((row, col));
        row += 1;
    }
    let mut inside_y_count = Count {
        zero: 0,
        one: 0,
        two: 0,
    };
    let mut outside_y_count = Count {
        zero: 0,
        one: 0,
        two: 0,
    };
    for row in 0..n {
        for col in 0..n {
            if y_indexes.contains(&(row, col)) {
                if grid[row][col] == 0 {
                    inside_y_count.zero += 1;
                } else if grid[row][col] == 1 {
                    inside_y_count.one += 1;
                } else {
                    inside_y_count.two += 1;
                }
            } else {
                if grid[row][col] == 0 {
                    outside_y_count.zero += 1;
                } else if grid[row][col] == 1 {
                    outside_y_count.one += 1;
                } else {
                    outside_y_count.two += 1;
                }
            }
        }
    }
    // inside: 0, outside: 1
    let a = inside_y_count.one + inside_y_count.two + outside_y_count.zero + outside_y_count.two;
    // inside: 1, outside: 0
    let b = inside_y_count.zero + inside_y_count.two + outside_y_count.one + outside_y_count.two;
    // inside: 1, outside: 2
    let c = inside_y_count.zero + inside_y_count.two + outside_y_count.zero + outside_y_count.one;
    // inside: 2, outside: 1
    let d = inside_y_count.zero + inside_y_count.one + outside_y_count.zero + outside_y_count.two;
    // inside: 0, outside: 2
    let e = inside_y_count.one + inside_y_count.two + outside_y_count.zero + outside_y_count.one;
    // inside: 2, outside: 0
    let f = inside_y_count.zero + inside_y_count.one + outside_y_count.one + outside_y_count.two;
    a.min(b.min(c.min(d.min(e.min(f)))))
}

fn main() {
    println!(
        "{}",
        minimum_operations_to_write_y(vec![vec![1, 2, 2], vec![1, 1, 0], vec![0, 1, 0]])
    ); // 3
    println!(
        "{}",
        minimum_operations_to_write_y(vec![
            vec![0, 1, 0, 1, 0],
            vec![2, 1, 0, 1, 2],
            vec![2, 2, 2, 0, 1],
            vec![2, 2, 2, 2, 2],
            vec![2, 1, 2, 2, 2]
        ])
    ); // 12
}
