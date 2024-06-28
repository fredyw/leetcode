// https://leetcode.com/problems/flip-game/description/
pub fn generate_possible_next_moves(current_state: String) -> Vec<String> {
    todo!()
}

fn main() {
    println!("{:?}", generate_possible_next_moves("++++".to_string())); // ["--++","+--+","++--"]
    println!("{:?}", generate_possible_next_moves("+".to_string())); // []
    println!("{:?}", generate_possible_next_moves("+++++".to_string())); // ["--+++","+--++","++--+","+++--"]
}
