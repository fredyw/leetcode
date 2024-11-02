// https://leetcode.com/problems/strobogrammatic-number-ii/description/
pub fn find_strobogrammatic(n: i32) -> Vec<String> {
    fn find_strobogrammatic(n: i32, v: Vec<String>) -> Vec<String> {
        if n <= 0 {
            if v[0].len() == 1 {
                v
            } else {
                v.into_iter()
                    .filter(|v| v.as_bytes()[0] != '0' as u8)
                    .collect()
            }
        } else {
            let mut new_vec: Vec<String> = vec![];
            for s in v {
                new_vec.push(format!("0{}0", s));
                new_vec.push(format!("1{}1", s));
                new_vec.push(format!("6{}9", s));
                new_vec.push(format!("8{}8", s));
                new_vec.push(format!("9{}6", s));
            }
            find_strobogrammatic(n - 2, new_vec)
        }
    }

    if n % 2 == 0 {
        find_strobogrammatic(
            n - 2,
            vec![
                "00".to_string(),
                "11".to_string(),
                "69".to_string(),
                "88".to_string(),
                "96".to_string(),
            ],
        )
    } else {
        find_strobogrammatic(
            n - 2,
            vec!["0".to_string(), "1".to_string(), "8".to_string()],
        )
    }
}

fn main() {
    println!("{:?}", find_strobogrammatic(1)); // ["0","1","8"]
    println!("{:?}", find_strobogrammatic(2)); // ["11","69","88","96"]
    println!("{:?}", find_strobogrammatic(3)); // ["101","111","181","609","619","689","808","818","888","906","916","986"]
    println!("{:?}", find_strobogrammatic(4)); // ["1001","1111","1691","1881","1961","6009","6119","6699","6889","6969","8008","8118","8698","8888","8968","9006","9116","9696","9886","9966"]
}
