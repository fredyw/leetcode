// https://leetcode.com/problems/apple-redistribution-into-boxes/description/
pub fn minimum_boxes(apple: Vec<i32>, mut capacity: Vec<i32>) -> i32 {
    let mut sum: i32 = apple.iter().sum();
    capacity.sort_by(|a, b| b.cmp(a));
    let mut answer = 0;
    for c in capacity.into_iter() {
        if sum > 0 {
            answer += 1;
        }
        sum -= c;
    }
    answer
}

fn main() {
    // println!("{}", minimum_boxes(vec![1, 3, 2], vec![4, 3, 1, 5, 2])); // 2
    // println!("{}", minimum_boxes(vec![5, 5, 5], vec![2, 4, 2, 7])); // 4
    println!(
        "{}",
        minimum_boxes(vec![9, 8, 8, 2, 3, 1, 6], vec![10, 1, 4, 10, 8, 5])
    ); // 5
}
