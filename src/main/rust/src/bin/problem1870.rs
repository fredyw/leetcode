// https://leetcode.com/problems/minimum-speed-to-arrive-on-time/
pub fn min_speed_on_time(dist: Vec<i32>, hour: f64) -> i32 {
    fn is_possible(dist: &Vec<i32>, hour: f64, speed: i32) -> bool {
        let mut sum: f64 = 0.0;
        for (i, d) in dist.into_iter().enumerate() {
            if i == dist.len() - 1 {
                sum += *d as f64 / speed as f64;
            } else {
                sum += (*d as f64 / speed as f64).ceil();
            }
            if sum > hour {
                return false;
            }
        }
        true
    }

    let mut answer = i32::MAX;
    let mut start = 1;
    let mut end = i32::MAX as i64;
    while start <= end {
        let mid = start + ((end - start) / 2);
        if is_possible(&dist, hour, mid as i32) {
            answer = answer.min(mid as i32);
            end = mid - 1;
        } else {
            start = mid + 1;
        }
    }
    if answer == i32::MAX {
        -1
    } else {
        answer
    }
}

fn main() {
    println!("{}", min_speed_on_time(vec![1, 3, 2], 6.0)); // 1
    println!("{}", min_speed_on_time(vec![1, 3, 2], 2.7)); // 3
    println!("{}", min_speed_on_time(vec![1, 3, 2], 1.9)); // -1
}
