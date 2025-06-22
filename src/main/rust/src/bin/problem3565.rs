// https://leetcode.com/problems/sequential-grid-path-cover/description/
pub fn find_path(grid: Vec<Vec<i32>>, k: i32) -> Vec<Vec<i32>> {
    todo!()
}

fn main() {
    println!("{:?}", find_path(vec![vec![0, 0, 0], vec![0, 1, 2]], 2)); // [[0,0],[1,0],[1,1],[1,2],[0,2],[0,1]]
    println!("{:?}", find_path(vec![vec![1, 0, 4], vec![3, 0, 2]], 4)); // []
    println!("{:?}", find_path(vec![vec![0, 0, 0], vec![1, 0, 2]], 2)); // [[0,0],[1,0],[1,1],[1,2],[0,2],[0,1]]
    println!("{:?}", find_path(vec![vec![0, 0, 0], vec![0, 1, 2]], 2)); // []
}
