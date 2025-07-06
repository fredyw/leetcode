// https://leetcode.com/problems/coupon-code-validator/description/
pub fn validate_coupons(
    code: Vec<String>,
    business_line: Vec<String>,
    is_active: Vec<bool>,
) -> Vec<String> {
    let mut valid: Vec<(i32, &str)> = vec![];
    for i in 0..code.len() {
        let business = match business_line[i].as_str() {
            "electronics" => 0,
            "grocery" => 1,
            "pharmacy" => 2,
            "restaurant" => 3,
            _ => -1,
        };
        if code[i].is_empty()
            || !code[i]
                .chars()
                .all(|c| c.is_ascii_alphanumeric() || c == '_')
            || business == -1
            || !is_active[i]
        {
            continue;
        }
        valid.push((business, &code[i]));
    }
    valid.sort();
    valid
        .into_iter()
        .map(|(_, code)| code.to_string())
        .collect()
}

fn main() {
    println!(
        "{:?}",
        validate_coupons(
            vec![
                "SAVE20".to_string(),
                "".to_string(),
                "PHARMA5".to_string(),
                "SAVE@20".to_string()
            ],
            vec![
                "restaurant".to_string(),
                "grocery".to_string(),
                "pharmacy".to_string(),
                "restaurant".to_string()
            ],
            vec![true, true, true, true]
        )
    ); // ["PHARMA5","SAVE20"]
    println!(
        "{:?}",
        validate_coupons(
            vec![
                "GROCERY15".to_string(),
                "ELECTRONICS_50".to_string(),
                "DISCOUNT10".to_string()
            ],
            vec![
                "grocery".to_string(),
                "electronics".to_string(),
                "invalid".to_string()
            ],
            vec![false, true, true]
        )
    ); // ["ELECTRONICS_50"]
}
