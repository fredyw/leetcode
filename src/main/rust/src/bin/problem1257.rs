use std::collections::{HashMap, HashSet};

// https://leetcode.com/problems/smallest-common-region/description/
pub fn find_smallest_region(regions: Vec<Vec<String>>, region1: String, region2: String) -> String {
    let mut map: HashMap<String, String> = HashMap::new();
    for region in regions.iter() {
        for i in 1..region.len() {
            map.insert(region[i].to_string(), region[0].to_string()); // child to parent
        }
    }
    let mut path: HashSet<String> = HashSet::new();
    let mut region1 = region1;
    path.insert(region1.clone());
    while let Some(region) = map.get(&region1) {
        path.insert(region.clone());
        region1 = region.clone();
    }
    let mut answer = String::new();
    let mut region2 = region2;
    if path.contains(&region2) {
        return region2;
    }
    while let Some(region) = map.get(&region2) {
        if path.contains(region) {
            answer = region.clone();
            break;
        }
        region2 = region.clone();
    }
    answer
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
    println!(
        "{}",
        find_smallest_region(
            vec![
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
                vec!["South America".to_string(), "Brazil".to_string()],
                vec![
                    "Earth".to_string(),
                    "North America".to_string(),
                    "South America".to_string()
                ],
                vec![
                    "Europe".to_string(),
                    "France".to_string(),
                    "Italy".to_string()
                ],
            ],
            "Italy".to_string(),
            "France".to_string()
        )
    ); // "Europe"
}
