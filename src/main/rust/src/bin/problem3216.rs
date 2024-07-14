// https://leetcode.com/problems/lexicographically-smallest-string-after-a-swap/description/
pub fn get_smallest_string(s: String) -> String {
    let mut answer: Vec<char> = s.chars().collect();
    for i in 0..answer.len() - 1 {
        let current = answer[i].to_digit(10).unwrap();
        let next = answer[i + 1].to_digit(10).unwrap();
        if current % 2 == 0 && next % 2 == 0 {
            if current > next {
                answer.swap(i, i + 1);
                break;
            }
        } else if current % 2 != 0 && next % 2 != 0 {
            if current > next {
                answer.swap(i, i + 1);
                break;
            }
        }
    }
    answer.into_iter().collect()
}

fn main() {
    println!("{}", get_smallest_string("45320".to_string())); // "43520"
    println!("{}", get_smallest_string("001".to_string())); // "001"
    println!("{}", get_smallest_string("453201".to_string())); // "435201"
}
