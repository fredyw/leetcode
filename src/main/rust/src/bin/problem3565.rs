// https://leetcode.com/problems/sequential-grid-path-cover/description/
pub fn find_path(grid: Vec<Vec<i32>>, k: i32) -> Vec<Vec<i32>> {
    fn find_path(
        grid: &Vec<Vec<i32>>,
        row: isize,
        col: isize,
        k: i32,
        visited: &mut Vec<Vec<bool>>,
        path: &mut Vec<Vec<i32>>,
        answer: &mut Vec<Vec<i32>>,
    ) {
        let num_rows = grid.len() as isize;
        let num_cols = if num_rows > 0 { grid[0].len() } else { 0 } as isize;
        if path.len() as isize == num_rows * num_cols {
            *answer = path.clone();
            return;
        }
        if row < 0
            || row == num_rows
            || col < 0
            || col == num_cols
            || visited[row as usize][col as usize]
            || (grid[row as usize][col as usize] != 0 && grid[row as usize][col as usize] != k)
        {
            return;
        }
        visited[row as usize][col as usize] = true;
        path.push(vec![row as i32, col as i32]);
        for (r, c) in [(-1, 0), (0, 1), (1, 0), (0, -1)] {
            find_path(
                grid,
                row + r,
                col + c,
                if grid[row as usize][col as usize] != 0 {
                    k + 1
                } else {
                    k
                },
                visited,
                path,
                answer,
            );
        }
        path.pop();
        visited[row as usize][col as usize] = false;
    }

    let num_rows = grid.len();
    let num_cols = if num_rows > 0 { grid[0].len() } else { 0 };
    let mut visited = vec![vec![false; num_cols]; num_rows];
    for row in 0..grid.len() {
        for col in 0..grid[row].len() {
            let mut answer = Vec::new();
            find_path(
                &grid,
                row as isize,
                col as isize,
                1,
                &mut visited,
                &mut vec![],
                &mut answer,
            );
            if answer.len() == num_rows * num_cols {
                return answer;
            }
        }
    }
    vec![]
}

fn main() {
    println!("{:?}", find_path(vec![vec![0, 0, 0], vec![0, 1, 2]], 2)); // [[0,0],[1,0],[1,1],[1,2],[0,2],[0,1]]
    println!("{:?}", find_path(vec![vec![1, 0, 4], vec![3, 0, 2]], 4)); // []
    println!("{:?}", find_path(vec![vec![0, 0, 0], vec![1, 0, 2]], 2)); // [[0,0],[1,0],[1,1],[1,2],[0,2],[0,1]]
    println!("{:?}", find_path(vec![vec![0, 0, 0], vec![0, 1, 2]], 2)); // [[0,0],[1,0],[1,1],[1,2],[0,2],[0,1]]
}
