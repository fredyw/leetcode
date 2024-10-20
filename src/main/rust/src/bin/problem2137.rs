// https://leetcode.com/problems/pour-water-between-buckets-to-make-water-levels-equal/description/
pub fn equalize_water(mut buckets: Vec<i32>, loss: i32) -> f64 {
    buckets.sort();
    let mut left = buckets[0] as f64;
    let mut right = buckets[buckets.len() - 1] as f64;
    while left + 0.00000001 < right {
        let mid = (left + right) / 2.0;
        let mut need = 0.0;
        for &bucket in &buckets {
            let bucket = bucket as f64;
            let diff = mid - bucket;
            need += if diff >= 0.0 {
                diff
            } else {
                diff - (diff * (loss as f64 / 100.0))
            };
        }
        if need <= 0.0 {
            left = mid;
        } else {
            right = mid;
        }
    }
    left
}

fn main() {
    println!("{}", equalize_water(vec![1, 2, 7], 80)); // 2.00000
    println!("{}", equalize_water(vec![2, 4, 6], 50)); // 3.50000
    println!("{}", equalize_water(vec![3, 3, 3, 3], 40)); // 3.00000
    println!("{}", equalize_water(vec![1, 2, 3, 4], 20)); // 2.38889
}
