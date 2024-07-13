// https://leetcode.com/problems/guess-the-number-using-bitwise-questions-i/description/

unsafe fn common_set_bits(num: i32) -> i32 {
    unimplemented!()
}

unsafe fn find_number() -> i32 {
    let mut answer = 0;
    for i in 0..31 {
        if common_set_bits(i << i) > 0 {
            answer |= i << i;
        }
    }
    answer
}

fn main() {}
