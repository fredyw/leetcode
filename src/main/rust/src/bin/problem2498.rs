// https://leetcode.com/problems/frog-jump-ii/
pub fn max_jump(stones: Vec<i32>) -> i32 {
    if stones.len() == 2 {
        return stones[1] - stones[0];
    }
    let mut answer = 0;
    let mut i = 0;
    while i < stones.len() - 2 {
        let diff = stones[i + 2] - stones[i];
        answer = answer.max(diff);
        i += 2;
    }
    let mut i = if stones.len() % 2 == 0 {
        stones.len() - 1
    } else {
        stones.len() - 2
    };
    while i as i32 - 2 >= 0 {
        let diff = stones[i] - stones[i - 2];
        answer = answer.max(diff);
        i -= 2;
    }
    answer
}

fn main() {
    println!("{}", max_jump(vec![0, 2, 5, 6, 7])); // 5
    println!("{}", max_jump(vec![0, 3, 9])); // 9
    println!("{}", max_jump(vec![0, 5])); // 5
    println!("{}", max_jump(vec![0, 2, 5, 9])); // 7
}
