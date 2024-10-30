// https://leetcode.com/problems/ternary-expression-parser/description/
pub fn parse_ternary(expression: String) -> String {
    fn is_literal(expression: &Vec<char>, index: usize) -> bool {
        index + 1 == expression.len() || expression[index + 1] == ':'
    }

    fn parse_ternary(expression: &Vec<char>, index: &mut usize) -> String {
        let cond = expression[*index];
        *index += 2;
        let if_expr = if is_literal(expression, *index) {
            expression[*index].to_string()
        } else {
            parse_ternary(expression, index)
        };
        *index += 2;
        let else_expr = if is_literal(expression, *index) {
            expression[*index].to_string()
        } else {
            parse_ternary(expression, index)
        };
        if cond == 'T' {
            if_expr
        } else {
            else_expr
        }
    }

    let expression: Vec<char> = expression.chars().collect();
    parse_ternary(&expression, &mut 0)
}

fn main() {
    println!("{}", parse_ternary("T?2:3".to_string())); // "2"
    println!("{}", parse_ternary("F?2:3".to_string())); // "3"
    println!("{}", parse_ternary("F?1:T?4:5".to_string())); // "4"
    println!("{}", parse_ternary("T?T?F:5:3".to_string())); // "F"
    println!("{}", parse_ternary("T?T?T:T:F".to_string())); // "T"
    println!("{}", parse_ternary("T?T?3:4:T?1:2".to_string())); // "3"
    println!("{}", parse_ternary("T?T?3:4:T?5:6:T?1:2".to_string())); // "3"
    println!("{}", parse_ternary("F?T?3:4:T?5:6:T?1:2".to_string())); // "5"
}
