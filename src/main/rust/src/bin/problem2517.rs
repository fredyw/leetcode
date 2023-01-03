// https://leetcode.com/problems/maximum-tastiness-of-candy-basket/
pub fn maximum_tastiness(mut price: Vec<i32>, k: i32) -> i32 {
    fn check(diff: i32, price: &Vec<i32>, k: i32) -> bool {
        let mut count = 1;
        let mut last = price[0];
        let mut i = 1;
        while count < k && i < price.len() {
            if price[i] - last >= diff {
                last = price[i];
                count += 1;
            }
            i += 1;
        }
        count == k
    }

    price.sort();
    let mut lo = 0;
    let mut hi = 0;
    for p in price.iter() {
        lo = lo.min(*p);
        hi = hi.max(*p);
    }
    while lo < hi {
        let mid = lo + (hi - lo) / 2;
        if check(mid, &price, k) {
            lo = mid + 1;
        } else {
            hi = mid;
        }
    }
    lo - 1
}

fn main() {
    println!("{}", maximum_tastiness(vec![13, 5, 1, 8, 21, 2], 3)); // 8
    println!("{}", maximum_tastiness(vec![1, 3, 1], 2)); // 2
    println!("{}", maximum_tastiness(vec![7, 7, 7, 7], 2)); // 0
    println!(
        "{}",
        maximum_tastiness(vec![1, 2, 3, 4, 5, 6, 7, 8, 9, 10], 2)
    ); // 9
    println!(
        "{}",
        maximum_tastiness(vec![1, 2, 3, 4, 5, 6, 7, 8, 9, 10], 3)
    ); // 4
}
