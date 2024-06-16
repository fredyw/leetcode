use std::cell::RefCell;
use std::collections::{HashMap, HashSet};
use std::rc::Rc;

// https://leetcode.com/problems/making-a-large-island/description/
pub fn largest_island(grid: Vec<Vec<i32>>) -> i32 {
    fn island_size(
        grid: &Vec<Vec<i32>>,
        row: i32,
        col: i32,
        visited: &mut Vec<Vec<bool>>,
        island: &mut HashMap<(i32, i32), Rc<RefCell<(i32, i32)>>>,
        rc_size: Rc<RefCell<(i32, i32)>>,
    ) -> i32 {
        let n = grid.len() as i32;
        if row < 0 || col < 0 || row == n || col == n {
            return 0;
        }
        if visited[row as usize][col as usize] {
            return 0;
        }
        if grid[row as usize][col as usize] == 0 {
            return 0;
        }
        visited[row as usize][col as usize] = true;
        island.insert((row, col), rc_size.clone());
        let mut size = 1;
        for (r, c) in [(0, 1), (0, -1), (1, 0), (-1, 0)] {
            size += island_size(grid, row + r, col + c, visited, island, rc_size.clone());
        }
        size
    }

    let mut answer = 0;
    let n = grid.len();
    let mut visited = vec![vec![false; n]; n];
    let mut island: HashMap<(i32, i32), Rc<RefCell<(i32, i32)>>> = HashMap::new();
    let mut i = 0;
    for row in 0..n {
        for col in 0..n {
            if visited[row][col] {
                continue;
            }
            let rc_size = Rc::new(RefCell::new((0, i)));
            let size = island_size(
                &grid,
                row as i32,
                col as i32,
                &mut visited,
                &mut island,
                rc_size.clone(),
            );
            *rc_size.borrow_mut() = (size, i);
            answer = answer.max(size);
            i += 1;
        }
    }
    for row in 0..n as i32 {
        for col in 0..n as i32 {
            // Attempt to make an island.
            if grid[row as usize][col as usize] == 0 {
                let mut total_size = 0;
                let mut visited: HashSet<i32> = HashSet::new();
                for (r, c) in [(0, 1), (0, -1), (1, 0), (-1, 0)] {
                    let next_row = row + r;
                    let next_col = col + c;
                    if let Some(size) = island.get(&(next_row, next_col)) {
                        let (size, i) = *size.borrow();
                        if visited.contains(&i) {
                            continue;
                        }
                        total_size += size;
                        visited.insert(i);
                    }
                }
                answer = answer.max(total_size + 1);
            }
        }
    }
    answer
}

fn main() {
    println!("{}", largest_island(vec![vec![1, 0], vec![0, 1]])); // 3
    println!("{}", largest_island(vec![vec![1, 1], vec![1, 0]])); // 4
    println!("{}", largest_island(vec![vec![1, 1], vec![1, 1]])); // 4
    println!("{}", largest_island(vec![vec![0, 0], vec![0, 0]])); // 1
    println!("{}", largest_island(vec![vec![0, 0], vec![1, 0]])); // 2
    println!(
        "{}",
        largest_island(vec![vec![1, 0, 1], vec![0, 0, 0], vec![0, 1, 1]])
    ); // 4
    println!(
        "{}",
        largest_island(vec![
            vec![0, 0, 0, 0, 0, 0, 0],
            vec![0, 1, 1, 1, 1, 0, 0],
            vec![0, 1, 0, 0, 1, 0, 0],
            vec![1, 0, 1, 0, 1, 0, 0],
            vec![0, 1, 0, 0, 1, 0, 0],
            vec![0, 1, 0, 0, 1, 0, 0],
            vec![0, 1, 1, 1, 1, 0, 0]
        ])
    ); // 18
}
