use std::collections::HashMap;

// https://leetcode.com/problems/minimum-fuel-cost-to-report-to-the-capital/
pub fn minimum_fuel_cost(roads: Vec<Vec<i32>>, seats: i32) -> i64 {
    fn dfs(
        map: &HashMap<i32, Vec<i32>>,
        seats: i64,
        visited: &mut Vec<bool>,
        city: i32,
        fuel: i32,
        answer: &mut i64,
    ) -> i64 {
        visited[city as usize] = true;
        let mut total_seats = 0;
        for adj in map.get(&city).unwrap().iter() {
            if visited[*adj as usize] {
                continue;
            }
            total_seats += dfs(map, seats, visited, *adj, fuel + 1, answer);
        }
        if total_seats - 1 < 0 {
            *answer += fuel as i64;
            seats - 1
        } else {
            total_seats - 1
        }
    }

    if roads.len() == 0 {
        return 0;
    }
    let mut map: HashMap<i32, Vec<i32>> = HashMap::new();
    for road in roads.into_iter() {
        map.entry(road[0]).or_insert(vec![]).push(road[1]);
        map.entry(road[1]).or_insert(vec![]).push(road[0]);
    }
    let mut answer = 0;
    dfs(
        &map,
        seats as i64,
        &mut vec![false; map.len()],
        0,
        0,
        &mut answer,
    );
    answer
}

fn main() {
    // println!(
    //     "{}",
    //     minimum_fuel_cost(vec![vec![0, 1], vec![0, 2], vec![0, 3]], 5)
    // ); // 3
    // println!(
    //     "{}",
    //     minimum_fuel_cost(
    //         vec![
    //             vec![3, 1],
    //             vec![3, 2],
    //             vec![1, 0],
    //             vec![0, 4],
    //             vec![0, 5],
    //             vec![4, 6]
    //         ],
    //         2
    //     )
    // ); // 7
    // println!("{}", minimum_fuel_cost(vec![], 1)); // 0
    // println!(
    //     "{}",
    //     minimum_fuel_cost(vec![vec![0, 1], vec![1, 2], vec![2, 3], vec![3, 4]], 2)
    // ); // 6
    // println!(
    //     "{}",
    //     minimum_fuel_cost(vec![vec![0, 1], vec![1, 2], vec![2, 3], vec![3, 4]], 1)
    // ); // 10
    println!(
        "{}",
        minimum_fuel_cost(vec![vec![0, 1], vec![0, 2], vec![1, 3], vec![1, 4]], 5)
    ); // 4
}
