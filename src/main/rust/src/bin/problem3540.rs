// https://leetcode.com/problems/minimum-time-to-visit-all-houses/description/
pub fn min_total_time(forward: Vec<i32>, backward: Vec<i32>, queries: Vec<i32>) -> i64 {
    fn forward_time(forward_sum: &Vec<i32>, from: i32, to: i32) -> i64 {
        if from == to {
            return 0;
        }
        if from < to {
            return forward_sum[to as usize - 1] as i64
                - if from - 1 < 0 {
                    0
                } else {
                    forward_sum[from as usize - 1] as i64
                };
        }
        forward_sum[forward_sum.len() - 1] as i64
            - if from - 1 < 0 {
                0
            } else {
                forward_sum[from as usize - 1] as i64
            }
            + if to - 1 < 0 {
                0
            } else {
                forward_sum[to as usize - 1] as i64
            }
    }

    fn backward_time(backward_sum: &Vec<i32>, from: i32, to: i32) -> i64 {
        if from == to {
            return 0;
        }
        if from < to {
            return backward_sum[to as usize - 1] as i64
                - if from - 1 < 0 {
                    0
                } else {
                    backward_sum[from as usize - 1] as i64
                };
        }
        backward_sum[backward_sum.len() - 1] as i64
            - if from - 1 < 0 {
                0
            } else {
                backward_sum[from as usize - 1] as i64
            }
            + if to - 1 < 0 {
                0
            } else {
                backward_sum[to as usize - 1] as i64
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
    println!("{:?}", forward_sum);
    let mut backward_sum: Vec<i32> = vec![0; backward.len()];
    for i in (0..backward.len()).rev() {
        if i == backward.len() - 1 {
            backward_sum[i] = backward[i];
        } else {
            backward_sum[i] = backward_sum[i + 1] + backward[i];
        }
    }
    println!("{:?}", backward_sum);
    let mut answer = 0;
    let mut from = 0;
    for to in queries {
        let min = forward_time(&forward_sum, from, to).min(backward_time(&backward_sum, from, to));
        answer += min;
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
