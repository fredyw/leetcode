// https://leetcode.com/problems/median-of-a-row-wise-sorted-matrix/description/
pub fn matrix_median(grid: Vec<Vec<i32>>) -> i32 {
    fn get_element_count(v: &Vec<i32>, value: i32) -> i32 {
        let mut left: i32 = 0;
        let mut right = v.len() as i32 - 1;
        while left <= right {
            let mid = left + (right - left) / 2;
            if v[mid as usize] <= value {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        left
    }

    let mut min = i32::MAX;
    let mut max = i32::MIN;
    for i in 0..grid.len() {
        min = min.min(grid[i][0]);
        max = max.max(grid[i][grid[i].len() - 1]);
    }
    let median = (grid.len() * grid[0].len() / 2) as i32;
    let mut low = min;
    let mut high = max;
    while low <= high {
        let mid = low + (high - low) / 2;
        let mut count = 0;
        for i in 0..grid.len() {
            count += get_element_count(&grid[i], mid);
        }
        if count <= median {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    low
}

fn main() {
    println!(
        "{}",
        matrix_median(vec![vec![1, 1, 2], vec![2, 3, 3], vec![1, 3, 4]])
    ); // 2
    println!("{}", matrix_median(vec![vec![1, 1, 3, 3, 4]])); // 3
    println!(
        "{}",
        matrix_median(vec![vec![1, 1, 1], vec![9, 9, 9], vec![7, 8, 8]])
    ); // 8
}
