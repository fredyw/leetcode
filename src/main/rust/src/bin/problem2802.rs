// https://leetcode.com/problems/find-the-k-th-lucky-number/description/
pub fn kth_lucky_number(k: i32) -> String {
    fn f(chars: &mut Vec<char>, i: usize) {
        if i == chars.len() {
            println!("{}", chars.iter().collect::<String>());
            return;
        }
        for char in ['4', '7'] {
            let tmp = chars[i];
            chars[i] = char;
            f(chars, i + 1);
        }
    }

    todo!()
}

fn main() {
    println!("{}", kth_lucky_number(4)); // "47"
    println!("{}", kth_lucky_number(10)); // "477"
    println!("{}", kth_lucky_number(1000)); // "777747447"
}
