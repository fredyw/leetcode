// https://leetcode.com/problems/minimum-hours-of-training-to-win-a-competition/
pub fn min_number_of_hours(
    initial_energy: i32,
    initial_experience: i32,
    energy: Vec<i32>,
    experience: Vec<i32>,
) -> i32 {
    let total_energy: i32 = energy.into_iter().sum();
    let energy_required = total_energy - initial_energy + 1;
    let mut experience_required = 0;
    let mut total_experience = initial_experience;
    for exp in experience.into_iter() {
        if exp >= total_experience {
            let training = exp - total_experience + 1;
            experience_required += training;
            total_experience += training;
        } else {
            total_experience += exp;
        }
    }
    energy_required + experience_required
}

fn main() {
    // println!(
    //     "{}",
    //     min_number_of_hours(5, 3, vec![1, 4, 3, 2], vec![2, 6, 3, 1])
    // ); // 8
    // println!("{}", min_number_of_hours(2, 4, vec![1], vec![3])); // 0
    // println!(
    //     "{}",
    //     min_number_of_hours(1, 1, vec![1, 1, 1, 1], vec![1, 1, 1, 50])
    // ); // 51
    println!("{}", min_number_of_hours(1, 1, vec![1, 1], vec![1, 50])); // 51
                                                                        // println!("{}", min_number_of_hours(5, 3, vec![1, 4], vec![2, 5])); // 2
}
