// https://leetcode.com/problems/fill-a-special-grid/
pub fn special_grid(n: i32) -> Vec<Vec<i32>> {
    fn special_grid(row: usize, col: usize, n: i32, num: &mut i32, answer: &mut Vec<Vec<i32>>) {
        answer[row][col] = *num;
        answer[row + 1][col] = *num + 1;
        answer[row + 1][col - 1] = *num + 2;
        answer[row][col - 1] = *num + 3;
        *num += 4;
    }

    let mut answer = vec![vec![0; 2u32.pow(n as u32) as usize]; 2u32.pow(n as u32) as usize];
    let num_rows = answer.len();
    let num_cols = if num_rows > 0 { answer[0].len() } else { 0 };
    special_grid(0, num_cols - 1, n, &mut 0, &mut answer);
    answer
}

fn main() {
    println!("{:?}", special_grid(0)); // [[0]]

    // [3,0]
    // [2,1]
    println!("{:?}", special_grid(1)); // [[3,0],[2,1]]

    // [15,12,3,0]
    // [14,13,2,1]
    // [11, 8,7,4]
    // [10, 9,6,5]
    println!("{:?}", special_grid(2)); // [[15,12,3,0],[14,13,2,1],[11,8,7,4],[10,9,6,5]]

    // [63,60,51,48,15,12, 3, 0]
    // [62,61,50,49,14,13, 2, 1]
    // [59,56,55,52,11, 8, 7, 4]
    // [58,57,54,53,10, 9, 6, 5]
    // [47,44,35,32,31,28,19,16]
    // [46,45,34,33,30,29,18,17]
    // [43,40,39,36,27,24,23,20]
    // [42,41,38,37,26,25,22,21]
    println!("{:?}", special_grid(3)); // [[63,60,51,48,15,12,3,0],[62,61,50,49,14,13,2,1],[59,56,55,52,11,8,7,4],[58,57,54,53,10,9,6,5],[47,44,35,32,31,28,19,16],[46,45,34,33,30,29,18,17],[43,40,39,36,27,24,23,20],[42,41,38,37,26,25,22,21]]
}
