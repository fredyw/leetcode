use std::collections::HashMap;

// https://leetcode.com/problems/check-knight-tour-configuration/
pub fn check_valid_grid(grid: Vec<Vec<i32>>) -> bool {
    fn is_valid(from: &(i32, i32), to: &(i32, i32), length: i32) -> bool {
        let (from_row, from_col) = from;
        if from_row - 2 >= 0 {
            let r = from_row - 2;
            if from_col - 1 >= 0 {
                let c = from_col - 1;
                if &(r, c) == to {
                    return true;
                }
            }
            if from_col + 1 < length {
                let c = from_col + 1;
                if &(r, c) == to {
                    return true;
                }
            }
        }
        if from_row + 2 < length {
            let r = from_row + 2;
            if from_col - 1 >= 0 {
                let c = from_col - 1;
                if &(r, c) == to {
                    return true;
                }
            }
            if from_col + 1 < length {
                let c = from_col + 1;
                if &(r, c) == to {
                    return true;
                }
            }
        }
        if from_col - 2 >= 0 {
            let c = from_col - 2;
            if from_row - 1 >= 0 {
                let r = from_row - 1;
                if &(r, c) == to {
                    return true;
                }
            }
            if from_row + 1 < length {
                let r = from_row + 1;
                if &(r, c) == to {
                    return true;
                }
            }
        }
        if from_col + 2 >= 0 {
            let c = from_col + 2;
            if from_row - 1 >= 0 {
                let r = from_row - 1;
                if &(r, c) == to {
                    return true;
                }
            }
            if from_row + 1 < length {
                let r = from_row + 1;
                if &(r, c) == to {
                    return true;
                }
            }
        }
        false
    }

    let mut map: HashMap<i32, (usize, usize)> = HashMap::new();
    let length = grid.len();
    for row in 0..length {
        for col in 0..length {
            map.insert(grid[row][col], (row, col));
        }
    }
    let mut from = (0, 0);
    for n in 1..length * length {
        match map.get(&(n as i32)) {
            None => {
                break;
            }
            Some((r, c)) => {
                let to = (*r as i32, *c as i32);
                if !is_valid(&from, &to, length as i32) {
                    return false;
                }
                from = to;
                map.remove(&(n as i32));
            }
        }
    }
    true
}

fn main() {
    println!(
        "{}",
        check_valid_grid(vec![
            vec![0, 11, 16, 5, 20],
            vec![17, 4, 19, 10, 15],
            vec![12, 1, 8, 21, 6],
            vec![3, 18, 23, 14, 9],
            vec![24, 13, 2, 7, 22]
        ])
    ); // true
    println!(
        "{}",
        check_valid_grid(vec![vec![0, 3, 6], vec![5, 8, 1], vec![2, 7, 4]])
    ); // false
}
