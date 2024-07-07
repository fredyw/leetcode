// https://leetcode.com/problems/alternating-groups-i/description/
pub fn number_of_alternating_groups(colors: Vec<i32>) -> i32 {
    let mut answer = 0;
    let mut n = 0;
    let mut i = 0;
    while n < colors.len() {
        let prev_idx = if i == 0 { colors.len() - 1 - i } else { i - 1 };
        let next_idx = (i + 1) % colors.len();
        if colors[prev_idx] != colors[i] && colors[i] != colors[next_idx] {
            answer += 1;
        }
        i = next_idx;
        n += 1;
    }
    answer
}

fn main() {
    println!("{}", number_of_alternating_groups(vec![1, 1, 1])); // 0
    println!("{}", number_of_alternating_groups(vec![0, 1, 0, 0, 1])); // 3
}
