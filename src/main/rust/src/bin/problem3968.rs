// https://leetcode.com/problems/maximum-manhattan-distance-after-all-moves/description/
pub fn max_distance(moves: String) -> i32 {
    let mut underscores = 0;
    let mut x: i32 = 0;
    let mut y: i32 = 0;
    for c in moves.chars() {
        match c {
            'U' => y += 1,
            'D' => y -= 1,
            'L' => x -= 1,
            'R' => x += 1,
            _ => underscores += 1,
        }
    }
    x.abs() + y.abs() + underscores
}

fn main() {
    println!("{}", max_distance("L_D_".to_string())); // 4
    println!("{}", max_distance("U_R".to_string())); // 3
}
