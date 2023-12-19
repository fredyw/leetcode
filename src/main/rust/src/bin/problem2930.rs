// https://leetcode.com/problems/number-of-strings-which-can-be-rearranged-to-contain-substring/description/
pub fn string_count(n: i32) -> i32 {
    fn string_count(
        n: i32,
        l_count: i32,
        e_count: i32,
        t_count: i32,
        memo: &mut Vec<Vec<Vec<Vec<i32>>>>,
    ) -> i32 {
        if n == 0 {
            return if l_count <= 0 && e_count <= 0 && t_count <= 0 {
                1
            } else {
                0
            };
        }
        if memo[n as usize][l_count as usize][e_count as usize][t_count as usize] != -1 {
            return memo[n as usize][l_count as usize][e_count as usize][t_count as usize];
        }
        let mut count: i64 = 0;
        for c in 'a'..='z' {
            if c == 'l' {
                count += string_count(n - 1, (l_count - 1).max(0), e_count, t_count, memo) as i64
                    % 1_000_000_007;
            } else if c == 'e' {
                count += string_count(n - 1, l_count, (e_count - 1).max(0), t_count, memo) as i64
                    % 1_000_000_007;
            } else if c == 't' {
                count += string_count(n - 1, l_count, e_count, (t_count - 1).max(0), memo) as i64
                    % 1_000_000_007;
            } else {
                count +=
                    string_count(n - 1, l_count, e_count, t_count, memo) as i64 % 1_000_000_007;
            }
        }
        memo[n as usize][l_count as usize][e_count as usize][t_count as usize] =
            (count % 1_000_000_007) as i32;
        memo[n as usize][l_count as usize][e_count as usize][t_count as usize]
    }

    string_count(
        n,
        1,
        2,
        1,
        &mut vec![vec![vec![vec![-1; /* l */ 3]; /* e */ 4]; /* t */ 3]; n as usize + 1],
    )
}

fn main() {
    println!("{}", string_count(4)); // 12
    println!("{}", string_count(10)); // 83943898
    println!("{}", string_count(3)); // 0
    println!("{}", string_count(5)); // 1460
    println!("{}", string_count(6)); // 106620
}
