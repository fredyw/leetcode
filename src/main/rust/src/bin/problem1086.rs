use std::cmp::Ordering;

// https://leetcode.com/problems/high-five/description/
pub fn high_five(mut items: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
    items.sort_by(|a, b| {
        let cmp = a[0].cmp(&b[0]);
        if cmp == Ordering::Equal {
            b[1].cmp(&a[1])
        } else {
            cmp
        }
    });
    let mut answer = vec![];
    let mut i = 0;
    while i < items.len() {
        let val = items[i][0];
        let mut sum = 0;
        for _ in 0..5 {
            sum += items[i][1];
            i += 1;
        }
        let avg = sum / 5;
        answer.push(vec![val, avg]);
        while i < items.len() && val == items[i][0] {
            i += 1;
        }
    }
    answer
}

fn main() {
    println!(
        "{:?}",
        high_five(vec![
            vec![1, 91],
            vec![1, 92],
            vec![2, 93],
            vec![2, 97],
            vec![1, 60],
            vec![2, 77],
            vec![1, 65],
            vec![1, 87],
            vec![1, 100],
            vec![2, 100],
            vec![2, 76]
        ])
    ); // [[1,87],[2,88]]
    println!(
        "{:?}",
        high_five(vec![
            vec![1, 100],
            vec![7, 100],
            vec![1, 100],
            vec![7, 100],
            vec![1, 100],
            vec![7, 100],
            vec![1, 100],
            vec![7, 100],
            vec![1, 100],
            vec![7, 100]
        ])
    ); // [[1,100],[7,100]]
}
