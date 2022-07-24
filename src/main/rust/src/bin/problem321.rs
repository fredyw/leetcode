use std::collections::LinkedList;

// https://leetcode.com/problems/create-maximum-number/
pub fn max_number(nums1: Vec<i32>, nums2: Vec<i32>, k: i32) -> Vec<i32> {
    fn length(nums1: &Vec<i32>, nums2: &Vec<i32>, i: usize, j: usize) -> usize {
        nums1.len() - i + nums2.len() - j - 1
    }

    let mut linked_list: LinkedList<i32> = LinkedList::new();
    let mut i = 0;
    let mut j = 0;
    while i < nums1.len() || j < nums2.len() {
        while !linked_list.is_empty()
            && k as usize - linked_list.len() <= length(&nums1, &nums2, i, j)
        {
            let back = linked_list.back().unwrap();
            if i < nums1.len() && *back < nums1[i] {
                linked_list.pop_back();
            }
            match linked_list.back() {
                Some(front) => {
                    if k as usize - linked_list.len() <= length(&nums1, &nums2, i, j)
                        && j < nums2.len()
                        && *front < nums2[j]
                    {
                        linked_list.pop_back();
                    } else {
                        break;
                    }
                }
                None => break,
            }
        }
        if i < nums1.len() && j < nums2.len() && nums1[i] >= nums2[j] {
            if linked_list.len() < k as usize {
                linked_list.push_back(nums1[i]);
            }
            i += 1;
        } else if i < nums1.len() && j < nums2.len() && nums1[i] < nums2[j] {
            if linked_list.len() < k as usize {
                linked_list.push_back(nums2[j]);
            }
            j += 1;
        } else if i < nums1.len() {
            if linked_list.len() < k as usize {
                linked_list.push_back(nums1[i]);
            }
            i += 1;
        } else {
            if linked_list.len() < k as usize {
                linked_list.push_back(nums2[j]);
            }
            j += 1;
        }
        println!("i = {i}, j = {j} --> {:?}", linked_list);
    }
    linked_list.into_iter().collect::<Vec<i32>>()
}

fn main() {
    println!(
        "{:?}",
        max_number(vec![3, 4, 6, 5], vec![9, 1, 2, 5, 8, 3], 5)
    ); // [9,8,6,5,3]
    println!("{:?}", max_number(vec![6, 7], vec![6, 0, 4], 5)); // [6,7,6,0,4]
    println!("{:?}", max_number(vec![3, 9], vec![8, 9], 3)); // [9,8,9]
    println!("{:?}", max_number(vec![9, 8, 7], vec![1, 2], 4)); // [9,8,7,2]
    println!("{:?}", max_number(vec![3, 4, 6, 9], vec![9, 2, 5, 8, 9], 5)); // [9,9,5,8,9]
    println!(
        "{:?}",
        max_number(vec![8, 8, 1, 9, 9], vec![8, 8, 2, 9, 9], 4)
    ); // [9,9,9,9]
    println!(
        "{:?}",
        max_number(
            vec![5, 9, 3, 7, 5, 6, 2, 3],
            vec![3, 8, 1, 2, 8, 6, 0, 8],
            8
        )
    ); // [9,8,8,8,7,6,2,3]
}
