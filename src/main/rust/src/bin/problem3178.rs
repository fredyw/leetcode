// https://leetcode.com/problems/find-the-child-who-has-the-ball-after-k-seconds/description/
pub fn number_of_child(n: i32, mut k: i32) -> i32 {
    let mut answer = 0;
    let mut increment = true;
    while k > 0 {
        if answer == 0 {
            increment = true;
        } else if answer == n - 1 {
            increment = false;
        }
        if increment {
            answer += 1;
        } else {
            answer -= 1;
        }
        k -= 1;
    }
    answer
}

fn main() {
    println!("{}", number_of_child(3, 5)); // 1
    println!("{}", number_of_child(5, 6)); // 2
    println!("{}", number_of_child(4, 2)); // 2
}
