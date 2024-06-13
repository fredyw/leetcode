// https://leetcode.com/problems/moving-average-from-data-stream/description/
struct MovingAverage {}

impl MovingAverage {
    fn new(size: i32) -> Self {
        todo!()
    }

    fn next(&self, val: i32) -> f64 {
        todo!()
    }
}

fn main() {
    let moving_average = MovingAverage::new(3);
    println!("{}", moving_average.next(1)); // 1.0
    println!("{}", moving_average.next(10)); // 5.5
    println!("{}", moving_average.next(3)); // 4.66667
    println!("{}", moving_average.next(5)); // 6.0
}
