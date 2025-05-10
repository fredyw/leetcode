// https://leetcode.com/problems/paint-fence/
pub fn num_ways(n: i32, k: i32) -> i32 {
    fn num_ways(n: i32, k: i32, prev_colors: [i32; 2], memo: &mut Vec<Vec<Vec<i32>>>) -> i32 {
        if n == 0 {
            return 1;
        }
        if memo[n as usize][prev_colors[0] as usize][prev_colors[1] as usize] != -1 {
            return memo[n as usize][prev_colors[0] as usize][prev_colors[1] as usize];
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
        memo[n as usize][prev_colors[0] as usize][prev_colors[1] as usize] = count;
        count
    }

    num_ways(
        n,
        k,
        [0, 0],
        &mut vec![vec![vec![-1; k as usize + 1]; k as usize + 1]; n as usize + 1],
    )
}

fn main() {
    println!("{}", num_ways(3, 2)); // 6
    println!("{}", num_ways(1, 1)); // 1
    println!("{}", num_ways(7, 2)); // 42
    println!("{}", num_ways(2, 3)); // 9
}
