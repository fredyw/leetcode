// https://leetcode.com/problems/buildings-with-an-ocean-view/description/
pub fn find_buildings(heights: Vec<i32>) -> Vec<i32> {
    // Use monotonic stack to find the next greater elements.
    let mut answer = vec![-1; heights.len()];
    let mut vec: Vec<usize> = vec![];
    for i in 0..heights.len() {
        while let Some(&last_index) = vec.last() {
            if heights[i] < heights[last_index] {
                break;
            }
            vec.pop();
            answer[last_index] = heights[i];
        }
        vec.push(i);
    }
    answer
        .into_iter()
        .enumerate()
        .filter(|(_, h)| *h == -1)
        .map(|(i, _)| i as i32)
        .collect()
}

fn main() {
    println!("{:?}", find_buildings(vec![4, 2, 3, 1])); // [0,2,3]
    println!("{:?}", find_buildings(vec![4, 3, 2, 1])); // [0,1,2,3]
    println!("{:?}", find_buildings(vec![1, 3, 2, 4])); // [3]
    println!("{:?}", find_buildings(vec![1, 3, 2, 4, 3, 2, 3])); // [3,6]
    println!("{:?}", find_buildings(vec![1, 3, 2, 4, 3, 2, 1])); // [3,4,5,6]
}
