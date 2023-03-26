// https://leetcode.com/problems/k-items-with-the-maximum-sum/
pub fn k_items_with_maximum_sum(num_ones: i32, num_zeros: i32, num_neg_ones: i32, k: i32) -> i32 {
    let mut answer = 0;
    let mut count = k;
    if count <= num_ones {
        return answer + count;
    }
    if count > num_ones {
        answer += num_ones;
        count -= num_ones;
    }

    if count <= num_zeros {
        return answer;
    }
    if count > num_zeros {
        count -= num_zeros;
    }

    if count <= num_neg_ones {
        return answer - count;
    }
    answer
}

fn main() {
    println!("{}", k_items_with_maximum_sum(3, 2, 0, 2)); // 2
    println!("{}", k_items_with_maximum_sum(3, 2, 0, 4)); // 3
}
