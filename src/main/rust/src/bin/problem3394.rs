// https://leetcode.com/problems/check-if-grid-can-be-cut-into-sections/description/
pub fn check_valid_cuts(n: i32, rectangles: Vec<Vec<i32>>) -> bool {
    let mut x_vec: Vec<(i32, i32)> = vec![];
    let mut y_vec: Vec<(i32, i32)> = vec![];
    for rectangle in rectangles {
        x_vec.push((rectangle[0], rectangle[2]));
        y_vec.push((rectangle[1], rectangle[3]));
    }
    x_vec.sort();
    let mut count = 0;
    let mut max = 0;
    for (start, end) in x_vec.iter() {
        if max <= *start {
            count += 1;
        }
        max = max.max(*end);
    }
    if count >= 2 {
        return true;
    }
    y_vec.sort();
    let mut count = 0;
    let mut max = 0;
    for (start, end) in y_vec.iter() {
        if max <= *start {
            count += 1;
        }
        max = max.max(*end);
    }
    count >= 2
}

fn main() {
    // println!(
    //     "{}",
    //     check_valid_cuts(
    //         5,
    //         vec![
    //             vec![1, 0, 5, 2],
    //             vec![0, 2, 2, 4],
    //             vec![3, 2, 5, 3],
    //             vec![0, 4, 4, 5]
    //         ]
    //     )
    // ); // true
    // println!(
    //     "{}",
    //     check_valid_cuts(
    //         4,
    //         vec![
    //             vec![0, 0, 1, 1],
    //             vec![2, 0, 3, 4],
    //             vec![0, 2, 2, 3],
    //             vec![3, 0, 4, 3]
    //         ]
    //     )
    // ); // true
    println!(
        "{}",
        check_valid_cuts(
            4,
            vec![
                vec![0, 2, 2, 4],
                vec![1, 0, 3, 2],
                vec![2, 2, 3, 4],
                vec![3, 0, 4, 2],
                vec![3, 2, 4, 4]
            ]
        )
    ); // false
       // println!(
       //     "{}",
       //     check_valid_cuts(
       //         5,
       //         vec![
       //             vec![0, 2, 2, 4],
       //             vec![1, 0, 3, 2],
       //             vec![2, 2, 3, 4],
       //             vec![3, 0, 4, 2],
       //             vec![3, 2, 4, 4],
       //             vec![3, 4, 4, 5],
       //         ]
       //     )
       // ); // true
       // println!(
       //     "{}",
       //     check_valid_cuts(
       //         5,
       //         vec![
       //             vec![0, 2, 2, 4],
       //             vec![1, 0, 3, 2],
       //             vec![2, 2, 3, 4],
       //             vec![3, 0, 4, 2],
       //             vec![3, 2, 4, 4],
       //             vec![4, 0, 5, 1],
       //         ]
       //     )
       // ); // true
       // println!(
       //     "{}",
       //     check_valid_cuts(
       //         4,
       //         vec![
       //             vec![0, 2, 2, 4],
       //             vec![1, 0, 3, 2],
       //             vec![2, 2, 3, 4],
       //             vec![3, 0, 4, 2],
       //             vec![3, 2, 4, 4],
       //             vec![0, 0, 1, 1],
       //         ]
       //     )
       // ); // false
}
