use std::cmp::Ordering;

// https://leetcode.com/problems/minimum-moves-to-get-a-peaceful-board/description/
pub fn min_moves(mut rooks: Vec<Vec<i32>>) -> i32 {
    let mut n = rooks.len();
    rooks.sort_by(|a, b| {
        let cmp = a[0].cmp(&b[0]);
        match cmp {
            Ordering::Equal => a[1].cmp(&b[1]),
            _ => cmp,
        }
    });
    let mut answer = 0;
    println!("before {:?}", rooks);
    for i in (0..n).rev() {
        answer += (i as i32 - rooks[i][0]).abs();
        rooks[i][0] = i as i32;
    }
    for i in (0..n).rev() {
        answer += (i as i32 - rooks[i][1]).abs();
        rooks[i][1] = i as i32;
    }
    println!("after  {:?}", rooks);
    answer
}

fn main() {
    println!("{}", min_moves(vec![vec![0, 0], vec![1, 0], vec![1, 1]])); // 3
    println!(
        "{}",
        min_moves(vec![vec![0, 0], vec![0, 1], vec![0, 2], vec![0, 3]])
    ); // 6
    println!(
        "{}",
        min_moves(vec![
            vec![0, 0],
            vec![0, 1],
            vec![1, 0],
            vec![1, 1],
            vec![4, 4]
        ])
    ); // 8
    println!(
        "{}",
        min_moves(vec![
            vec![1, 2],
            vec![2, 1],
            vec![2, 2],
            vec![2, 3],
            vec![3, 2]
        ])
    ); // 8
    println!(
        "{}",
        min_moves(vec![
            vec![0, 0],
            vec![1, 3],
            vec![4, 1],
            vec![2, 4],
            vec![2, 0]
        ])
    ); // 3
}
