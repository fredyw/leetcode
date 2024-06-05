// https://leetcode.com/problems/maximize-happiness-of-selected-children/description/
pub fn maximum_happiness_sum(mut happiness: Vec<i32>, mut k: i32) -> i64 {
    happiness.sort_by(|a, b| b.cmp(a));
    let mut answer: i64 = 0;
    let mut i = 0;
    let mut substract: i64 = 0;
    while i < happiness.len() && k > 0 {
        if happiness[i] as i64 - substract < 0 {
            break;
        }
        answer += happiness[i] as i64 - substract;
        substract += 1;
        k -= 1;
        i += 1;
    }
    answer
}

fn main() {
    println!("{}", maximum_happiness_sum(vec![1, 2, 3], 2)); // 4
    println!("{}", maximum_happiness_sum(vec![1, 1, 1, 1], 2)); // 1
    println!("{}", maximum_happiness_sum(vec![2, 3, 4, 5], 1)); // 5
}
