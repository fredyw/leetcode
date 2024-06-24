// https://leetcode.com/problems/walls-and-gates/
pub fn walls_and_gates(rooms: &mut Vec<Vec<i32>>) {
    todo!()
}

fn main() {
    let mut rooms = vec![
        vec![2147483647, -1, 0, 2147483647],
        vec![2147483647, 2147483647, 2147483647, -1],
        vec![2147483647, -1, 2147483647, -1],
        vec![0, -1, 2147483647, 2147483647],
    ];
    walls_and_gates(&mut rooms);
    println!("{:?}", rooms); // [[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]

    let mut rooms = vec![vec![-1]];
    walls_and_gates(&mut rooms);
    println!("{:?}", rooms); // [[-1]]

    let mut rooms = vec![
        vec![2147483647, -1, 0, 2147483647],
        vec![2147483647, 2147483647, 2147483647, -1],
        vec![2147483647, -1, 2147483647, -1],
        vec![0, -1, 2147483647, 0],
    ];
    walls_and_gates(&mut rooms);
    println!("{:?}", rooms); // [[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,1,0]]
}
