use std::collections::HashSet;

// https://leetcode.com/problems/unique-email-groups/description/
pub fn unique_email_groups(emails: Vec<String>) -> i32 {
    emails
        .iter()
        .map(|e| {
            e.split_once('@')
                .map(|(l, d)| {
                    format!(
                        "{}@{}",
                        l.split('+').next().unwrap().replace('.', "").to_lowercase(),
                        d.to_lowercase()
                    )
                })
                .unwrap_or_else(|| e.to_string())
        })
        .collect::<HashSet<String>>()
        .len() as i32
}

fn main() {
    println!(
        "{}",
        unique_email_groups(vec![
            "test.email+alex@leetcode.com".to_string(),
            "test.e.mail+bob.cathy@leetcode.com".to_string(),
            "testemail+david@lee.tcode.com".to_string()
        ])
    ); // 2
    println!(
        "{}",
        unique_email_groups(vec![
            "A@B.com".to_string(),
            "a@b.com".to_string(),
            "ab+xy@b.com".to_string(),
            "a.b@b.com".to_string()
        ])
    ); // 2
    println!(
        "{}",
        unique_email_groups(vec![
            "a.b+c.d+e@DoMain.com".to_string(),
            "ab+xyz@domain.com".to_string(),
            "ab@domain.com".to_string()
        ])
    ); // 1
}
