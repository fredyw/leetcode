// https://leetcode.com/problems/even-number-of-knight-moves/description/
pub fn can_reach(start: Vec<i32>, target: Vec<i32>) -> bool {
    fn can_reach(
        start_x: i32,
        start_y: i32,
        target_x: i32,
        target_y: i32,
        count: i32,
        visited: &mut Vec<Vec<bool>>,
    ) -> bool {
        if start_x < 0
            || start_x > 8
            || start_y < 0
            || start_y > 8
            || visited[start_y as usize][start_x as usize]
        {
            return false;
        }
        if start_x == target_x && start_y == target_y {
            return count % 2 == 0;
        }
        visited[start_y as usize][start_x as usize] = true;
        let a = can_reach(
            start_x - 2,
            start_y - 1,
            target_x,
            target_y,
            count + 1,
            visited,
        );
        let b = can_reach(
            start_x - 1,
            start_y - 2,
            target_x,
            target_y,
            count + 1,
            visited,
        );
        let c = can_reach(
            start_x + 1,
            start_y - 2,
            target_x,
            target_y,
            count + 1,
            visited,
        );
        let d = can_reach(
            start_x + 2,
            start_y - 1,
            target_x,
            target_y,
            count + 1,
            visited,
        );
        let e = can_reach(
            start_x + 2,
            start_y + 1,
            target_x,
            target_y,
            count + 1,
            visited,
        );
        let f = can_reach(
            start_x + 1,
            start_y + 2,
            target_x,
            target_y,
            count + 1,
            visited,
        );
        let g = can_reach(
            start_x - 1,
            start_y + 2,
            target_x,
            target_y,
            count + 1,
            visited,
        );
        let h = can_reach(
            start_x - 2,
            start_y + 1,
            target_x,
            target_y,
            count + 1,
            visited,
        );
        a || b || c || d || e || f || g || h
    }

    can_reach(
        start[0],
        start[1],
        target[0],
        target[1],
        0,
        &mut vec![vec![false; 8]; 8],
    )
}

fn main() {
    println!("{}", can_reach(vec![1, 1], vec![2, 2])); // true
    println!("{}", can_reach(vec![4, 5], vec![6, 6])); // false
}
