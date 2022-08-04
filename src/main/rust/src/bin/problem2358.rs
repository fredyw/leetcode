// https://leetcode.com/problems/maximum-number-of-groups-entering-a-competition/
pub fn maximum_groups(grades: Vec<i32>) -> i32 {
    let mut answer = 0;
    let mut i = 1;
    let mut j = i;
    while j <= grades.len() {
        i += 1;
        j += i;
        answer += 1;
    }
    answer
}

fn main() {
    println!("{}", maximum_groups(vec![10, 6, 12, 7, 3, 5])); // 3
    println!("{}", maximum_groups(vec![8, 8])); // 1
    println!("{}", maximum_groups(vec![1, 1, 1, 1, 1])); // 2
    println!("{}", maximum_groups(vec![1, 3, 5, 6, 1])); // 2
    println!("{}", maximum_groups(vec![1, 3, 5, 6, 1, 1])); // 3
}
