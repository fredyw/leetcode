// https://leetcode.com/problems/add-minimum-number-of-rungs/
pub fn add_rungs(rungs: Vec<i32>, dist: i32) -> i32 {
    let mut answer = 0;
    let mut start = 0;
    for i in 0..rungs.len() {
        if start + dist < rungs[i] {
            let num_rungs = if (rungs[i] - start) % dist == 0 {
                ((rungs[i] - start) / dist) - 1
            } else {
                (rungs[i] - start) / dist
            };
            answer += num_rungs;
        }
        start = rungs[i];
    }
    answer
}

fn main() {
    println!("{}", add_rungs(vec![1, 3, 5, 10], 2)); // 2
    println!("{}", add_rungs(vec![3, 6, 8, 10], 3)); // 0
    println!("{}", add_rungs(vec![3, 4, 6, 7], 2)); // 1
    println!("{}", add_rungs(vec![1, 100], 1)); // 98
    println!("{}", add_rungs(vec![1, 100], 2)); // 49
    println!("{}", add_rungs(vec![1, 39, 40], 1)); // 37
    println!(
        "{}",
        add_rungs(vec![1, 39, 40, 50, 90, 100, 400, 485, 699], 1)
    ); // 690
    println!(
        "{}",
        add_rungs(vec![1, 39, 40, 50, 90, 100, 400, 485, 699], 2)
    ); // 342
    println!("{}", add_rungs(vec![484], 2)); // 241
    println!("{}", add_rungs(vec![485], 2)); // 242
    println!("{}", add_rungs(vec![485, 699], 2)); // 348
    println!("{}", add_rungs(vec![50, 90], 2)); // 43
    println!("{}", add_rungs(vec![13, 34, 85, 9304, 43094, 239023], 5)); // 47801
    println!("{}", add_rungs(vec![6, 11], 2)); // 4
    println!("{}", add_rungs(vec![6, 10], 2)); // 3
    println!("{}", add_rungs(vec![5, 9], 2)); // 3
    println!("{}", add_rungs(vec![5, 10], 2)); // 4
}
