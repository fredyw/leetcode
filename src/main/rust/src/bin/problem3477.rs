// https://leetcode.com/problems/fruits-into-baskets-ii/description/
pub fn num_of_unplaced_fruits(fruits: Vec<i32>, baskets: Vec<i32>) -> i32 {
    let mut answer = fruits.len() as i32;
    let mut visited: Vec<bool> = vec![false; baskets.len()];
    for i in 0..fruits.len() {
        for j in 0..baskets.len() {
            if visited[j] {
                continue;
            }
            if fruits[i] <= baskets[j] {
                visited[j] = true;
                answer -= 1;
                break;
            }
        }
    }
    answer
}

fn main() {
    println!("{}", num_of_unplaced_fruits(vec![4, 2, 5], vec![3, 5, 4])); // 1
    println!("{}", num_of_unplaced_fruits(vec![3, 6, 1], vec![6, 4, 7])); // 0
}
