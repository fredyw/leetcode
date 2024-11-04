// https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/description/
pub fn verify_preorder(preorder: Vec<i32>) -> bool {
    fn verify_preorder(preorder: &Vec<i32>, index: &mut usize, min: i32, max: i32) -> bool {
        if *index == preorder.len() {
            return true;
        }
        let val = preorder[*index];
        if val <= min || val >= max {
            return false;
        }
        *index += 1;
        let left = verify_preorder(preorder, index, min, val);
        let right = verify_preorder(preorder, index, val, max);
        left || right
    }

    verify_preorder(&preorder, &mut 0, i32::MIN, i32::MAX)
}

fn main() {
    println!("{}", verify_preorder(vec![5, 2, 1, 3, 6])); // true
    println!("{}", verify_preorder(vec![5, 2, 6, 1, 3])); // false
    println!("{}", verify_preorder(vec![1, 2, 3, 4, 5])); // true
}
