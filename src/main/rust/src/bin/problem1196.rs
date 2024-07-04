// https://leetcode.com/problems/how-many-apples-can-you-put-into-the-basket/description/
pub fn max_number_of_apples(mut weight: Vec<i32>) -> i32 {
    weight.sort();
    let mut answer = 0;
    let mut n = 5000;
    let mut i = 0;
    while i < weight.len() && n - weight[i] >= 0 {
        n -= weight[i];
        i += 1;
        answer += 1;
    }
    answer
}

fn main() {
    println!("{}", max_number_of_apples(vec![100, 200, 150, 1000])); // 4
    println!(
        "{}",
        max_number_of_apples(vec![900, 950, 800, 1000, 700, 800])
    ); // 5
}
