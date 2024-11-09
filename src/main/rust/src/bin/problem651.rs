// https://leetcode.com/problems/4-keys-keyboard/description/
pub fn max_a(n: i32) -> i32 {
    fn max_a(n: i32, buffer: i32, num_a: i32) -> i32 {
        if n == 0 {
            return 0;
        }
        let print_a = max_a(n - 1, buffer, num_a + 1) + 1;
        let copy_paste = if n - 3 >= 0 {
            max_a(n - 3, num_a, num_a * 2) + num_a
        } else {
            0
        };
        let paste = if buffer > 0 {
            max_a(n - 1, buffer, num_a + buffer) + buffer
        } else {
            0
        };
        let max = print_a.max(copy_paste.max(paste));
        max
    }

    max_a(n, 0, 0)
}

fn main() {
    println!("{}", max_a(3)); // 3
    println!("{}", max_a(7)); // 9
    println!("{}", max_a(5)); // 5
    println!("{}", max_a(15)); // 81
                               // println!("{}", max_a(50)); // 1327104
}
