// https://leetcode.com/problems/number-of-equal-numbers-blocks/description/
pub struct BigArray {
    elements: Vec<i32>,
}

impl BigArray {
    pub fn new(elements: Vec<i32>) -> Self {
        Self { elements }
    }

    pub fn at(&self, index: usize) -> i32 {
        self.elements[index]
    }

    pub fn size(&self) -> usize {
        self.elements.len()
    }
}

pub fn count_blocks(nums: BigArray) -> i32 {
    fn binary_search(nums: &BigArray, mut start: usize, mut end: usize, val: i32) -> usize {
        while start <= end {
            let mid = start + (end - start) / 2;
            if nums.at(mid) == val {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        start
    }

    let mut answer = 0;
    let mut i = 0;
    while i < nums.size() {
        i = binary_search(&nums, i, nums.size() - 1, nums.at(i));
        answer += 1;
    }
    answer
}

fn main() {
    println!("{}", count_blocks(BigArray::new(vec![3, 3, 3, 3, 3]))); // 1
    println!(
        "{}",
        count_blocks(BigArray::new(vec![1, 1, 1, 3, 9, 9, 9, 2, 10, 10]))
    ); // 5
    println!("{}", count_blocks(BigArray::new(vec![1, 2, 3, 4, 5, 6, 7]))); // 7
    println!("{}", count_blocks(BigArray::new(vec![1]))); // 1
}
