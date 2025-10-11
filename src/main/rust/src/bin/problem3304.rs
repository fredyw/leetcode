// https://leetcode.com/problems/find-the-k-th-character-in-string-game-i/description/
pub fn kth_character(k: i32) -> char {
    let mut v: Vec<char> = vec![];
    v.push('a');
    while (v.len() as i32) < k {
        let mut new_vec: Vec<char> = vec![];
        for i in v.iter() {
            new_vec.push(((*i as u8 + 1) % 'z' as u8) as char);
            if new_vec.len() + v.len() == k as usize {
                break;
            }
        }
        v.extend(new_vec);
    }
    v[k as usize - 1]
}

fn main() {
    println!("{:?}", kth_character(5)); // "b"
    println!("{:?}", kth_character(10)); // "c"
}
