// https://leetcode.com/problems/palindrome-permutation-ii/description/
pub fn generate_palindromes(s: String) -> Vec<String> {
    todo!()
}

fn main() {
    println!("{:?}", generate_palindromes("aabb".to_string())); // ["abba","baab"]
    println!("{:?}", generate_palindromes("abc".to_string())); // []
    println!("{:?}", generate_palindromes("aaabbb".to_string())); // []
    println!("{:?}", generate_palindromes("aabbc".to_string())); // ["abcba","bacab"]
    println!("{:?}", generate_palindromes("aaaabbbb".to_string())); // ["aabbbbaa","ababbaba","abbaabba","baabbaab","babaabab","bbaaaabb"]
}
