struct Street {}

impl Street {
    pub fn new(doors: Vec<i32>) -> Self {
        unimplemented!()
    }
    pub fn open_door(&mut self) {
        unimplemented!()
    }
    pub fn close_door(&mut self) {
        unimplemented!()
    }
    pub fn is_door_open(&self) -> bool {
        unimplemented!()
    }
    pub fn move_right(&mut self) {
        unimplemented!()
    }
    pub fn move_left(&mut self) {
        unimplemented!()
    }
}

// https://leetcode.com/problems/count-houses-in-a-circular-street/description/
pub fn house_count(mut street: Street, k: i32) -> i32 {
    for _ in 0..k {
        street.close_door();
        street.move_right();
    }
    street.open_door();
    street.move_right();
    let mut answer = 0;
    while !street.is_door_open() {
        street.move_right();
        answer += 1;
    }
    answer
}

fn main() {}
