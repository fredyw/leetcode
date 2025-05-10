// https://leetcode.com/problems/paint-fence/
pub fn num_ways(n: i32, k: i32) -> i32 {
    fn num_ways(n: i32, k: i32, index: i32, prev_colors: [i32; 2]) -> i32 {
        if index == n {
            return 1;
        }
        let mut count = 0;
        for color in 0..k {
            if prev_colors[0] == color && prev_colors[1] == color {
                continue;
            }
            let mut colors = [-1; 2];
            if prev_colors[0] == -1 {
                colors[0] = color;
            } else if prev_colors[1] == -1 {
                colors[1] = color;
            } else {
                colors[0] = prev_colors[1];
                colors[1] = color;
            }
            count += num_ways(n, k, index + 1, colors);
        }
        count
    }

    num_ways(n, k, 0, [-1, -1])
}

fn main() {
    println!("{}", num_ways(3, 2)); // 6
                                    // println!("{}", num_ways(1, 1)); // 1
                                    // println!("{}", num_ways(7, 2)); // 42
                                    // println!("{}", num_ways(2, 3)); // 9
}
