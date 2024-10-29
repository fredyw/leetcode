// https://leetcode.com/problems/the-knights-tour/description/
pub fn tour_of_knight(m: i32, n: i32, r: i32, c: i32) -> Vec<Vec<i32>> {
    let mut answer: Vec<Vec<i32>> = vec![vec![-1; n as usize]; m as usize];
    answer
}

fn main() {
    println!("{:?}", tour_of_knight(1, 1, 0, 0)); // [[0]]
    println!("{:?}", tour_of_knight(3, 4, 0, 0)); // [[0,3,6,9],[11,8,1,4],[2,5,10,7]]
}
