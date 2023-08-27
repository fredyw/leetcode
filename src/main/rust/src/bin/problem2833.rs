// https://leetcode.com/problems/furthest-point-from-origin/
pub fn furthest_distance_from_origin(moves: String) -> i32 {
    let mut answer: i32 = 0;
    let chars: Vec<char> = moves.chars().collect();
    let mut left_count = 0;
    let mut right_count = 0;
    for c in chars.iter() {
        if *c == 'L' {
            left_count += 1;
        } else if *c == 'R' {
            right_count += 1;
        }
    }
    for c in chars.into_iter() {
        if c == 'L' {
            answer -= 1;
        } else if c == 'R' {
            answer += 1;
        } else {
            if left_count < right_count {
                answer += 1;
            } else {
                answer -= 1;
            }
        }
    }
    answer.abs()
}

fn main() {
    println!("{}", furthest_distance_from_origin("L_RL__R".to_string())); // 3
    println!("{}", furthest_distance_from_origin("_R__LL_".to_string())); // 5
    println!("{}", furthest_distance_from_origin("_______".to_string())); // 7
    println!("{}", furthest_distance_from_origin("R_".to_string())); // 2
}
