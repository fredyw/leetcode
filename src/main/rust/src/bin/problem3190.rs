// https://leetcode.com/problems/find-minimum-operations-to-make-all-elements-divisible-by-three/description/
pub fn minimum_operations(nums: Vec<i32>) -> i32 {
    let mut answer = 0;
    for num in nums {
        if num % 3 == 0 {
            continue;
        }
        let n = num / 3;
        let a = (num - (n * 3)).abs();
        let b = (num - ((n + 1) * 3)).abs();
        answer += a.min(b);
    }
    answer
}

fn main() {
    println!("{}", minimum_operations(vec![1, 2, 3, 4])); // 3
    println!("{}", minimum_operations(vec![1, 2, 3, 4, 5])); // 4
    println!("{}", minimum_operations(vec![3, 6, 9])); // 0
}
