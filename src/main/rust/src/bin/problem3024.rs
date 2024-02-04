// https://leetcode.com/problems/type-of-triangle-ii/description/
pub fn triangle_type(nums: Vec<i32>) -> String {
    fn is_triangle(nums: &Vec<i32>) -> bool {
        nums[0] + nums[1] > nums[2] && nums[1] + nums[2] > nums[0] && nums[0] + nums[2] > nums[1]
    }

    if !is_triangle(&nums) {
        "none".to_string()
    } else if nums[0] == nums[1] && nums[1] == nums[2] {
        "equilateral".to_string()
    } else if nums[0] != nums[1] && nums[1] != nums[2] && nums[2] != nums[0] {
        "scalene".to_string()
    } else {
        "isosceles".to_string()
    }
}

fn main() {
    println!("{}", triangle_type(vec![3, 3, 3])); // "equilateral"
    println!("{}", triangle_type(vec![3, 4, 5])); // "scalene"
    println!("{}", triangle_type(vec![3, 5, 5])); // "isosceles"
    println!("{}", triangle_type(vec![1, 2, 3])); // "nonw"
    println!("{}", triangle_type(vec![8, 4, 2])); // "nonw"
}
