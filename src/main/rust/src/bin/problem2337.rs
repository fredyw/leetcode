// https://leetcode.com/problems/move-pieces-to-obtain-a-string/
pub fn can_change(start: String, target: String) -> bool {
    fn swap(v: &mut Vec<char>, i: usize, j: usize) {
        let tmp = v[i];
        v[i] = v[j];
        v[j] = tmp;
    }

    let mut start: Vec<char> = start.chars().into_iter().collect();
    let target: Vec<char> = target.chars().into_iter().collect();
    let mut i = 0;
    let mut j = 0;
    while i < target.len() {
        if start[i] != target[i] {
            if target[i] == 'L' {
                if start[i] != '_' {
                    return false;
                }
                while j < start.len() && start[j] == '_' {
                    j += 1;
                }
                if j == start.len() || start[j] != 'L' {
                    return false;
                }
                swap(&mut start, i, j);
            } else if target[i] == 'R' {
                return false;
            } else {
                if start[i] != 'R' {
                    return false;
                }
                while j < start.len() && start[j] == 'R' {
                    j += 1;
                }
                if j == start.len() || start[j] != '_' {
                    return false;
                }
                swap(&mut start, i, j);
            }
        }
        i += 1;
        j = j.max(i);
    }
    true
}

fn main() {
    println!(
        "{}",
        can_change(String::from("_L__R__R_"), String::from("L______RR"))
    ); // true
    println!("{}", can_change(String::from("R_L_"), String::from("__LR"))); // false
    println!("{}", can_change(String::from("_R"), String::from("R_"))); // false
    println!("{}", can_change(String::from("LLLR"), String::from("LRRR"))); // false
    println!(
        "{}",
        can_change(String::from("__L_R_L_R__"), String::from("L___RL_R___"))
    ); // false
    println!(
        "{}",
        can_change(String::from("__L_RL__R__"), String::from("L___RL_R___"))
    ); // false
    println!("{}", can_change(String::from("_"), String::from("L"))); // false
}
