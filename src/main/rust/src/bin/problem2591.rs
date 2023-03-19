// https://leetcode.com/problems/distribute-money-to-maximum-children/
pub fn dist_money(money: i32, children: i32) -> i32 {
    // Each child must get 1.
    if money < children {
        return -1;
    }
    let mut answer = 0;
    let mut money = money - children;
    for i in 0..children {
        if i == children - 1 {
            if 7 == money {
                answer += 1;
                money -= 7;
            }
        } else if 7 <= money {
            answer += 1;
            money -= 7;
        }
    }
    // We need to avoid giving 4.
    if money == 3 && answer > 0 {
        answer -= 1;
    }
    answer
}

fn main() {
    // println!("{}", dist_money(20, 3)); // 1
    // println!("{}", dist_money(16, 2)); // 2
    // println!("{}", dist_money(200, 30)); // 24
    // println!("{}", dist_money(200, 11)); // 10
    // println!("{}", dist_money(2, 2)); // 0
    // println!("{}", dist_money(5, 2)); // 0
    println!("{}", dist_money(13, 3)); // 1
}
