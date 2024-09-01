// https://leetcode.com/problems/hash-divided-string/description/
pub fn string_hash(s: String, k: i32) -> String {
    let mut answer = String::new();
    let bytes = s.as_bytes();
    let mut i = 0;
    while i < bytes.len() {
        let sum: u32 = bytes[i..i + k as usize]
            .iter()
            .map(|b| *b as u32 - 'a' as u32)
            .sum::<u32>()
            % 26;
        answer.push(char::from_u32(sum + 'a' as u32).unwrap());
        i += k as usize;
    }
    answer
}

fn main() {
    println!("{}", string_hash("abcd".to_string(), 2)); // "bf"
    println!("{}", string_hash("mxz".to_string(), 3)); // "i"
    println!(
        "{}",
        string_hash("dvbcofdbzqnurkoelcrdgvrxycohbqnhhkl".to_string(), 35)
    ); // "r"
}
