// https://leetcode.com/problems/elevator-requests-i/
pub fn elevator_requests(_n: i32, requests: Vec<i32>) -> i32 {
    let mut answer = requests[0];
    for i in 0..requests.len() - 1 {
        answer += (requests[i] - requests[i + 1]).abs();
    }
    answer
}

fn main() {
    println!("{}", elevator_requests(5, vec![2, 1, 4, 3])); // 7
    println!("{}", elevator_requests(3, vec![2, 0, 0])); // 4
}
