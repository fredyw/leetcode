// https://leetcode.com/problems/dot-product-of-two-sparse-vectors/description/
struct SparseVector {}

impl SparseVector {
    fn new(nums: Vec<i32>) -> Self {
        todo!()
    }

    // Return the dotProduct of two sparse vectors
    fn dot_product(&self, vec: SparseVector) -> i32 {
        todo!()
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
