// https://leetcode.com/problems/find-the-student-that-will-replace-the-chalk/
pub fn chalk_replacer(chalk: Vec<i32>, k: i32) -> i32 {
    let mut i = 0;
    let sum: i64 = chalk.iter().map(|a| *a as i64).sum();
    let mut k = k as i64 % sum;
    loop {
        i = i % chalk.len();
        k -= chalk[i] as i64;
        if k < 0 {
            return i as i32;
        }
        i += 1;
    }
}

fn main() {
    println!("{}", chalk_replacer(vec![5, 1, 5], 22)); // 0
    println!("{}", chalk_replacer(vec![3, 4, 1, 2], 25)); // 1
    println!("{}", chalk_replacer(vec![5, 1, 5], 1000000000)); // 2
}
