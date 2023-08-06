// https://leetcode.com/problems/faulty-keyboard/
pub fn final_string(s: String) -> String {
    let mut answer: Vec<char> = vec![];
    let chars: Vec<char> = s.chars().collect();
    let mut i = 0;
    let mut j = 0;
    while j < chars.len() {
        if chars[j] == 'i' {
            let mut count = 0;
            let mut k = j;
            while k < chars.len() && chars[k] == 'i' {
                count += 1;
                k += 1;
            }
            let v = &mut chars[i..j].to_vec();
            if count % 2 != 0 {
                v.reverse();
                answer.append(v);
            } else {
                answer.append(v);
            }
            j = k;
            i = k;
        } else {
            j += 1;
        }
    }
    answer.append(&mut chars[i..j].to_vec());
    answer.into_iter().collect()
}

fn main() {
    println!("{}", final_string("string".to_string())); // "rtsng"
    println!("{}", final_string("poiinter".to_string())); // "ponter"
    println!("{}", final_string("abcdef".to_string())); // "abcdef"
    println!("{}", final_string("viwif".to_string())); // "wvf"
}
