// https://leetcode.com/problems/parsing-a-boolean-expression
pub fn parse_bool_expr(expression: String) -> bool {
    false
}

fn main() {
    println!("{}", parse_bool_expr("&(|(f))".to_string())); // false
    println!("{}", parse_bool_expr("|(f,f,f,t)".to_string())); // true
    println!("{}", parse_bool_expr("!(&(f,t))".to_string())); // true
    println!("{}", parse_bool_expr("|(t)".to_string())); // true
    println!("{}", parse_bool_expr("&(t)".to_string())); // true
}
