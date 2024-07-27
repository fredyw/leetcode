// https://leetcode.com/problems/find-k-length-substrings-with-no-repeated-characters/description/
pub fn num_k_len_substr_no_repeats(s: String, k: i32) -> i32 {
    let mut answer = 0;
    let chars: Vec<char> = s.chars().collect();
    let mut set: Vec<bool> = vec![false; 26];
    let mut i = 0;
    let mut j = 0;
    let mut n = 0;
    while i < chars.len() {
        if n >= k || set[chars[i] as usize - 'a' as usize] {
            set[chars[j] as usize - 'a' as usize] = false;
            j += 1;
            n -= 1;
        } else {
            set[chars[i] as usize - 'a' as usize] = true;
            i += 1;
            n += 1;
        }
        if n == k {
            answer += 1;
        }
    }
    answer
}

fn main() {
    println!(
        "{}",
        num_k_len_substr_no_repeats("havefunonleetcode".to_string(), 5)
    ); // 6
    println!("{}", num_k_len_substr_no_repeats("home".to_string(), 5)); // 0
    println!(
        "{}",
        num_k_len_substr_no_repeats(
            "bgfikghkcebcabhkdghlgkhhcbjdjfclgfafhibikbedbfdkifejahcadehlhilegcacgcjijeklihcf"
                .to_string(),
            5
        )
    ); // 31
}
