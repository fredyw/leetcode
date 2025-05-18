// https://leetcode.com/problems/minimum-time-to-visit-all-houses/description/
pub fn min_total_time(forward: Vec<i32>, backward: Vec<i32>, queries: Vec<i32>) -> i64 {
    fn value_or_zero(v: &Vec<i32>, index: i32) -> i64 {
        if index < 0 || index as usize >= v.len() {
            0
        } else {
            v[index as usize] as i64
        }
    }

    fn forward_time(forward_sum: &Vec<i32>, from: i32, to: i32) -> i64 {
        if from == to {
            0
        } else if from < to {
            value_or_zero(forward_sum, to - 1) - value_or_zero(forward_sum, from - 1)
        } else {
            value_or_zero(forward_sum, forward_sum.len() as i32 - 1)
                - value_or_zero(forward_sum, from - 1)
                + value_or_zero(forward_sum, to - 1)
        }
    }

    fn backward_time(backward_sum: &Vec<i32>, from: i32, to: i32) -> i64 {
        if from == to {
            0
        } else if from > to {
            value_or_zero(backward_sum, to + 1) - value_or_zero(backward_sum, from + 1)
        } else {
            value_or_zero(backward_sum, 0) - value_or_zero(backward_sum, from + 1)
                + value_or_zero(backward_sum, to + 1)
        }
    }

    let mut forward_sum: Vec<i32> = vec![0; forward.len()];
    for i in 0..forward.len() {
        if i == 0 {
            forward_sum[i] = forward[i];
        } else {
            forward_sum[i] = forward_sum[i - 1] + forward[i];
        }
    }
    let mut backward_sum: Vec<i32> = vec![0; backward.len()];
    for i in (0..backward.len()).rev() {
        if i == backward.len() - 1 {
            backward_sum[i] = backward[i];
        } else {
            backward_sum[i] = backward_sum[i + 1] + backward[i];
        }
    }
    let mut answer = 0;
    let mut from = 0;
    for to in queries {
        answer += forward_time(&forward_sum, from, to).min(backward_time(&backward_sum, from, to));
        from = to;
    }
    answer
}

fn main() {
    println!(
        "{}",
        min_total_time(vec![1, 4, 4], vec![4, 1, 2], vec![1, 2, 0, 2])
    ); // 12
    println!(
        "{}",
        min_total_time(vec![1, 1, 1, 1], vec![2, 2, 2, 2], vec![1, 2, 3, 0])
    ); // 4
}
