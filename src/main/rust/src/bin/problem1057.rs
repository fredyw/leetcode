// https://leetcode.com/problems/campus-bikes/description/
pub fn assign_bikes(workers: Vec<Vec<i32>>, bikes: Vec<Vec<i32>>) -> Vec<i32> {
    fn manhattan(x1: i32, y1: i32, x2: i32, y2: i32) -> i32 {
        (x1 - x2).abs() + (y1 - y2).abs()
    }

    let mut v: Vec<(i32, usize, usize)> = vec![];
    for worker in 0..workers.len() {
        for bike in 0..bikes.len() {
            let distance = manhattan(
                workers[worker][0],
                workers[worker][1],
                bikes[bike][0],
                bikes[bike][1],
            );
            v.push((distance, worker, bike));
        }
    }
    v.sort_by(|a, b| a.cmp(&b));
    let mut answer = vec![0; workers.len()];
    let mut workers_assigned = vec![false; workers.len()];
    let mut bikes_assigned = vec![false; bikes.len()];
    for (_, worker, bike) in v.iter() {
        if workers_assigned[*worker] || bikes_assigned[*bike] {
            continue;
        }
        workers_assigned[*worker] = true;
        bikes_assigned[*bike] = true;
        answer[*worker] = *bike as i32;
    }
    answer
}

fn main() {
    println!(
        "{:?}",
        assign_bikes(vec![vec![0, 0], vec![2, 1]], vec![vec![1, 2], vec![3, 3]])
    ); // [1,0]
    println!(
        "{:?}",
        assign_bikes(
            vec![vec![0, 0], vec![1, 1], vec![2, 0]],
            vec![vec![1, 0], vec![2, 2], vec![2, 1]]
        )
    ); // [0,2,1]
    println!(
        "{:?}",
        assign_bikes(
            vec![vec![0, 0], vec![1, 1], vec![2, 0]],
            vec![vec![1, 0], vec![2, 2], vec![2, 1], vec![3, 1]]
        )
    ); // [0,2,1]
}
