// https://leetcode.com/problems/using-a-robot-to-print-the-lexicographically-smallest-string/description/
pub fn robot_with_string(s: String) -> String {
    let mut counts = vec![0; 26];
    for c in s.chars() {
        counts[(c as u8 - b'a') as usize] += 1;
    }
    let mut vec = vec![];
    let mut answer = String::new();
    let mut min = b'a';
    for c in s.chars() {
        vec.push(c);
        counts[(c as u8 - b'a') as usize] -= 1;
        while min != b'z' && counts[(min - b'a') as usize] == 0 {
            min += 1;
        }
        while !vec.is_empty() && vec.last().unwrap() <= &(min as char) {
            answer.push(vec.pop().unwrap());
        }
    }
    answer
}

fn main() {
    println!("{}", robot_with_string("zza".to_string())); // "azz"
    println!("{}", robot_with_string("bac".to_string())); // "abc"
    println!("{}", robot_with_string("bdda".to_string())); // "addb"
    println!("{}", robot_with_string("badc".to_string())); // "abcd"
    println!("{}", robot_with_string("bydizfve".to_string())); // "bdevfziy"
    println!("{}", robot_with_string("bzeyxf".to_string())); // "befxyz"
    println!("{}", robot_with_string("vzhofnpo".to_string())); // "fnohopzv"
    println!("{}", robot_with_string("mmuqezwmomeplrtskz".to_string())); // "eekstrlpmomwzqummz"
}
