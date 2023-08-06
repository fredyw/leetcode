// https://leetcode.com/problems/account-balance-after-rounded-purchase/
pub fn account_balance_after_purchase(purchase_amount: i32) -> i32 {
    if purchase_amount % 10 == 0 {
        return 100 - purchase_amount;
    }
    let d = purchase_amount / 10;
    let r = purchase_amount % 10;
    if r < 5 {
        100 - (d * 10)
    } else {
        100 - ((d + 1) * 10)
    }
}

fn main() {
    println!("{}", account_balance_after_purchase(9)); // 90
    println!("{}", account_balance_after_purchase(15)); // 80
    println!("{}", account_balance_after_purchase(4)); // 100
    println!("{}", account_balance_after_purchase(50)); // 50
    println!("{}", account_balance_after_purchase(11)); // 90
}
