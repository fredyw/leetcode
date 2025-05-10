use std::collections::HashMap;

// https://leetcode.com/problems/paint-fence/
pub fn num_ways(n: i32, k: i32) -> i32 {
    fn num_ways(
        n: i32,
        k: i32,
        prev_colors: [i32; 2],
        memo: &mut HashMap<(i32, i32, i32), i32>,
    ) -> i32 {
        if n == 0 {
            return 1;
        }
        let key = (n, prev_colors[0], prev_colors[1]);
        if let Some(v) = memo.get(&key) {
            return *v;
        }
        let mut count = 0;
        for color in 1..=k {
            if prev_colors[0] == color && prev_colors[1] == color {
                continue;
            }
            let mut colors = prev_colors.clone();
            if prev_colors[0] == -1 {
                colors[0] = color;
            } else if prev_colors[1] == -1 {
                colors[1] = color;
            } else {
                colors[0] = colors[1];
                colors[1] = color;
            }
            count += num_ways(n - 1, k, colors, memo);
        }
        memo.insert(key, count);
        count
    }

    num_ways(n, k, [0, 0], &mut HashMap::new())
}

fn main() {
    println!("{}", num_ways(3, 2)); // 6
    println!("{}", num_ways(1, 1)); // 1
    println!("{}", num_ways(7, 2)); // 42
    println!("{}", num_ways(2, 3)); // 9
    println!("{}", num_ways(2, 46340)); // 2147395600
}
