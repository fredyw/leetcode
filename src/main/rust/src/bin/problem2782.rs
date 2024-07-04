// https://leetcode.com/problems/number-of-unique-categories/description/
struct CategoryHandler {}

impl CategoryHandler {
    pub fn new(categories: Vec<i32>) -> Self {
        unimplemented!()
    }
    pub fn have_same_category(&self, a: i32, b: i32) -> bool {
        unimplemented!()
    }
}

pub fn number_of_categories(n: i32, category_handler: CategoryHandler) -> i32 {
    let mut v = vec![];
    for i in 0..n {
        v.push(i);
    }
    let mut answer = 0;
    while !v.is_empty() {
        let mut tmp: Vec<i32> = vec![];
        for i in 1..v.len() {
            if !category_handler.have_same_category(v[0], v[i]) {
                tmp.push(v[i]);
            }
        }
        v = tmp;
        answer += 1;
    }
    answer
}

fn main() {}
