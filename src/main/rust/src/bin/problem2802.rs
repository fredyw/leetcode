// https://leetcode.com/problems/find-the-k-th-lucky-number/description/
pub fn kth_lucky_number(k: i32) -> String {
    fn kth_lucky_number(chars: &mut Vec<char>, i: usize, k: u32, kth: &mut u32) -> String {
        if *kth == k {
            return chars.iter().collect();
        }
        if i == chars.len() {
            *kth += 1;
            return "".to_string();
        }
        for char in ['4', '7'] {
            chars[i] = char;
            let s = kth_lucky_number(chars, i + 1, k, kth);
            if !s.is_empty() {
                return s;
            }
        }
        "".to_string()
    }

    let mut n = 1;
    let mut kth = 0;
    while kth < k as u32 {
        kth += 2u32.pow(n);
        n += 1;
    }
    kth -= 2u32.pow(n - 1);
    kth += 1;
    kth_lucky_number(&mut vec!['4'; n as usize - 1], 0, k as u32, &mut kth)
}

fn main() {
    // println!("{}", kth_lucky_number(4)); // "47"
    // println!("{}", kth_lucky_number(6)); // "77"
    // println!("{}", kth_lucky_number(10)); // "477"
    // println!("{}", kth_lucky_number(20)); // "4747"
    // println!("{}", kth_lucky_number(100)); // "744747"
    // println!("{}", kth_lucky_number(1000)); // "777747447"
    println!("{}", kth_lucky_number(1000000000)); // "77477744774747744747444444447"
}
