// https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together/description/
pub fn min_swaps(data: Vec<i32>) -> i32 {
    let mut total_one_count: i32 = 0;
    for n in data.iter() {
        if *n == 1 {
            total_one_count += 1;
        }
    }
    let mut answer = i32::MAX;
    let mut ones = 0;
    let mut i: usize = 0;
    while i < total_one_count as usize {
        if data[i] == 1 {
            ones += 1;
        }
        i += 1;
        answer = answer.min(total_one_count - ones);
    }
    for j in i..data.len() {
        if data[j - total_one_count as usize] == 1 {
            ones -= 1;
        }
        if data[j] == 1 {
            ones += 1;
        }
        answer = answer.min(total_one_count - ones);
    }
    answer
}

fn main() {
    println!("{}", min_swaps(vec![1, 0, 1, 0, 1])); // 1
    println!("{}", min_swaps(vec![0, 0, 0, 1, 0])); // 0
    println!("{}", min_swaps(vec![1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1])); // 3
}
