// https://leetcode.com/problems/maximum-earnings-from-taxi/
pub fn max_taxi_earnings(n: i32, mut rides: Vec<Vec<i32>>) -> i64 {
    fn f(rides: &Vec<Vec<i32>>, index: usize, memo: &mut Vec<i64>) -> i64 {
        if index >= rides.len() {
            return 0;
        }
        if memo[index] != -1 {
            return memo[index];
        }
        let v = rides.get(index).unwrap();
        let start = v[0];
        let end = v[1];
        let tip = v[2];
        let profit = (end - start + tip) as i64;
        let mut i: i32 = match rides.binary_search_by(|a| a.get(0).unwrap().cmp(&end)) {
            Ok(i) => i as i32,
            Err(i) => i as i32,
        };
        if let Some(v) = rides.get(i as usize) {
            let s = v.get(0).unwrap();
            while i - 1 >= 0 && rides.get(i as usize - 1).unwrap().get(0).unwrap() == s {
                i -= 1;
            }
        }
        let max = f(rides, index as usize + 1, memo).max(f(rides, i as usize, memo) + profit);
        memo[index] = max;
        max
    }

    rides.sort_by(|a, b| a.get(0).unwrap().cmp(b.get(0).unwrap()));
    f(&rides, 0, &mut vec![-1; rides.len()])
}

fn main() {
    println!(
        "{}",
        max_taxi_earnings(5, vec![vec![2, 5, 4], vec![1, 5, 1]])
    ); // 7
    println!(
        "{}",
        max_taxi_earnings(
            20,
            vec![
                vec![1, 6, 1],
                vec![3, 10, 2],
                vec![10, 12, 3],
                vec![11, 12, 2],
                vec![12, 15, 2],
                vec![13, 18, 1]
            ]
        )
    ); // 20
    println!(
        "{}",
        max_taxi_earnings(
            10,
            vec![
                vec![5, 6, 10],
                vec![1, 5, 3],
                vec![7, 9, 6],
                vec![2, 6, 2],
                vec![5, 6, 4],
                vec![4, 10, 8],
                vec![8, 10, 9],
                vec![5, 10, 1],
                vec![9, 10, 5],
                vec![1, 6, 10]
            ]
        )
    ); // 32
    println!(
        "{}",
        max_taxi_earnings(
            4,
            vec![
                vec![2, 3, 5],
                vec![1, 3, 2],
                vec![2, 4, 3],
                vec![1, 4, 1],
                vec![3, 4, 10],
                vec![1, 3, 4]
            ]
        )
    ); // 17
}
