use std::collections::LinkedList;

// https://leetcode.com/problems/number-of-people-aware-of-a-secret/
pub fn people_aware_of_secret(n: i32, delay: i32, forget: i32) -> i32 {
    let mut answer: i64 = if 1 + forget > n { 1 } else { 0 };
    let mut list: LinkedList<i32> = LinkedList::new();
    list.push_back(1);
    loop {
        let front = list.pop_front();
        match front {
            Some(day) => {
                if day > n {
                    break;
                }
                let secret_day = day + delay;
                for d in secret_day..(secret_day + (forget - delay)) {
                    if d > n {
                        break;
                    }
                    list.push_back(d);
                    if d + forget > n {
                        answer += 1;
                    }
                }
            }
            None => break,
        }
    }
    (answer & 1_000_000_007) as i32
}

fn main() {
    // println!("{}", people_aware_of_secret(6, 2, 4)); // 5
    // println!("{}", people_aware_of_secret(4, 1, 3)); // 6
    // println!("{}", people_aware_of_secret(10, 3, 5)); // 5
    println!("{}", people_aware_of_secret(1000, 500, 600)); // 100
}
