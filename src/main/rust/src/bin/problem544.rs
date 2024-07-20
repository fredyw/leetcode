// https://leetcode.com/problems/output-contest-matches/description/
pub fn find_contest_match(n: i32) -> String {
    fn find_contest_match(vec: Vec<String>) -> String {
        if vec.len() == 1 {
            return vec.first().unwrap().clone();
        }
        let mut new_vec: Vec<String> = vec![];
        let mut i = 0;
        let mut j = vec.len() - 1;
        while i < j {
            new_vec.push(format!("({},{})", vec[i], vec[j]));
            i += 1;
            j -= 1;
        }
        find_contest_match(new_vec)
    }

    let mut v: Vec<String> = vec![];
    for i in 1..=n {
        v.push(i.to_string());
    }
    find_contest_match(v)
}

fn main() {
    println!("{}", find_contest_match(4)); // "((1,4),(2,3))"
    println!("{}", find_contest_match(8)); // "(((1,8),(4,5)),((2,7),(3,6)))"
    println!("{}", find_contest_match(16)); // "((((1,16),(8,9)),((4,13),(5,12))),(((2,15),(7,10)),((3,14),(6,11))))"
}
