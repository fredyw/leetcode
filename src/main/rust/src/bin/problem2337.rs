// https://leetcode.com/problems/move-pieces-to-obtain-a-string/
pub fn can_change(start: String, target: String) -> bool {
    todo!()
}

fn main() {
    println!(
        "{}",
        can_change(String::from("_L__R__R_"), String::from("L______RR"))
    ); // true
    println!("{}", can_change(String::from("R_L_"), String::from("__LR"))); // true
    println!("{}", can_change(String::from("_R"), String::from("R_"))); // true
    println!("{}", can_change(String::from("LLLR"), String::from("LRRR"))); // false
    println!(
        "{}",
        can_change(String::from("__L_R_L_R__"), String::from("L___RL_R___"))
    ); // false
    println!(
        "{}",
        can_change(String::from("__L_RL__R__"), String::from("L___RL_R___"))
    ); // true
}
