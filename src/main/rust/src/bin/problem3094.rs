unsafe fn common_bits(num: i32) -> i32 {
    unimplemented!()
}

// https://leetcode.com/problems/guess-the-number-using-bitwise-questions-ii/description/
unsafe fn find_number() -> i32 {
    let mut answer = 0;
    for i in 0..30 {
        if common_bits(1 << i) > common_bits(1 << i) {
            answer |= (1 << i);
        }
    }
    answer
}

fn main() {}
