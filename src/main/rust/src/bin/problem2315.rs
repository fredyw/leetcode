// https://leetcode.com/problems/count-asterisks/
pub fn count_asterisks(s: String) -> i32 {
    todo!()
}

fn main() {
    println!("{}", count_asterisks(String::from("l|*e*et|c**o|*de|"))); // 2
    println!("{}", count_asterisks(String::from("iamprogrammer"))); // 0
    println!(
        "{}",
        count_asterisks(String::from("yo|uar|e**|b|e***au|tifu|l"))
    ); // 5
}
