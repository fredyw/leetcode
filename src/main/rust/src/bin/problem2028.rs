// https://leetcode.com/problems/find-missing-observations/
pub fn missing_rolls(rolls: Vec<i32>, mean: i32, n: i32) -> Vec<i32> {
    let m = rolls.len() as i32;
    let sum: i32 = rolls.into_iter().sum();
    let missing = (mean * (n + m)) - sum;
    if missing > 6 * n || missing <= 0 || missing < n {
        return vec![];
    }
    let mut answer: Vec<i32> = vec![missing / n; n as usize];
    for i in 0..(missing % n) {
        answer[i as usize] += 1;
    }
    answer
}

fn main() {
    println!("{:?}", missing_rolls(vec![3, 2, 4, 3], 4, 2)); // [6,6]
    println!("{:?}", missing_rolls(vec![1, 5, 6], 3, 4)); // [2,3,2,2]
    println!("{:?}", missing_rolls(vec![1, 2, 3, 4], 6, 4)); // []
    println!("{:?}", missing_rolls(vec![6, 3, 4, 3, 5, 3], 1, 6)); // []
    println!(
        "{:?}",
        missing_rolls(
            vec![
                4, 5, 6, 2, 3, 6, 5, 4, 6, 4, 5, 1, 6, 3, 1, 4, 5, 5, 3, 2, 3, 5, 3, 2, 1, 5, 4, 3,
                5, 1, 5
            ],
            4,
            40
        )
    ); // [5,4,4,4,4,4,4,4,4,4,4,4,4,5,5,4,4,4,4,4,5,4,4,4,4,4,4,5,4,5,4,4,4,4,5,4,4,4,4,4]
}
