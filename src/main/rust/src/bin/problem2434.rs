// https://leetcode.com/problems/using-a-robot-to-print-the-lexicographically-smallest-string/description/
pub fn robot_with_string(s: String) -> String {
    todo!()
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
