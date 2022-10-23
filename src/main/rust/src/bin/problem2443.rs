// https://leetcode.com/problems/sum-of-number-and-its-reverse/
pub fn sum_of_number_and_reverse(num: i32) -> bool {
    for i in num / 2..=num {
        let reversed: i32 = format!("{}", i)
            .chars()
            .rev()
            .collect::<String>()
            .parse()
            .unwrap();
        if i + reversed == num {
            return true;
        }
    }
    false
}

fn main() {
    println!("{}", sum_of_number_and_reverse(443)); // true
    println!("{}", sum_of_number_and_reverse(63)); // false
    println!("{}", sum_of_number_and_reverse(181)); // true
    println!("{}", sum_of_number_and_reverse(0)); // true
}
