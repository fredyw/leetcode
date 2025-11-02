// https://leetcode.com/problems/maximum-calories-burnt-from-jumps/description/
pub fn max_calories_burnt(mut heights: Vec<i32>) -> i64 {
    heights.sort();
    let mut answer = 0;
    let mut i: isize = 0;
    let mut j: isize = heights.len() as isize - 1;
    let mut from = 0;
    let mut right = true;
    while i <= j {
        if right {
            answer += ((from - heights[j as usize]) as i64).pow(2);
            from = heights[j as usize];
            j -= 1;
        } else {
            answer += ((from - heights[i as usize]) as i64).pow(2);
            from = heights[i as usize];
            i += 1;
        }
        right = !right;
    }
    answer
}

fn main() {
    println!("{}", max_calories_burnt(vec![1, 7, 9])); // 181
    println!("{}", max_calories_burnt(vec![5, 2, 4])); // 38
    println!("{}", max_calories_burnt(vec![3, 3])); // 9
    println!("{}", max_calories_burnt(vec![100000])); // 10000000000
}
