// https://leetcode.com/problems/remove-interval/description/
pub fn remove_interval(intervals: Vec<Vec<i32>>, to_be_removed: Vec<i32>) -> Vec<Vec<i32>> {
    let mut answer = vec![];
    for interval in intervals {
        if interval[0] > to_be_removed[1] || interval[1] < to_be_removed[0] {
            answer.push(vec![interval[0], interval[1]]);
        } else {
            if interval[0] < to_be_removed[0] {
                answer.push(vec![interval[0], to_be_removed[0]]);
            }
            if interval[1] > to_be_removed[1] {
                answer.push(vec![to_be_removed[1], interval[1]]);
            }
        }
    }
    answer
}

fn main() {
    println!(
        "{:?}",
        remove_interval(vec![vec![0, 2], vec![3, 4], vec![5, 7]], vec![1, 6])
    ); // [[0,1],[6,7]]
    println!("{:?}", remove_interval(vec![vec![0, 5]], vec![2, 3])); // [[0,2],[3,5]]
    println!(
        "{:?}",
        remove_interval(vec![vec![0, 5], vec![6, 7]], vec![2, 3])
    ); // [[0,2],[3,5],[6,7]]
    println!(
        "{:?}",
        remove_interval(
            vec![
                vec![-5, -4],
                vec![-3, -2],
                vec![1, 2],
                vec![3, 5],
                vec![8, 9]
            ],
            vec![-1, 4]
        )
    ); // [[-5,-4],[-3,-2],[4,5],[8,9]]
    println!(
        "{:?}",
        remove_interval(vec![vec![0, 2], vec![3, 4], vec![5, 7]], vec![2, 5])
    ); // [[0,2],[5,7]]
    println!(
        "{:?}",
        remove_interval(vec![vec![4, 6], vec![10, 11]], vec![3, 12])
    ); // []
    println!("{:?}", remove_interval(vec![vec![0, 100]], vec![0, 50])); // [[50,100]]
    println!("{:?}", remove_interval(vec![vec![0, 100]], vec![50, 100])); // [[0,50]]
}
