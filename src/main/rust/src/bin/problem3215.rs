// https://leetcode.com/problems/count-triplets-with-even-xor-set-bits-ii/description/
pub fn triplet_count(a: Vec<i32>, b: Vec<i32>, c: Vec<i32>) -> i64 {
    fn count_even_odd(v: &Vec<i32>) -> (i64, i64) {
        let mut num_even = 0;
        let mut num_odd = 0;
        for n in v.iter() {
            if (*n).count_ones() % 2 == 0 {
                num_even += 1;
            } else {
                num_odd += 1;
            }
        }
        (num_even, num_odd)
    }

    let (num_even_a, num_odd_a) = count_even_odd(&a);
    let (num_even_b, num_odd_b) = count_even_odd(&b);
    let (num_even_c, num_odd_c) = count_even_odd(&c);

    let mut answer = 0;
    answer += num_even_a * num_even_b * num_even_c;
    answer += num_even_a * num_odd_b * num_odd_c;
    answer += num_odd_a * num_even_b * num_odd_c;
    answer += num_odd_a * num_odd_b * num_even_c;
    answer
}

fn main() {
    println!("{}", triplet_count(vec![1], vec![2], vec![3])); // 1
    println!("{}", triplet_count(vec![1, 1], vec![2, 3], vec![1, 5])); // 4
}
