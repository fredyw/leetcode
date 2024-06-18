use std::collections::HashMap;

// https://leetcode.com/problems/dot-product-of-two-sparse-vectors/description/
struct SparseVector {
    map: HashMap<usize, i32>,
}

impl SparseVector {
    fn new(nums: Vec<i32>) -> Self {
        let mut map: HashMap<usize, i32> = HashMap::new();
        for (i, num) in nums.into_iter().enumerate() {
            if num != 0 {
                map.insert(i, num);
            }
        }
        SparseVector { map }
    }

    // Return the dotProduct of two sparse vectors
    fn dot_product(&self, vec: SparseVector) -> i32 {
        let mut product = 0;
        for (i, n) in self.map.iter() {
            product += n * vec.map.get(i).unwrap_or(&0);
        }
        product
    }
}

fn main() {
    println!(
        "{}",
        SparseVector::new(vec![1, 0, 0, 2, 3]).dot_product(SparseVector::new(vec![0, 3, 0, 4, 0]))
    ); // 8
    println!(
        "{}",
        SparseVector::new(vec![0, 1, 0, 0, 0]).dot_product(SparseVector::new(vec![0, 0, 0, 0, 2]))
    ); // 0
    println!(
        "{}",
        SparseVector::new(vec![0, 1, 0, 0, 2, 0, 0])
            .dot_product(SparseVector::new(vec![1, 0, 0, 0, 3, 0, 4]))
    ); // 6
}
