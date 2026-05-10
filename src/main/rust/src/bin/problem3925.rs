// https://leetcode.com/problems/concatenate-array-with-reverse/description/
pub fn concat_with_reverse(nums: Vec<i32>) -> Vec<i32> {
    let mut reverse = nums.clone();
    reverse.reverse();
    let mut answer = vec![];
    for num in nums {
        answer.push(num);
    }
    for num in reverse {
        answer.push(num);
    }
    answer
}

fn main() {
    println!("{:?}", concat_with_reverse(vec![1, 2, 3])); // [1,2,3,3,2,1]
    println!("{:?}", concat_with_reverse(vec![1])); // [1]
}
