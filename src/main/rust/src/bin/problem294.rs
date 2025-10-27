use std::collections::HashMap;

// https://leetcode.com/problems/flip-game-ii/description/
pub fn can_win(current_state: String) -> bool {
    fn can_win(state: &mut Vec<char>, memo: &mut HashMap<String, bool>) -> bool {
        let s: String = state.iter().collect();
        if let Some(&result) = memo.get(&s) {
            return result;
        }
        for i in 0..state.len() - 1 {
            if state[i] == '+' && state[i + 1] == '+' {
                state[i] = '-';
                state[i + 1] = '-';
                if !can_win(state, memo) {
                    state[i] = '+';
                    state[i + 1] = '+';
                    memo.insert(s, true);
                    return true;
                }
                state[i] = '+';
                state[i + 1] = '+';
            }
        }
        memo.insert(s, false);
        false
    }

    let mut state: Vec<char> = current_state.chars().collect();
    can_win(&mut state, &mut HashMap::new())
}

fn main() {
    println!("{}", can_win("++++".to_string())); // true
    println!("{}", can_win("+".to_string())); // false
}
