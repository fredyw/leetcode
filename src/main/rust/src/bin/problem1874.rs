// https://leetcode.com/problems/minimize-product-sum-of-two-arrays/
pub fn min_product_sum(mut nums1: Vec<i32>, mut nums2: Vec<i32>) -> i32 {
    nums1.sort_by(|a, b| b.cmp(a));
    nums2.sort();
    let mut answer = 0;
    for (i, num2) in nums2.iter().enumerate() {
        answer += nums1[i] * num2;
    }
    answer
}

fn main() {
    println!("{}", min_product_sum(vec![5, 3, 4, 2], vec![4, 2, 2, 5])); // 40
    println!(
        "{}",
        min_product_sum(vec![2, 1, 4, 5, 7], vec![3, 2, 4, 8, 6])
    ); // 65
}
