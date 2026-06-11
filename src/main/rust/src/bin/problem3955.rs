// https://leetcode.com/problems/valid-binary-strings-with-cost-limit/description/
pub fn generate_valid_strings(n: i32, k: i32) -> Vec<String> {
    fn generate(
        n: i32,
        k: i32,
        prev: i32,
        cur: i32,
        sum: i32,
        chars: &mut Vec<char>,
    ) -> Vec<String> {
        if sum + cur > k || n == cur {
            let s = chars.iter().collect::<String>();
            return vec![s];
        }
        let mut strings: Vec<String> = Vec::new();
        strings.extend(generate(n, k, prev, cur + 1, sum, chars)); // skip
        if prev == -1 || prev + 1 != cur {
            chars[cur as usize] = '1';
            strings.extend(generate(n, k, cur, cur + 1, sum + cur, chars));
            chars[cur as usize] = '0';
        }
        strings
    }

    generate(n, k, -1, 0, 0, &mut vec!['0'; n as usize])
}

fn main() {
    println!("{:?}", generate_valid_strings(3, 1)); // ["000","010","100"]
    println!("{:?}", generate_valid_strings(1, 0)); // ["0","1"]
}
