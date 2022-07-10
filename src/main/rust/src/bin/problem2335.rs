// https://leetcode.com/problems/minimum-amount-of-time-to-fill-cups/
pub fn fill_cups(amount: Vec<i32>) -> i32 {
    let mut answer = 0;
    let mut v = amount.clone();
    while v[0] > 0 || v[1] > 0 || v[2] > 0 {
        v.sort();
        v[1] -= 1;
        v[2] -= 1;
        answer += 1;
    }
    answer
}

fn main() {
    println!("{}", fill_cups(vec![1, 4, 2])); // 4
    println!("{}", fill_cups(vec![5, 4, 4])); // 7
    println!("{}", fill_cups(vec![5, 0, 0])); // 5
}
