// https://leetcode.com/problems/valid-binary-strings-with-cost-limit/description/
pub fn generate_valid_strings(n: i32, k: i32) -> Vec<String> {
    fn generate(n: i32, k: i32, prev: i32, cur: i32, sum: i32) {
        if sum > k || n == cur {
            return;
        }
        if prev + 1 != cur {
            generate(n, k, cur, cur + 1, sum + cur);
        }
        generate(n, k, prev, cur + 1, sum); // skip
    }

    todo!()
}

fn main() {
    println!("{:?}", generate_valid_strings(3, 1)); // ["000","010","100"]
    println!("{:?}", generate_valid_strings(1, 0)); // ["0","1"]
}
