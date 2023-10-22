// https://leetcode.com/problems/minimum-processing-time/description/
pub fn min_processing_time(mut processor_time: Vec<i32>, mut tasks: Vec<i32>) -> i32 {
    processor_time.sort();
    tasks.sort();
    let mut answer = 0;
    let mut j = 0;
    for start in processor_time.iter().rev() {
        let mut max = 0;
        for _i in 0..4 {
            max = max.max(start + tasks[j]);
            j += 1;
        }
        answer = answer.max(max);
    }
    answer
}

fn main() {
    println!(
        "{}",
        min_processing_time(vec![8, 10], vec![2, 2, 3, 1, 8, 7, 4, 5])
    ); // 16
    println!(
        "{}",
        min_processing_time(vec![10, 20], vec![2, 3, 1, 2, 5, 8, 4, 3])
    ); // 23
}
