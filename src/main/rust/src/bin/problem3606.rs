// https://leetcode.com/problems/coupon-code-validator/description/
pub fn validate_coupons(
    code: Vec<String>,
    business_line: Vec<String>,
    is_active: Vec<bool>,
) -> Vec<String> {
    todo!()
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
