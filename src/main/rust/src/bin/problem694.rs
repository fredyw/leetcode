use std::collections::HashSet;

//https://leetcode.com/problems/number-of-distinct-islands/description/
pub fn num_distinct_islands(grid: Vec<Vec<i32>>) -> i32 {
    fn dfs(
        grid: &Vec<Vec<i32>>,
        row: i32,
        col: i32,
        direction: char,
        island: &mut String,
        visited: &mut Vec<Vec<bool>>,
    ) {
        let max_rows = grid.len() as i32;
        let max_cols = if max_rows > 0 { grid[0].len() } else { 0 } as i32;
        if row < 0
            || row == max_rows
            || col < 0
            || col == max_cols
            || visited[row as usize][col as usize]
            || grid[row as usize][col as usize] == 0
        {
            return;
        }
        visited[row as usize][col as usize] = true;
        island.push(direction);
        for (r, c) in [(-1, 0), (0, 1), (1, 0), (0, -1)] {
            let direction = if r == -1 {
                'u'
            } else if r == 1 {
                'd'
            } else if c == -1 {
                'l'
            } else {
                'r'
            };
            dfs(grid, row + r, col + c, direction, island, visited);
        }
    }

    let mut islands: HashSet<String> = HashSet::new();
    let max_rows = grid.len();
    let max_cols = if max_rows > 0 { grid[0].len() } else { 0 };
    let mut visited = vec![vec![false; max_cols]; max_rows];
    for row in 0..max_rows {
        for col in 0..max_cols {
            if !visited[row][col] && grid[row][col] == 1 {
                let mut island = String::new();
                dfs(
                    &grid,
                    row as i32,
                    col as i32,
                    's',
                    &mut island,
                    &mut visited,
                );
                println!("island: {island}");
                islands.insert(island);
            }
        }
    }
    islands.len() as i32
}

fn main() {
    // println!(
    //     "{}",
    //     num_distinct_islands(vec![
    //         vec![1, 1, 0, 0, 0],
    //         vec![1, 1, 0, 0, 0],
    //         vec![0, 0, 0, 1, 1],
    //         vec![0, 0, 0, 1, 1]
    //     ])
    // ); // 1
    // println!(
    //     "{}",
    //     num_distinct_islands(vec![
    //         vec![1, 1, 0, 1, 1],
    //         vec![1, 0, 0, 0, 0],
    //         vec![0, 0, 0, 0, 1],
    //         vec![1, 1, 0, 1, 1]
    //     ])
    // ); // 3

    // 00101011100001001001110111000110110101010000011110
    // 00100111001010011001000101110000000111000101101000
    // 01010111001100001010111011100010101000111110010010
    // 10100101001001110100001010010111010001110000111111
    println!(
        "{}",
        num_distinct_islands(vec![
            vec![
                0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0,
                0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0
            ],
            vec![
                0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1,
                0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0
            ],
            vec![
                0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0,
                0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0
            ],
            vec![
                1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1,
                0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1
            ]
        ])
    ); // 15
}
