// https://leetcode.com/problems/find-the-original-array-of-prefix-xor/
pub fn find_array(pref: Vec<i32>) -> Vec<i32> {
    let mut answer = vec![0; pref.len()];
    let mut xor = 0;
    for (i, n) in pref.into_iter().enumerate() {
        answer[i] = xor ^ n;
        xor ^= xor ^ n;
    }
    answer
}

fn main() {
    println!("{:?}", find_array(vec![5, 2, 0, 3, 1])); // [5,7,2,3,2]
    println!("{:?}", find_array(vec![13])); // [13]
}
