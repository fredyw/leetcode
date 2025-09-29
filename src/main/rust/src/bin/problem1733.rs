use std::collections::HashSet;

// https://leetcode.com/problems/minimum-number-of-people-to-teach/
pub fn minimum_teachings(n: i32, languages: Vec<Vec<i32>>, friendships: Vec<Vec<i32>>) -> i32 {
    let mut answer = i32::MAX;
    let languages: Vec<HashSet<i32>> = languages
        .into_iter()
        .map(|v| v.into_iter().collect())
        .collect();
    let friendships: Vec<Vec<i32>> = friendships
        .into_iter()
        .filter(|friendship| {
            let fidx1 = friendship[0] as usize - 1;
            let fidx2 = friendship[1] as usize - 1;
            languages[fidx1].is_disjoint(&languages[fidx2])
        })
        .collect();
    for language in 1..=n {
        let mut count = 0;
        let mut language_learned: HashSet<usize> = HashSet::new();
        for friendship in &friendships {
            let fidx1 = friendship[0] as usize - 1;
            let fidx2 = friendship[1] as usize - 1;
            if !language_learned.contains(&fidx1) && !languages[fidx1].contains(&language) {
                language_learned.insert(fidx1);
                count += 1;
            }
            if !language_learned.contains(&fidx2) && !languages[fidx2].contains(&language) {
                language_learned.insert(fidx2);
                count += 1;
            }
        }
        answer = answer.min(count);
    }
    answer
}

fn main() {
    println!(
        "{}",
        minimum_teachings(
            2,
            vec![vec![1], vec![2], vec![1, 2]],
            vec![vec![1, 2], vec![1, 3], vec![2, 3]]
        )
    ); // 1
    println!(
        "{}",
        minimum_teachings(
            3,
            vec![vec![2], vec![1, 3], vec![1, 2], vec![3]],
            vec![vec![1, 4], vec![1, 2], vec![3, 4], vec![2, 3]]
        )
    ); // 2
}
