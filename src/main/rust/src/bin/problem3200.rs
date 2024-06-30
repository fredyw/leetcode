// https://leetcode.com/problems/maximum-height-of-a-triangle/description/
pub fn max_height_of_triangle(red: i32, blue: i32) -> i32 {
    fn triangle(mut a: i32, mut b: i32) -> i32 {
        let mut i = 0;
        let mut a_first = true;
        loop {
            if a_first {
                if a - i < 0 {
                    break;
                }
                a -= i;
            } else {
                if b - i < 0 {
                    break;
                }
                b -= i;
            }
            a_first = !a_first;
            i += 1;
        }
        i - 1
    }

    triangle(red, blue).max(triangle(blue, red))
}

fn main() {
    println!("{}", max_height_of_triangle(2, 4)); // 3
    println!("{}", max_height_of_triangle(2, 1)); // 2
    println!("{}", max_height_of_triangle(1, 1)); // 1
    println!("{}", max_height_of_triangle(10, 1)); // 2
}
