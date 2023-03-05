// https://leetcode.com/problems/count-total-number-of-colored-cells/
pub fn colored_cells(n: i32) -> i64 {
    let mut answer: i64 = 1;
    let multiplier = 4;
    for i in 1..n {
        answer += i as i64 * multiplier;
    }
    answer
}

fn main() {
    println!("{}", colored_cells(1)); // 1
    println!("{}", colored_cells(2)); // 5
    println!("{}", colored_cells(3)); // 13
    println!("{}", colored_cells(4)); // 25
    println!("{}", colored_cells(5)); // 41
    println!("{}", colored_cells(6)); // 61
    println!("{}", colored_cells(7)); // 85
    println!("{}", colored_cells(8)); // 113
}
