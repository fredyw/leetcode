// https://leetcode.com/problems/detonate-the-maximum-bombs/
pub fn maximum_detonation(bombs: Vec<Vec<i32>>) -> i32 {
    fn square(x: i64) -> i64 {
        x * x
    }

    fn distance(x1: i64, y1: i64, x2: i64, y2: i64) -> i64 {
        (square((x1 - x2).abs()) as f64 + square((y1 - y2).abs()) as f64).sqrt() as i64
    }

    fn within_range(bomb1: &Vec<i32>, bomb2: &Vec<i32>) -> bool {
        let x1 = bomb1[0] as i64;
        let y1 = bomb1[1] as i64;
        let r1 = bomb1[2] as i64;
        let x2 = bomb2[0] as i64;
        let y2 = bomb2[1] as i64;
        let r2 = bomb2[2] as i64;
        distance(x1, y1, x2, y2) < r1 + r2
    }

    fn build_adj_list(bombs: &Vec<Vec<i32>>) -> Vec<Vec<usize>> {
        let mut adj_list: Vec<Vec<usize>> = vec![vec![]; bombs.len()];
        for i in 0..bombs.len() {
            for j in i + 1..bombs.len() {
                if within_range(&bombs[i], &bombs[j]) {
                    adj_list[i].push(j);
                    adj_list[j].push(i);
                }
            }
        }
        adj_list
    }

    fn max_detonation(adj_list: &Vec<Vec<usize>>, i: usize, visited: &mut Vec<bool>) -> i32 {
        visited[i] = true;
        let mut count = 0;
        for j in adj_list[i].iter() {
            if visited[*j] {
                continue;
            }
            count += max_detonation(adj_list, *j, visited) + 1;
        }
        count
    }

    let mut answer = 0;
    let adj_list = build_adj_list(&bombs);
    let mut visited: Vec<bool> = vec![false; bombs.len()];
    for i in 0..bombs.len() {
        if !visited[i] {
            answer = answer.max(max_detonation(&adj_list, i, &mut visited) + 1);
        }
    }
    answer
}

fn main() {
    println!("{}", maximum_detonation(vec![vec![2, 1, 3], vec![6, 1, 4]])); // 2
    println!(
        "{}",
        maximum_detonation(vec![vec![1, 1, 5], vec![10, 10, 5]])
    ); // 1
    println!(
        "{}",
        maximum_detonation(vec![
            vec![1, 2, 3],
            vec![2, 3, 1],
            vec![3, 4, 2],
            vec![4, 5, 3],
            vec![5, 6, 4]
        ])
    ); // 5
    println!(
        "{}",
        maximum_detonation(vec![
            vec![1, 2, 3],
            vec![2, 3, 1],
            vec![3, 4, 2],
            vec![4, 5, 3],
            vec![5, 6, 1]
        ])
    ); // 5
    println!(
        "{}",
        maximum_detonation(vec![
            vec![54, 95, 4],
            vec![99, 46, 3],
            vec![29, 21, 3],
            vec![96, 72, 8],
            vec![49, 43, 3],
            vec![11, 20, 3],
            vec![2, 57, 1],
            vec![69, 51, 7],
            vec![97, 1, 10],
            vec![85, 45, 2],
            vec![38, 47, 1],
            vec![83, 75, 3],
            vec![65, 59, 3],
            vec![33, 4, 1],
            vec![32, 10, 2],
            vec![20, 97, 8],
            vec![35, 37, 3]
        ])
    ); // 1
}
