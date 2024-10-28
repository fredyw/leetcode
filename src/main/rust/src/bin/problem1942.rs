use std::cmp::Reverse;
use std::collections::{BinaryHeap, HashMap};

// https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair/description/
pub fn smallest_chair(times: Vec<Vec<i32>>, target_friend: i32) -> i32 {
    #[derive(Ord, PartialOrd, Eq, PartialEq, Debug)]
    struct Time {
        arrival: i32,
        leaving: i32,
        friend: i32,
    }

    #[derive(Ord, PartialOrd, Eq, PartialEq, Debug)]
    struct Chair {
        leaving: i32,
        chair: i32,
    }

    let mut times: Vec<Time> = times
        .into_iter()
        .enumerate()
        .map(|(i, t)| Time {
            arrival: t[0],
            leaving: t[1],
            friend: i as i32,
        })
        .collect();
    times.sort_by(|a, b| a.arrival.cmp(&b.arrival));
    let mut leaving_heap: BinaryHeap<Reverse<Chair>> = BinaryHeap::new();
    let mut friend_to_chair_map: HashMap<i32, i32> = HashMap::new();
    let mut available_chairs: BinaryHeap<Reverse<i32>> = BinaryHeap::new();
    let mut num_chairs = 0;
    for time in times.iter() {
        while let Some(chair) = leaving_heap.peek() {
            let leaving_time = chair.0.leaving;
            let chair_no = chair.0.chair;
            if time.arrival < leaving_time {
                break;
            }
            leaving_heap.pop();
            available_chairs.push(Reverse(chair_no));
        }
        if let Some(smallest_chair) = available_chairs.pop() {
            friend_to_chair_map.insert(time.friend, smallest_chair.0);
            leaving_heap.push(Reverse(Chair {
                leaving: time.leaving,
                chair: smallest_chair.0,
            }));
        } else {
            friend_to_chair_map.insert(time.friend, num_chairs);
            leaving_heap.push(Reverse(Chair {
                leaving: time.leaving,
                chair: num_chairs,
            }));
            num_chairs += 1;
        }
    }
    *friend_to_chair_map.get(&target_friend).unwrap()
}

fn main() {
    println!(
        "{}",
        smallest_chair(vec![vec![1, 4], vec![2, 3], vec![4, 6]], 1)
    ); // 1
    println!(
        "{}",
        smallest_chair(vec![vec![3, 10], vec![1, 5], vec![2, 6]], 0)
    ); // 2
    println!(
        "{}",
        smallest_chair(vec![vec![1, 4], vec![2, 3], vec![5, 6]], 2)
    ); // 0
    println!(
        "{}",
        smallest_chair(vec![vec![1, 4], vec![2, 3], vec![4, 6]], 2)
    ); // 0
    println!(
        "{}",
        smallest_chair(vec![vec![1, 3], vec![2, 4], vec![4, 6]], 2)
    ); // 0
    println!(
        "{}",
        smallest_chair(
            vec![
                vec![1, 5],
                vec![2, 6],
                vec![3, 20],
                vec![4, 8],
                vec![5, 6],
                vec![7, 8]
            ],
            3
        )
    ); // 3
    println!(
        "{}",
        smallest_chair(
            vec![
                vec![1, 5],
                vec![2, 6],
                vec![3, 20],
                vec![4, 8],
                vec![5, 6],
                vec![7, 8]
            ],
            4
        )
    ); // 0
    println!(
        "{}",
        smallest_chair(
            vec![
                vec![1, 5],
                vec![2, 6],
                vec![3, 20],
                vec![4, 8],
                vec![5, 6],
                vec![7, 8]
            ],
            5
        )
    ); // 0
}
