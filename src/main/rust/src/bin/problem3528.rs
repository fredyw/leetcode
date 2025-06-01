use std::collections::HashMap;

// https://leetcode.com/problems/unit-conversion-i/description/
pub fn base_unit_conversions(conversions: Vec<Vec<i32>>) -> Vec<i32> {
    fn dfs(map: &HashMap<i32, Vec<(i32, i32)>>, from: i32, product: i32, answer: &mut Vec<i32>) {
        answer[from as usize] = product;
        for (to, c) in map.get(&from).unwrap_or(&vec![]) {
            dfs(
                map,
                *to,
                ((product as i64 * *c as i64) % 1_000_000_007) as i32,
                answer,
            );
        }
    }

    let mut map: HashMap<i32, Vec<(i32, i32)>> = HashMap::new();
    for c in conversions.iter() {
        map.entry(c[0]).or_insert(vec![]).push((c[1], c[2]));
    }
    let mut answer: Vec<i32> = vec![1; conversions.len() + 1];
    dfs(&map, 0, 1, &mut answer);
    answer
}

fn main() {
    println!(
        "{:?}",
        base_unit_conversions(vec![vec![0, 1, 2], vec![1, 2, 3]])
    ); // [1,2,6]
    println!(
        "{:?}",
        base_unit_conversions(vec![
            vec![0, 1, 2],
            vec![0, 2, 3],
            vec![1, 3, 4],
            vec![1, 4, 5],
            vec![2, 5, 2],
            vec![4, 6, 3],
            vec![5, 7, 4]
        ])
    ); // [1,2,3,8,10,6,30,24]
}
