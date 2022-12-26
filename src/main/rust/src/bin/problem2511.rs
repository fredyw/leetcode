// https://leetcode.com/problems/maximum-enemy-forts-that-can-be-captured/
pub fn capture_forts(forts: Vec<i32>) -> i32 {
    let mut answer = 0;
    let mut fort_count = 0;
    let mut has_one = false;
    let mut has_minus_one = false;
    for i in 0..forts.len() {
        if forts[i] == 1 {
            if has_minus_one {
                answer = answer.max(fort_count);
            }
            has_one = true;
            has_minus_one = false;
            fort_count = 0;
        } else if forts[i] == 0 {
            fort_count += 1;
        } else {
            if has_one {
                answer = answer.max(fort_count);
            }
            has_minus_one = true;
            has_one = false;
            fort_count = 0;
        }
    }
    answer
}

fn main() {
    println!("{}", capture_forts(vec![1, 0, 0, -1, 0, 0, 0, 0, 1])); // 4
    println!("{}", capture_forts(vec![0, 0, 1, -1])); // 0
    println!("{}", capture_forts(vec![1, 0, 0, -1, 0, 0, 0, 0, -1, 0, 1])); // 2
    println!(
        "{}",
        capture_forts(vec![1, 0, 0, 1, -1, 0, 0, 0, 0, -1, 0, 1])
    ); // 1
}
