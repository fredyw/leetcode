// https://leetcode.com/problems/sort-transformed-array/description/
pub fn sort_transformed_array(nums: Vec<i32>, a: i32, b: i32, c: i32) -> Vec<i32> {
    fn f(x: i32, a: i32, b: i32, c: i32) -> i32 {
        (a * x * x) + (b * x) + c
    }

    let mut answer = vec![];
    for num in nums {
        answer.push(f(num, a, b, c));
    }
    answer.sort();
    answer
}

fn main() {
    println!("{:?}", sort_transformed_array(vec![-4, -2, 2, 4], 1, 3, 5)); // [3,9,15,33]
    println!("{:?}", sort_transformed_array(vec![-4, -2, 2, 4], -1, 3, 5)); // [-23,-5,1,7]
}
