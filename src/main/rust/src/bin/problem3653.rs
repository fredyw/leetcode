// https://leetcode.com/problems/xor-after-range-multiplication-queries-i/description/
pub fn xor_after_queries(mut nums: Vec<i32>, queries: Vec<Vec<i32>>) -> i32 {
    for query in &queries {
        let l = query[0];
        let r = query[1];
        let k = query[2];
        let v = query[3] as i64;
        let mut i = l;
        while i <= r {
            nums[i as usize] = ((nums[i as usize] as i64 * v) % 1_000_000_007) as i32;
            i += k;
        }
    }
    nums.into_iter().reduce(|acc, x| acc ^ x).unwrap()
}

fn main() {
    println!(
        "{}",
        xor_after_queries(vec![1, 1, 1], vec![vec![0, 2, 1, 4]])
    ); // 4
    println!(
        "{}",
        xor_after_queries(
            vec![2, 3, 1, 5, 4],
            vec![vec![1, 4, 2, 3], vec![0, 2, 1, 2]]
        )
    ); // 31
}
