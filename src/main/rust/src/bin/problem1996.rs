// https://leetcode.com/problems/the-number-of-weak-characters-in-the-game/
pub fn number_of_weak_characters(mut properties: Vec<Vec<i32>>) -> i32 {
    properties.sort_by_key(|v| (v[0], v[1]));
    let mut suffix_attack = vec![0; properties.len()];
    let mut suffix_defense = vec![0; properties.len()];
    for i in (0..properties.len()).rev() {
        let v = &properties[i];
        if i == properties.len() - 1 {
            suffix_attack[i] = v[0];
            suffix_defense[i] = v[1];
        } else {
            suffix_attack[i] = v[0].max(suffix_attack[i + 1]);
            suffix_defense[i] = v[1].max(suffix_defense[i + 1]);
        }
    }
    let mut answer = 0;
    println!("{:?}", properties);
    println!("{:?}", suffix_attack);
    println!("{:?}", suffix_defense);
    for i in 0..properties.len() - 1 {
        let attack = properties[i][0];
        let defense = properties[i][1];
        if attack < suffix_attack[i + 1] && defense < suffix_defense[i + 1] {
            answer += 1;
        }
    }
    answer
}

fn main() {
    // println!(
    //     "{}",
    //     number_of_weak_characters(vec![vec![5, 5], vec![6, 3], vec![3, 6]])
    // ); // 0
    // println!(
    //     "{}",
    //     number_of_weak_characters(vec![vec![2, 2], vec![3, 3]])
    // ); // 1
    // println!(
    //     "{}",
    //     number_of_weak_characters(vec![vec![1, 5], vec![10, 4], vec![4, 3]])
    // ); // 1
    // println!(
    //     "{}",
    //     number_of_weak_characters(vec![vec![1, 5], vec![10, 4], vec![4, 3], vec![5, 5]])
    // ); // 1
    println!(
        "{}",
        number_of_weak_characters(vec![
            vec![7, 9],
            vec![10, 7],
            vec![6, 9],
            vec![10, 4],
            vec![7, 5],
            vec![7, 10]
        ])
    ); // 2
}
