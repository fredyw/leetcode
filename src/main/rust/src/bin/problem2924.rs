// https://leetcode.com/problems/find-champion-ii/description/
pub fn find_champion(n: i32, edges: Vec<Vec<i32>>) -> i32 {
    let mut v = vec![false; n as usize];
    for edge in edges.iter() {
        let to = edge[1];
        v[to as usize] = true;
    }
    let mut answer = 0;
    let mut count = 0;
    for (i, &b) in v.iter().enumerate() {
        if !b {
            answer = i as i32;
            count += 1;
        }
        if count > 1 {
            return -1;
        }
    }
    answer
}

fn main() {
    println!("{}", find_champion(3, vec![vec![0, 1], vec![1, 2]])); // 0
    println!(
        "{}",
        find_champion(4, vec![vec![0, 2], vec![1, 3], vec![1, 2]])
    ); // -1
    println!(
        "{}",
        find_champion(3, vec![vec![0, 1], vec![1, 2], vec![0, 2]])
    ); // 0
    println!("{}", find_champion(3, vec![vec![1, 0], vec![2, 1]])); // 2
}
