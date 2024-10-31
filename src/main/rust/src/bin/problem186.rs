// https://leetcode.com/problems/reverse-words-in-a-string-ii/description/
pub fn reverse_words(s: &mut Vec<char>) {
    s.reverse();
    let mut i = 0;
    let mut j = 0;
    while j < s.len() {
        if s[j] == ' ' {
            let _ = &s[i..j].reverse();
            i = j + 1;
        }
        j += 1;
    }
    let _ = &s[i..j].reverse();
}

fn main() {
    let mut v = vec![
        't', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e',
    ];
    reverse_words(&mut v);
    println!("{:?}", v); // ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]

    let mut v = vec!['a'];
    reverse_words(&mut v);
    println!("{:?}", v); // ["a"]
}
