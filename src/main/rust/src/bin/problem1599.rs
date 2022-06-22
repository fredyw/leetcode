// https://leetcode.com/problems/maximum-profit-of-operating-a-centennial-wheel/
pub fn min_operations_max_profit(
    customers: Vec<i32>,
    boarding_cost: i32,
    running_cost: i32,
) -> i32 {
    let mut answer = -1;
    let mut max_profit = 0;
    let mut i = 1;
    let mut wait = 0;
    let mut num_customer = 0;
    for customer in customers {
        let tmp = wait;
        wait -= 4;
        wait += customer;
        if wait < 0 {
            wait = 0;
            num_customer += tmp + customer;
        } else {
            num_customer += 4;
        }
        let profit = (num_customer * boarding_cost) - (i * running_cost);
        if max_profit < profit {
            answer = i;
            max_profit = profit;
        }
        i += 1;
    }
    while wait > 0 {
        if wait - 4 < 0 {
            num_customer += wait;
        } else {
            num_customer += 4;
        }
        let profit = (num_customer * boarding_cost) - (i * running_cost);
        if max_profit < profit {
            answer = i;
            max_profit = profit;
        }
        i += 1;
        wait -= 4;
    }
    answer
}

fn main() {
    println!("{}", min_operations_max_profit(vec![8, 3], 5, 6)); // 3
    println!("{}", min_operations_max_profit(vec![10, 9, 6], 6, 4)); // 7
    println!("{}", min_operations_max_profit(vec![3, 4, 0, 5, 1], 1, 92)); // -1
    println!("{}", min_operations_max_profit(vec![2], 2, 4)); // -1
}
