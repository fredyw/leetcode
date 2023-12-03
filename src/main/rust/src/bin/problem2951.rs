// https://leetcode.com/problems/find-the-peaks/description/
pub fn find_peaks(mountain: Vec<i32>) -> Vec<i32> {
    let mut answer = vec![];
    for i in 1..mountain.len() - 1 {
        if mountain[i - 1] < mountain[i] && mountain[i] > mountain[i + 1] {
            answer.push(i as i32);
        }
    }
    answer
}

fn main() {
    println!("{:?}", find_peaks(vec![2, 4, 4])); // []
    println!("{:?}", find_peaks(vec![1, 4, 3, 8, 5])); // [1,3]
}
