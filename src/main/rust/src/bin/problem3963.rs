// https://leetcode.com/problems/create-grid-with-exactly-one-path/description/
pub fn create_grid(m: i32, n: i32) -> Vec<String> {
    let mut answer: Vec<Vec<char>> = vec![vec!['.'; n as usize]; m as usize];
    answer
        .into_iter()
        .map(|char_vec| char_vec.into_iter().collect::<String>())
        .collect()
}

fn main() {
    println!("{:?}", create_grid(2, 3)); // ["..#","#.."]
    println!("{:?}", create_grid(3, 3)); // ["..#","#..","##."]
    println!("{:?}", create_grid(1, 4)); // ["...."]
}
