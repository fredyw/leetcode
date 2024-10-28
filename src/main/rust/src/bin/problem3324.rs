// https://leetcode.com/problems/find-the-sequence-of-strings-appeared-on-the-screen/description/
pub fn string_sequence(target: String) -> Vec<String> {
    let mut answer: Vec<String> = vec![];
    let target = target.as_bytes();
    let mut i = 0;
    answer.push("a".to_string());
    while i < target.len() {
        let prev = answer[answer.len() - 1].as_bytes();
        let mut new_string = answer[answer.len() - 1].clone();
        let mut last_char = prev[prev.len() - 1];
        while target[i] != last_char {
            last_char += 1;
            if last_char > 'z' as u8 {
                last_char = 'a' as u8;
            }
            new_string.pop();
            new_string.push(last_char as char);
            answer.push(new_string.clone());
        }
        if i + 1 < target.len() {
            new_string.push('a');
            answer.push(new_string);
        }
        i += 1;
    }
    answer
}

fn main() {
    println!("{:?}", string_sequence("abc".to_string())); // ["a","aa","ab","aba","abb","abc"]
    println!("{:?}", string_sequence("he".to_string())); // ["a","b","c","d","e","f","g","h","ha","hb","hc","hd","he"]
    println!("{:?}", string_sequence("z".to_string())); // ["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"]
}
