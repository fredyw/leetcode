// https://leetcode.com/problems/product-of-two-run-length-encoded-arrays/description/
pub fn find_rle_array(mut encoded1: Vec<Vec<i32>>, mut encoded2: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
    fn update_rle(rle: &mut Vec<Vec<i32>>, product: i32, count: i32) {
        if let Some(last) = rle.last_mut() {
            if last[0] == product {
                last[1] += count;
            } else {
                rle.push(vec![product, count]);
            }
        } else {
            rle.push(vec![product, count]);
        }
    }

    let mut answer: Vec<Vec<i32>> = vec![];
    let mut i = 0;
    let mut j = 0;
    while i < encoded1.len() || j < encoded2.len() {
        let num1 = encoded1[i][0];
        let count1 = encoded1[i][1];
        let num2 = encoded2[j][0];
        let count2 = encoded2[j][1];
        let product = num1 * num2;
        if count1 < count2 {
            encoded1[i][1] = 0;
            encoded2[j][1] -= count1;
            update_rle(&mut answer, product, count1);
            i += 1;
        } else if count1 == count2 {
            update_rle(&mut answer, product, count1);
            i += 1;
            j += 1;
        } else {
            encoded2[j][1] = 0;
            encoded1[i][1] -= count2;
            update_rle(&mut answer, product, count2);
            j += 1;
        }
    }
    answer
}

fn main() {
    println!(
        "{:?}",
        find_rle_array(vec![vec![1, 3], vec![2, 3]], vec![vec![6, 3], vec![3, 3]])
    ); // [[6,6]]
    println!(
        "{:?}",
        find_rle_array(
            vec![vec![1, 3], vec![2, 1], vec![3, 2]],
            vec![vec![2, 3], vec![3, 3]]
        )
    ); // [[2,3],[6,1],[9,2]]
}
