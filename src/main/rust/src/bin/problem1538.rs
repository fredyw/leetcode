// https://leetcode.com/problems/guess-the-majority-in-a-hidden-array/
struct ArrayReader;

impl ArrayReader {
    // Compares 4 different elements in the array
    // return 4 if the values of the 4 elements are the same (0 or 1).
    // return 2 if three elements have a value equal to 0 and one element has value equal to 1 or vice versa.
    // return 0 : if two element have a value equal to 0 and two elements have a value equal to 1.
    pub fn query(&self, a: i32, b: i32, c: i32, d: i32) -> i32 {
        unimplemented!()
    }

    // Returns the length of the array
    pub fn length(&self) -> i32 {
        unimplemented!()
    }
}

pub fn get_majority(reader: &ArrayReader) -> i32 {
    fn f(
        equal: bool,
        i: i32,
        count_equal: &mut i32,
        count_differ: &mut i32,
        index_differ: &mut i32,
    ) {
        if equal {
            *count_equal += 1;
        } else {
            *count_differ += 1;
            *index_differ = i;
        }
    }

    let mut count_equal = 1;
    let mut count_differ = 0;
    let mut index_differ = -1;
    let query_0123 = reader.query(0, 1, 2, 3);
    let query_1234 = reader.query(1, 2, 3, 4);
    f(
        query_0123 == query_1234,
        4,
        &mut count_equal,
        &mut count_differ,
        &mut index_differ,
    );
    for i in 5..reader.length() {
        f(
            reader.query(1, 2, 3, i) == query_0123,
            i,
            &mut count_equal,
            &mut count_differ,
            &mut index_differ,
        );
    }
    f(
        reader.query(0, 2, 3, 4) == query_1234,
        1,
        &mut count_equal,
        &mut count_differ,
        &mut index_differ,
    );
    f(
        reader.query(0, 1, 3, 4) == query_1234,
        2,
        &mut count_equal,
        &mut count_differ,
        &mut index_differ,
    );
    f(
        reader.query(0, 1, 2, 4) == query_1234,
        3,
        &mut count_equal,
        &mut count_differ,
        &mut index_differ,
    );
    if count_equal > count_differ {
        0
    } else {
        if count_differ > count_equal {
            index_differ
        } else {
            -1
        }
    }
}

fn main() {}
