// https://leetcode.com/problems/parsing-a-boolean-expression
pub fn parse_bool_expr(expression: String) -> bool {
    fn parse_bool_expr(expression: &Vec<char>, i: usize) -> bool {
        if expression[i] == '&' {
        } else if expression[i] == '|' {
        } else if expression[i] == '!' {
        } else if expression[i] == '(' {
        } else if expression[i] == ')' {
        }
        todo!()
    }

    let expression: Vec<char> = expression.chars().collect();
    parse_bool_expr(&expression, 0)
}

fn main() {
    println!("{}", parse_bool_expr("&(|(f))".to_string())); // false
    println!("{}", parse_bool_expr("|(f,f,f,t)".to_string())); // true
    println!("{}", parse_bool_expr("!(&(f,t))".to_string())); // true
    println!("{}", parse_bool_expr("|(t)".to_string())); // true
    println!("{}", parse_bool_expr("&(t)".to_string())); // true
    println!("{}", parse_bool_expr("&(|(f,f,f,t),f)".to_string())); // false
}
