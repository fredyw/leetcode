// https://leetcode.com/problems/pass-the-pillow/
pub fn pass_the_pillow(n: i32, time: i32) -> i32 {
    let mut answer = 0;
    let mut count = 0;
    let mut t = 1;
    let mut forward = true;
    while count <= time {
        if count == time {
            answer = t;
            break;
        }
        if t == n {
            forward = false;
        } else if t == 1 {
            forward = true;
        }
        if forward {
            t += 1;
        } else {
            t -= 1;
        }
        count += 1;
    }
    answer
}

fn main() {
    println!("{}", pass_the_pillow(4, 5)); // 2
    println!("{}", pass_the_pillow(3, 2)); // 3
    println!("{}", pass_the_pillow(4, 1000)); // 3
    println!("{}", pass_the_pillow(4, 9)); // 4
    println!("{}", pass_the_pillow(4, 8)); // 3
}
