// https://leetcode.com/problems/reverse-words-in-a-string-ii/description/
pub fn reverse_words(s: &mut Vec<char>) {
    todo!()
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
