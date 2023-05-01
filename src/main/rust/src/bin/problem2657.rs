use std::collections::HashSet;

// https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/
pub fn find_the_prefix_common_array(a: Vec<i32>, b: Vec<i32>) -> Vec<i32> {
    let mut answer = vec![0; a.len()];
    let mut set1: HashSet<i32> = HashSet::new();
    let mut set2: HashSet<i32> = HashSet::new();
    for i in 0..a.len() {
        if a[i] == b[i] {
            answer[i] = if i == 0 { 0 } else { answer[i - 1] } + 1;
        } else if set1.contains(&b[i]) || set2.contains(&a[i]) {
            let mut count = 0;
            if set1.contains(&b[i]) {
                count += 1;
            }
            if set2.contains(&a[i]) {
                count += 1;
            }
            answer[i] = if i == 0 { 0 } else { answer[i - 1] } + count;
        } else {
            answer[i] = if i == 0 { 0 } else { answer[i - 1] };
        }
        set1.insert(a[i]);
        set2.insert(b[i]);
    }
    answer
}

fn main() {
    println!(
        "{:?}",
        find_the_prefix_common_array(vec![1, 3, 2, 4], vec![3, 1, 2, 4])
    ); // [0,2,3,4]
    println!(
        "{:?}",
        find_the_prefix_common_array(vec![2, 3, 1], vec![3, 1, 2])
    ); // [0,1,3]
}
