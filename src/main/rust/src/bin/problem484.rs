// https://leetcode.com/problems/find-permutation/description/
pub fn find_permutation(s: String) -> Vec<i32> {
    let mut v: Vec<(char, i32)> = vec![];
    for char in s.chars() {
        if v.is_empty() {
            v.push((char, 1));
        } else {
            let (c, count) = v.last_mut().unwrap();
            if *c == char {
                *count += 1;
            } else {
                v.push((char, 1));
            }
        }
    }
    println!("{v:?}");
    let mut answer = vec![];
    answer.push(1);
    let mut i = 0;
    let mut n = 2;
    while i < v.len() {
        let (char, count) = v[i];
        if char == 'I' {
            let from = n;
            let to = n + count - 1;
            println!("I");
            println!("  before n: {n}");
            // println!("I --> from: {from}");
            // println!("I --> to: {to}");
            for j in from..to {
                n += 1;
                answer.push(j);
            }
            if i + 1 < v.len() {
                let next_count = v[i + 1].1;
                n += next_count;
                answer.push(n);
            } else {
                answer.push(n);
            }
            println!("  after n: {n}");
            println!("  answer: {:?}", answer);
        } else {
            let from = n - count;
            let to = n;
            println!("D:");
            println!("  before n: {n}");
            // println!("D --> from: {from}");
            // println!("D --> to: {to}");
            for j in (from..to).rev() {
                answer.push(j);
            }
            n += 1;
            println!("  after n: {n}");
            println!("  answer: {:?}", answer);
        }
        i += 1;
    }
    answer
}

fn main() {
    // println!("{:?}", find_permutation("I".to_string())); // [1,2]
    // println!("{:?}", find_permutation("DI".to_string())); // [2,1,3]
    // println!("{:?}", find_permutation("DIDIDIIIIDIIDID".to_string())); // [2,1,4,3,6,5,7,8,9,11,10,12,14,13,16,15]
    // println!("{:?}", find_permutation("IDDI".to_string())); // [1,4,3,2,5]
    // println!("{:?}", find_permutation("IIII".to_string())); // [1,2,3,4,5]
    // println!("{:?}", find_permutation("DDDD".to_string())); // [1,2,3,5,4]
    // println!("{:?}", find_permutation("IIIID".to_string())); // [1,2,3,4,6,5]
    // println!("{:?}", find_permutation("DDDDI".to_string())); // [5,4,3,2,1,6]
    // println!("{:?}", find_permutation("DIDIDI".to_string())); // [2,1,4,3,6,5,7]
    // println!("{:?}", find_permutation("IDIDID".to_string())); // [1,3,2,5,4,7,6]
    // println!("{:?}", find_permutation("DDDIIIDDD".to_string())); // [4,3,2,1,5,6,10,9,8,7]
    println!("{:?}", find_permutation("IIIDDDIII".to_string())); // [1,2,3,7,6,5,4,8,9,10]
}
