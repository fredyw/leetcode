// https://leetcode.com/problems/smallest-common-region/description/
pub fn find_smallest_region(regions: Vec<Vec<String>>, region1: String, region2: String) -> String {
    todo!()
}

fn main() {
    println!(
        "{}",
        find_smallest_region(
            vec![
                vec![
                    "Earth".to_string(),
                    "North America".to_string(),
                    "South America".to_string()
                ],
                vec![
                    "North America".to_string(),
                    "United States".to_string(),
                    "Canada".to_string()
                ],
                vec![
                    "United States".to_string(),
                    "New York".to_string(),
                    "Boston".to_string()
                ],
                vec![
                    "Canada".to_string(),
                    "Ontario".to_string(),
                    "Quebec".to_string()
                ],
                vec!["South America".to_string(), "Brazil".to_string()]
            ],
            "Quebec".to_string(),
            "New York".to_string()
        )
    ); // "North America"
    println!(
        "{}",
        find_smallest_region(
            vec![
                vec![
                    "Earth".to_string(),
                    "North America".to_string(),
                    "South America".to_string()
                ],
                vec![
                    "North America".to_string(),
                    "United States".to_string(),
                    "Canada".to_string()
                ],
                vec![
                    "United States".to_string(),
                    "New York".to_string(),
                    "Boston".to_string()
                ],
                vec![
                    "Canada".to_string(),
                    "Ontario".to_string(),
                    "Quebec".to_string()
                ],
                vec!["South America".to_string(), "Brazil".to_string()]
            ],
            "Canada".to_string(),
            "South America".to_string()
        )
    ); // "Earth"
}
