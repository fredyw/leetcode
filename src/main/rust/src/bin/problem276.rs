// https://leetcode.com/problems/paint-fence/
pub fn num_ways(n: i32, k: i32) -> i32 {
    fn num_ways(n: i32, k: i32, memo: &mut Vec<i32>) -> i32 {
        if n == 1 {
            return k;
        }
        if n == 2 {
            return k * k;
        }
        if memo[n as usize] != -1 {
            return memo[n as usize];
        }
        let count = (k - 1) * (num_ways(n - 1, k, memo) + num_ways(n - 2, k, memo));
        memo[n as usize] = count;
        count
    }

    num_ways(n, k, &mut vec![-1; n as usize + 1])
}

fn main() {
    println!("{}", num_ways(3, 2)); // 6
    println!("{}", num_ways(1, 1)); // 1
    println!("{}", num_ways(7, 2)); // 42
    println!("{}", num_ways(2, 3)); // 9
    println!("{}", num_ways(10, 6)); // 49503750
    println!("{}", num_ways(2, 46340)); // 2147395600
}
