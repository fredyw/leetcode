// https://leetcode.com/problems/strobogrammatic-number-ii/description/
pub fn find_strobogrammatic(n: i32) -> Vec<String> {
    fn find_strobogrammatic(n: i32, accu: String, answer: &mut Vec<String>) {
        if n == 0 {
            answer.push(accu);
            return;
        }
        for char in ['1', '6', '8', '9'] {
            find_strobogrammatic(n - 1, format!("{}{}", accu, char), answer);
        }
    }

    let mut answer = vec![];
    find_strobogrammatic(n, String::new(), &mut answer);
    answer
}

fn main() {
    println!("{:?}", find_strobogrammatic(1)); // ["0","1","8"]
    println!("{:?}", find_strobogrammatic(2)); // ["11","69","88","96"]
    println!("{:?}", find_strobogrammatic(3)); // ["101","111","181","609","619","689","808","818","888","906","916","986"]
}
