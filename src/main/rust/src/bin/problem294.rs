use std::collections::HashMap;

// https://leetcode.com/problems/flip-game-ii/description/
pub fn can_win(current_state: String) -> bool {
    fn can_win(state: String, memo: &mut HashMap<String, bool>) -> bool {
        if let Some(&result) = memo.get(&state) {
            return result;
        }
        for i in 0..state.len().saturating_sub(1) {
            if &state[i..i + 2] == "++" {
                let next_state = format!("{}{}{}", &state[..i], "--", &state[i + 2..]);
                if !can_win(next_state, memo) {
                    memo.insert(state, true);
                    return true;
                }
            }
        }
        memo.insert(state, false);
        false
    }

    can_win(current_state, &mut HashMap::new())
}

fn main() {
    println!("{}", can_win("++++".to_string())); // true
    println!("{}", can_win("+".to_string())); // false
}
