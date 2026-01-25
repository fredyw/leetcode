// https://leetcode.com/problems/good-indices-in-a-digit-string/description/
pub fn good_indices(s: String) -> Vec<i32> {
    let chars: Vec<char> = s.chars().collect();
    let mut answer = vec![];
    for i in 0..chars.len() {
        let digits = i.checked_ilog10().unwrap_or(0) + 1;
        let from = (i as isize - digits as isize + 1) as usize;
        let to = i;
        let sub: String = chars[from..=to].iter().collect();
        if sub == i.to_string() {
            answer.push(i as i32);
        }
    }
    answer
}

fn main() {
    println!("{:?}", good_indices("0234567890112".to_string())); // [0,11,12]]
    println!("{:?}", good_indices("01234".to_string())); // [0,1,2,3,4]
    println!("{:?}", good_indices("12345".to_string())); // []
}
