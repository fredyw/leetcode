// https://leetcode.com/problems/minimum-penalty-for-a-shop/
pub fn best_closing_time(customers: String) -> i32 {
    let customers: Vec<char> = customers.chars().into_iter().collect();
    let mut prefix_sums: Vec<i32> = vec![0; customers.len() + 1];
    for i in 0..customers.len() {
        prefix_sums[i + 1] =
            if i == 0 { 0 } else { prefix_sums[i] } + if customers[i] == 'N' { 1 } else { 0 };
    }
    let mut suffix_sums: Vec<i32> = vec![0; customers.len() + 1];
    for i in (0..customers.len()).rev() {
        suffix_sums[i] = if i == customers.len() - 1 {
            0
        } else {
            suffix_sums[i + 1]
        } + if customers[i] == 'Y' { 1 } else { 0 };
    }
    let mut answer = 0;
    let mut min = 0;
    for i in 0..prefix_sums.len() {
        if i == 0 {
            min = prefix_sums[i] + suffix_sums[i];
        } else if min > prefix_sums[i] + suffix_sums[i] {
            min = prefix_sums[i] + suffix_sums[i];
            answer = i;
        }
    }
    answer as i32
}

fn main() {
    println!("{}", best_closing_time("YYNY".to_string())); // 2
    println!("{}", best_closing_time("NNNNN".to_string())); // 0
    println!("{}", best_closing_time("YYYY".to_string())); // 4
}
