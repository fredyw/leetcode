// https://leetcode.com/problems/count-asterisks/
pub fn count_asterisks(s: String) -> i32 {
    let mut answer = 0;
    let mut j = 0;
    for i in s.split("|") {
        if j % 2 != 0 {
            j += 1;
            continue;
        }
        answer += (i.chars().filter(|a| *a == '*').count()) as i32;
        j += 1;
    }
    answer
}

fn main() {
    println!("{}", count_asterisks(String::from("l|*e*et|c**o|*de|"))); // 2
    println!("{}", count_asterisks(String::from("iamprogrammer"))); // 0
    println!(
        "{}",
        count_asterisks(String::from("yo|uar|e**|b|e***au|tifu|l"))
    ); // 5
}
