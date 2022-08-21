use std::collections::HashMap;

// https://leetcode.com/problems/intervals-between-identical-elements/
pub fn get_distances(arr: Vec<i32>) -> Vec<i64> {
    #[derive(Debug)]
    struct S {
        sum: i64,
        size: i64,
        prefix_sums: HashMap<usize, (i64, i64)>,
    }
    let mut map: HashMap<i32, S> = HashMap::new();
    for (i, num) in arr.iter().enumerate() {
        let s = map.entry(*num).or_insert(S {
            sum: 0,
            size: 0,
            prefix_sums: HashMap::new(),
        });
        s.sum += i as i64;
        s.size += 1;
        s.prefix_sums.insert(i, (s.sum, s.size));
    }
    let mut answer = vec![0; arr.len()];
    for (i, num) in arr.iter().enumerate() {
        let s = map.get(num).unwrap();
        let (prefix_sum, prefix_size) = s.prefix_sums.get(&i).unwrap();
        // Example:
        // [1, 3, 5, 7, 9] --> list of indexes of number X
        //  left --- right
        // Index 3: |5 - 1| + |5 - 3| + |5 - 7| + |5 - 9| = 4 + 2 + 2 + 4 = 12
        //          ------left ------   ----- right -----
        // left sum : | (1 + 3) - (5 * 2) | = | 4 - 10 | = 6
        // right sum: | (7 + 9) - (5 * 2) | = | 16 - 10 | = 6
        // total sum = left sum + right sum = 6 + 6 = 12
        let left = i64::abs(prefix_sum - (i as i64 * prefix_size));
        let right = i64::abs(s.sum - prefix_sum - (i as i64 * (s.size - prefix_size)));
        answer[i] = left + right;
    }
    answer
}

fn main() {
    println!("{:?}", get_distances(vec![2, 1, 3, 1, 2, 3, 3])); // [4,2,7,2,4,4,5]
    println!("{:?}", get_distances(vec![10, 5, 10, 10])); // [5,0,3,4]
}
