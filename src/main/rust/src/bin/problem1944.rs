use std::collections::VecDeque;

// https://leetcode.com/problems/number-of-visible-people-in-a-queue/
pub fn can_see_persons_count(heights: Vec<i32>) -> Vec<i32> {
    let mut answer: Vec<i32> = vec![0; heights.len()];
    let mut deque: VecDeque<i32> = VecDeque::new();
    for i in (0..heights.len()).rev() {
        let height = &heights[i];
        let mut count = 0;
        loop {
            let front = deque.front();
            match front {
                Some(value) => {
                    if height > value {
                        deque.pop_front();
                        count += 1;
                    } else {
                        count += 1;
                        break;
                    }
                }
                None => break,
            }
        }
        answer[i] = count;
        deque.push_front(*height);
    }
    answer
}

fn main() {
    println!("{:?}", can_see_persons_count(vec![10, 6, 8, 5, 11, 9])); // [3,1,2,1,1,0]
    println!("{:?}", can_see_persons_count(vec![5, 1, 2, 3, 10])); // [4,1,1,1,0]
}
