// https://leetcode.com/problems/check-if-digits-are-equal-in-string-after-operations-i/description/
pub fn has_same_digits(s: String) -> bool {
    let mut v: Vec<u8> = s.bytes().collect();
    while v.len() > 2 {
        let mut tmp = vec![];
        for i in 0..v.len() - 1 {
            tmp.push((v[i] + v[i + 1]) % 10);
        }
        v = tmp;
    }
    v[0] == v[1]
}

fn main() {
    println!("{}", has_same_digits("3902".to_string())); // true
    println!("{}", has_same_digits("34789".to_string())); // false
}
