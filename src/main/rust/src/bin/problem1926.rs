// https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/
pub fn nearest_exit(maze: Vec<Vec<char>>, entrance: Vec<i32>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        nearest_exit(
            vec![
                vec!['+', '+', '.', '+'],
                vec!['.', '.', '.', '+'],
                vec!['+', '+', '+', '.']
            ],
            vec![1, 2]
        )
    ); // 1
    println!(
        "{}",
        nearest_exit(
            vec![
                vec!['+', '+', '+'],
                vec!['.', '.', '.'],
                vec!['+', '+', '+']
            ],
            vec![1, 0]
        )
    ); // 2
    println!("{}", nearest_exit(vec![vec!['.', '+']], vec![0, 0])); // -1
}
