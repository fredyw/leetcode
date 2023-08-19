// https://leetcode.com/problems/check-if-there-is-a-valid-partition-for-the-array/
pub fn valid_partition(nums: Vec<i32>) -> bool {
    #[derive(Debug, PartialEq, Eq)]
    enum Type {
        Initial,
        Equal,
        Increasing,
    }

    fn valid_partition(nums: &Vec<i32>, index: usize, count: i32, t: Type) -> bool {
        if index == nums.len() {
            return (t == Type::Equal && count == 2) || count == 3;
        }
        if count == 1 {
            if nums[index - 1] == nums[index] {
                return valid_partition(nums, index + 1, count + 1, Type::Equal);
            }
            if nums[index - 1] + 1 == nums[index] {
                return valid_partition(nums, index + 1, count + 1, Type::Increasing);
            }
        }
        if count == 2 {
            if t == Type::Equal && nums[index - 1] == nums[index] {
                return valid_partition(nums, index + 1, count + 1, Type::Equal)
                    || valid_partition(nums, index + 1, 1, Type::Initial);
            }
            if t == Type::Increasing && nums[index - 1] + 1 == nums[index] {
                return valid_partition(nums, index + 1, count + 1, Type::Increasing);
            }
        }
        // count == 3
        valid_partition(nums, index + 1, 1, Type::Initial)
    }

    valid_partition(&nums, 1, 1, Type::Initial)
}

fn main() {
    println!("{}", valid_partition(vec![4, 4, 4, 5, 6])); // true
    println!("{}", valid_partition(vec![1, 1, 1, 2])); // false
}
