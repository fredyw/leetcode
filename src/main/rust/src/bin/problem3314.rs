// https://leetcode.com/problems/construct-the-minimum-bitwise-array-i/description/
pub fn min_bitwise_array(nums: Vec<i32>) -> Vec<i32> {
    let mut answer = vec![];
    for num in nums {
        if num % 2 == 0 {
            answer.push(-1);
        } else {
            for i in 1..num {
                if i | (i + 1) == num {
                    answer.push(i);
                    break;
                }
            }
        }
    }
    answer
}

fn main() {
    println!("{:?}", min_bitwise_array(vec![2, 3, 5, 7])); // [-1,1,4,3]
    println!("{:?}", min_bitwise_array(vec![11, 13, 31])); // [9,12,15]
}
