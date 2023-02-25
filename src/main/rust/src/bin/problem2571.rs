// https://leetcode.com/problems/minimum-operations-to-reduce-an-integer-to-0/
pub fn min_operations(n: i32) -> i32 {
    let mut bin: Vec<char> = format!("{:b}", n)
        .chars()
        .collect::<Vec<char>>()
        .into_iter()
        .rev()
        .collect();
    let mut answer = 0;
    let mut i = 0;
    while i < bin.len() {
        let mut j = i;
        let mut count = 0;
        while j < bin.len() && bin[j] == '1' {
            count += 1;
            j += 1;
        }
        if count > 1 {
            if j == bin.len() {
                answer += 1;
            } else {
                bin[j] = '1';
            }
            answer += 1;
        } else if count == 1 {
            answer += 1;
        } else {
            j += 1;
        }
        i = j;
    }
    answer
}

fn main() {
    println!("{}", min_operations(39)); // 3
    println!("{}", min_operations(54)); // 3
    println!("{}", min_operations(5)); // 2
    println!("{}", min_operations(9)); // 2
}
