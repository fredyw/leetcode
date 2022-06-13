use std::cmp;

// https://leetcode.com/problems/fair-distribution-of-cookies/
pub fn distribute_cookies(cookies: Vec<i32>, k: i32) -> i32 {
    fn f(cookies: &Vec<i32>, k: i32, index: i32, children: &mut Vec<i32>, min: &mut i32) {
        if index as usize == cookies.len() {
            let max = children.iter().max().unwrap().to_owned();
            *min = cmp::min(*min, max);
            return;
        }
        for i in 0..k {
            children[i as usize] += cookies[index as usize];
            f(cookies, k, index + 1, children, min);
            children[i as usize] -= cookies[index as usize];
        }
    }
    let mut children = vec![0; k as usize];
    let mut answer = i32::MAX;
    f(&cookies, k, 0, &mut children, &mut answer);
    answer
}

fn main() {
    println!("{}", distribute_cookies(vec![8, 15, 10, 20, 8], 2)); // 31
    println!("{}", distribute_cookies(vec![6, 1, 3, 2, 2, 4, 1, 2], 3)); // 7
}
