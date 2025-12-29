// https://leetcode.com/problems/sum-of-increasing-product-blocks/description/
pub fn sum_of_blocks(n: i32) -> i32 {
    let mut answer: i64 = 0;
    let mut num = 0;
    for count in 1..=n {
        let mut product: i64 = 1;
        for _ in 0..count {
            num += 1;
            product = (product * num) % 1_000_000_007;
        }
        answer += product;
    }
    (answer % 1_000_000_007) as i32
}

fn main() {
    println!("{}", sum_of_blocks(3)); // 127
    println!("{}", sum_of_blocks(7)); // 6997165
    println!("{}", sum_of_blocks(1000)); // 587219233
}
