// https://leetcode.com/problems/flip-game/description/
pub fn generate_possible_next_moves(current_state: String) -> Vec<String> {
    let mut answer = vec![];
    let bytes = current_state.as_bytes();
    let mut i = 0;
    while i + 1 < bytes.len() {
        if bytes[i] == '+' as u8 && bytes[i + 1] == '+' as u8 {
            let mut chars: Vec<char> = current_state.chars().collect();
            chars[i] = '-';
            chars[i + 1] = '-';
            answer.push(chars.into_iter().collect());
        }
        i += 1;
    }
    answer
}

fn main() {
    println!("{:?}", generate_possible_next_moves("++++".to_string())); // ["--++","+--+","++--"]
    println!("{:?}", generate_possible_next_moves("+".to_string())); // []
    println!("{:?}", generate_possible_next_moves("+++++".to_string())); // ["--+++","+--++","++--+","+++--"]
}
