// https://leetcode.com/problems/output-contest-matches/description/
pub fn find_contest_match(n: i32) -> String {
    todo!()
}

fn main() {
    println!("{}", find_contest_match(4)); // "((1,4),(2,3))"
    println!("{}", find_contest_match(8)); // "(((1,8),(4,5)),((2,7),(3,6)))"
    println!("{}", find_contest_match(16)); // "((((1,16),(8,9)),((4,13),(5,12))),(((2,15),(7,10)),((3,14),(6,11))))"
}
