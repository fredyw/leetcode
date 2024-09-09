use std::collections::HashMap;

// https://leetcode.com/problems/path-sum-iv/description/
pub fn path_sum(nums: Vec<i32>) -> i32 {
    fn path_sum(
        map: &HashMap<i32, HashMap<i32, i32>>,
        depth: i32,
        position: i32,
        sum: i32,
        answer: &mut i32,
    ) {
        if let Some(m) = map.get(&depth) {
            let val = if let Some(v) = m.get(&position) {
                *v
            } else {
                return;
            };
            if map.get(&(depth + 1)).is_some() {
                path_sum(map, depth + 1, (position * 2) - 1, sum + val, answer);
                path_sum(map, depth + 1, position * 2, sum + val, answer);
            } else {
                *answer += sum + val;
            }
        }
    }

    let nums: Vec<(i32, i32, i32)> = nums
        .into_iter()
        .map(|n| {
            let chars: Vec<char> = n.to_string().chars().collect();
            (
                chars[0].to_string().parse::<i32>().unwrap(),
                chars[1].to_string().parse::<i32>().unwrap(),
                chars[2].to_string().parse::<i32>().unwrap(),
            )
        })
        .collect();
    let mut map: HashMap<i32, HashMap<i32, i32>> = HashMap::new();
    for (depth, position, value) in nums.iter() {
        map.entry(*depth)
            .or_insert(HashMap::new())
            .insert(*position, *value);
    }
    let mut answer = 0;
    path_sum(&map, 1, 1, 0, &mut answer);
    answer
}

fn main() {
    // println!("{}", path_sum(vec![113, 215, 221])); // 12
    // println!("{}", path_sum(vec![113, 221])); // 4
    println!("{}", path_sum(vec![113, 212, 221, 331, 341])); // 15
                                                             // println!("{}", path_sum(vec![113, 212, 221, 311, 321, 331, 341])); // 22
                                                             // println!("{}", path_sum(vec![113])); // 3
}
