// https://leetcode.com/problems/move-pieces-to-obtain-a-string/
pub fn can_change(start: String, target: String) -> bool {
    todo!()
}

fn main() {
    println!(
        "{}",
        can_change(String::from("_L__R__R_"), String::from("L______RR"))
    );
    println!("{}", can_change(String::from("R_L_"), String::from("__LR")));
    println!("{}", can_change(String::from("_R"), String::from("R_")));
}
