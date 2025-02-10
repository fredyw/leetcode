// https://leetcode.com/problems/sort-matrix-by-diagonals/description/
pub fn sort_matrix(mut grid: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
    let n = grid.len();
    for row in 0..n {
        let mut r = row;
        let mut c = 0;
        let mut diagonal: Vec<i32> = Vec::new();
        while r < n && c < n {
            diagonal.push(grid[r][c]);
            r += 1;
            c += 1;
        }
        diagonal.sort_by(|a, b| b.cmp(a));
        let mut i = row;
        let mut j = 0;
        while i < n && j < n {
            grid[i][j] = diagonal[j];
            i += 1;
            j += 1;
        }
    }
    for col in 1..n {
        let mut r = 0;
        let mut c = col;
        let mut diagonal: Vec<i32> = Vec::new();
        while r < n && c < n {
            diagonal.push(grid[r][c]);
            r += 1;
            c += 1;
        }
        diagonal.sort_by(|a, b| a.cmp(b));
        let mut r = 0;
        let mut c = col;
        while r < n && c < n {
            grid[r][c] = diagonal[r];
            r += 1;
            c += 1;
        }
    }
    grid
}

fn main() {
    println!(
        "{:?}",
        sort_matrix(vec![vec![1, 7, 3], vec![9, 8, 2], vec![4, 5, 6]])
    ); // [[8,2,3],[9,6,7],[4,5,1]]
    println!("{:?}", sort_matrix(vec![vec![0, 1], vec![1, 2]])); // [[2,1],[1,0]]
    println!("{:?}", sort_matrix(vec![vec![1]])); // [[1]]
}
