// https://leetcode.com/problems/substring-matching-pattern/
pub fn has_match(s: String, p: String) -> bool {
    let v: Vec<&str> = p.split("*").collect();
    let left = v[0];
    let right = v[1];
    if !left.is_empty() && !right.is_empty() {
        let l = s.find(left);
        if l.is_none() {
            return false;
        }
        let r = s.rfind(right);
        if r.is_none() {
            return false;
        }
        return l.unwrap() + left.len() - 1 < r.unwrap();
    }
    if !left.is_empty() {
        let l = s.find(left);
        if l.is_none() {
            return false;
        }
    }
    if !right.is_empty() {
        let r = s.rfind(right);
        if r.is_none() {
            return false;
        }
    }
    true
}

fn main() {
    println!("{}", has_match("leetcode".to_string(), "ee*e".to_string())); // true
    println!("{}", has_match("car".to_string(), "c*v".to_string())); // false
    println!("{}", has_match("luck".to_string(), "u*".to_string())); // true
    println!("{}", has_match("luck".to_string(), "*u".to_string())); // true
    println!("{}", has_match("tokk".to_string(), "t*t".to_string())); // false
    println!("{}", has_match("ckckkk".to_string(), "ck*kc".to_string())); // false
    println!("{}", has_match("kvb".to_string(), "k*v".to_string())); // true
}
