// https://leetcode.com/problems/parsing-a-boolean-expression
pub fn parse_bool_expr(expression: String) -> bool {
    fn eval(val: bool, op: char, first: &mut bool, result: &mut bool) {
        if *first {
            *result = val;
            *first = false;
        } else {
            if op == '&' {
                *result = *result && val;
            } else if op == '|' {
                *result = *result || val;
            } else if op == '!' {
                *result = !*result;
            }
        }
    }

    fn parse_bool_expr(expression: &Vec<char>, i: &mut usize) -> bool {
        let mut first = true;
        let mut result = false;
        let op = expression[*i];
        *i += 1;
        while expression[*i] != ')' {
            if expression[*i] == 't' {
                eval(true, op, &mut first, &mut result);
            } else if expression[*i] == 'f' {
                eval(false, op, &mut first, &mut result);
            } else if expression[*i] == '&' || expression[*i] == '|' || expression[*i] == '!' {
                eval(parse_bool_expr(expression, i), op, &mut first, &mut result);
            }
            *i += 1;
        }
        if op == '!' {
            !result
        } else {
            result
        }
    }

    let expression: Vec<char> = expression.chars().collect();
    parse_bool_expr(&expression, &mut 0)
}

fn main() {
    println!("{}", parse_bool_expr("&(|(f))".to_string())); // false
    println!("{}", parse_bool_expr("|(f,f,f,t)".to_string())); // true
    println!("{}", parse_bool_expr("!(&(f,t))".to_string())); // true
    println!("{}", parse_bool_expr("!(t)".to_string())); // false
    println!("{}", parse_bool_expr("!(f)".to_string())); // true
    println!("{}", parse_bool_expr("|(t)".to_string())); // true
    println!("{}", parse_bool_expr("&(t)".to_string())); // true
    println!("{}", parse_bool_expr("&(|(f,f,f,t),f)".to_string())); // false
}
