// https://leetcode.com/problems/maximum-earnings-from-taxi/
pub fn max_taxi_earnings(n: i32, mut rides: Vec<Vec<i32>>) -> i64 {
    fn f(rides: &Vec<Vec<i32>>, index: usize, memo: &mut Vec<i64>) -> i64 {
        if memo[index] != -1 {
            return memo[index];
        }
        let v = rides.get(index).unwrap();
        let start = v[0];
        let end = v[1];
        let tip = v[2];
        let earn = (end - start + tip) as i64;
        let mut i: i32 = match rides.binary_search_by(|a| a.get(0).unwrap().cmp(&end)) {
            Ok(i) => i as i32,
            Err(i) => i as i32,
        };
        if let Some(v) = rides.get(i as usize) {
            let s = v.get(0).unwrap();
            let mut found = false;
            while i >= 0 && rides.get(i as usize).unwrap().get(0).unwrap() == s {
                found = true;
                i -= 1;
            }
            if found {
                i += 1;
            }
        }
        let mut max = earn;
        for j in (i as usize)..rides.len() {
            max = max.max(f(rides, j, memo) + earn);
        }
        memo[index] = max;
        max
    }

    rides.sort_by(|a, b| a.get(0).unwrap().cmp(b.get(0).unwrap()));
    let mut answer = 0;
    let mut memo = vec![-1; n as usize];
    for i in 0..rides.len() {
        answer = answer.max(f(&rides, i, &mut memo));
    }
    answer
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
}
