// https://leetcode.com/problems/minimum-absolute-difference-in-sliding-submatrix/description/
pub fn min_abs_diff(grid: Vec<Vec<i32>>, k: i32) -> Vec<Vec<i32>> {
    let mut answer: Vec<Vec<i32>> = vec![];
    for i in 0..grid.len() {
        let mut v: Vec<i32> = vec![];
        'skip: for j in 0..grid[i].len() {
            if i + k as usize > grid.len() {
                continue 'skip;
            }
            let mut nums = vec![];
            for a in i..i + k as usize {
                if j + k as usize > grid[i].len() {
                    continue 'skip;
                }
                for b in j..j + k as usize {
                    nums.push(grid[a][b]);
                }
            }
            nums.sort_unstable();
            let mut min = i32::MAX;
            for i in 0..nums.len() - 1 {
                let diff = (nums[i] - nums[i + 1]).abs();
                if diff == 0 {
                    continue;
                }
                min = diff.min(min);
            }
            v.push(if min == i32::MAX { 0 } else { min });
        }
        if !v.is_empty() {
            answer.push(v);
        }
    }
    answer
}

fn main() {
    println!("{:?}", min_abs_diff(vec![vec![1, 8], vec![3, -2]], 2)); // [[2]]
    println!("{:?}", min_abs_diff(vec![vec![3, -1]], 1)); // [[0,0]]
    println!("{:?}", min_abs_diff(vec![vec![1, -2, 3], vec![2, 3, 5]], 2)); // [[1,2]]
}
