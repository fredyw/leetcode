// https://leetcode.com/problems/sequential-grid-path-cover/description/
pub fn find_path(grid: Vec<Vec<i32>>, k: i32) -> Vec<Vec<i32>> {
    fn find_path(
        grid: &Vec<Vec<i32>>,
        row: isize,
        col: isize,
        k: i32,
        count: &mut i32,
        visited: &mut Vec<Vec<bool>>,
    ) -> bool {
        let num_rows = grid.len() as isize;
        let num_cols = if num_rows > 0 { grid[0].len() } else { 0 } as isize;
        if *count == grid.len() as i32 {
            return true;
        }
        if row < 0
            || row == num_rows
            || col < 0
            || col == num_cols
            || visited[row as usize][col as usize]
        {
            return false;
        }
        visited[row as usize][col as usize] = true;
        for (r, c) in [(-1, 0), (0, 1), (1, 0), (0, -1)] {
            if find_path(grid, row + r, col + c, k, count, visited) {}
        }
        true
    }

    todo!()
}

fn main() {
    println!("{:?}", find_path(vec![vec![0, 0, 0], vec![0, 1, 2]], 2)); // [[0,0],[1,0],[1,1],[1,2],[0,2],[0,1]]
    println!("{:?}", find_path(vec![vec![1, 0, 4], vec![3, 0, 2]], 4)); // []
    println!("{:?}", find_path(vec![vec![0, 0, 0], vec![1, 0, 2]], 2)); // [[0,0],[1,0],[1,1],[1,2],[0,2],[0,1]]
    println!("{:?}", find_path(vec![vec![0, 0, 0], vec![0, 1, 2]], 2)); // []
}
