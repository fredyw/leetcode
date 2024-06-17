// https://leetcode.com/problems/buildings-with-an-ocean-view/description/
pub fn find_buildings(heights: Vec<i32>) -> Vec<i32> {
    let mut answer = vec![];
    let mut i = 0;
    while i < heights.len() {
        let mut j = i + 1;
        while j < heights.len() && heights[i] >= heights[j] {
            j += 1;
        }
        i = j;
    }
    answer
}

fn main() {
    println!("{:?}", find_buildings(vec![4, 2, 3, 1])); // [0,2,3]
    println!("{:?}", find_buildings(vec![4, 3, 2, 1])); // [0,1,2,3]
    println!("{:?}", find_buildings(vec![1, 3, 2, 4])); // [3]
    println!("{:?}", find_buildings(vec![1, 3, 2, 4, 3, 2, 3])); // [3,6]
    println!("{:?}", find_buildings(vec![1, 3, 2, 4, 3, 2, 1])); // [3,4,5,6]
}
