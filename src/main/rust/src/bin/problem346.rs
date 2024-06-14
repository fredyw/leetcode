use std::collections::VecDeque;

// https://leetcode.com/problems/moving-average-from-data-stream/description/
struct MovingAverage {
    size: i32,
    sum: i64,
    deque: VecDeque<i32>,
}

impl MovingAverage {
    fn new(size: i32) -> Self {
        MovingAverage {
            size,
            sum: 0,
            deque: VecDeque::new(),
        }
    }

    fn next(&mut self, val: i32) -> f64 {
        self.deque.push_back(val);
        self.sum += val as i64;
        if self.deque.len() > self.size as usize {
            self.sum -= self.deque.pop_front().unwrap_or(0) as i64;
        }
        self.sum as f64 / self.deque.len() as f64
    }
}

fn main() {
    let mut moving_average = MovingAverage::new(3);
    println!("{}", moving_average.next(1)); // 1.0
    println!("{}", moving_average.next(10)); // 5.5
    println!("{}", moving_average.next(3)); // 4.66667
    println!("{}", moving_average.next(5)); // 6.0
}
