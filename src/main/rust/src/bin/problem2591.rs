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
            if money == 7 {
                answer += 1;
            } else if answer > 0 && money == 3 {
                // Avoid giving 4 to a child.
                answer -= 1;
            }
            break;
        }
        if money < 7 {
            break;
        }
        if money >= 7 {
            answer += 1;
            money -= 7;
        }
    }
    answer
}

fn main() {
    println!("{}", dist_money(20, 3)); // 1
    println!("{}", dist_money(16, 2)); // 2
    println!("{}", dist_money(200, 30)); // 24
    println!("{}", dist_money(200, 11)); // 10
    println!("{}", dist_money(2, 2)); // 0
    println!("{}", dist_money(5, 2)); // 0
    println!("{}", dist_money(13, 3)); // 1
}
