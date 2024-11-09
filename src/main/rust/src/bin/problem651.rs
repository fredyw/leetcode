use std::collections::HashMap;

// https://leetcode.com/problems/4-keys-keyboard/description/
pub fn max_a(n: i32) -> i32 {
    fn max_a(n: i32, buffer: i32, num_a: i32, memo: &mut HashMap<(i32, i32, i32), i32>) -> i32 {
        if n == 0 {
            return 0;
        }
        if let Some(m) = memo.get(&(n, buffer, num_a)) {
            return *m;
        }
        let print_a_or_paste = if buffer > 0 {
            max_a(n - 1, buffer, num_a + buffer, memo) + buffer
        } else {
            max_a(n - 1, buffer, num_a + 1, memo) + 1
        };
        let copy_paste = if n - 3 >= 0 {
            max_a(n - 3, num_a, num_a * 2, memo) + num_a
        } else {
            0
        };
        let max = print_a_or_paste.max(copy_paste);
        memo.insert((n, buffer, num_a), max);
        max
    }

    max_a(n, 0, 0, &mut HashMap::new())
}

fn main() {
    // println!("{}", max_a(3)); // 3
    // println!("{}", max_a(7)); // 9
    // println!("{}", max_a(5)); // 5
    // println!("{}", max_a(15)); // 81
    println!("{}", max_a(50)); // 1327104
}
