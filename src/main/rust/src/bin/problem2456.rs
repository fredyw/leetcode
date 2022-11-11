use std::collections::HashMap;

// https://leetcode.com/problems/most-popular-video-creator/
pub fn most_popular_creator(
    creators: Vec<String>,
    ids: Vec<String>,
    views: Vec<i32>,
) -> Vec<Vec<String>> {
    #[derive(Debug)]
    struct ViewInfo {
        id_to_view_map: HashMap<String, i32>,
        total_view: i64,
    }
    let mut map: HashMap<String, ViewInfo> = HashMap::new();
    for i in 0..creators.len() {
        let v = map.entry(creators[i].clone()).or_insert(ViewInfo {
            id_to_view_map: HashMap::new(),
            total_view: 0,
        });
        (*v).total_view += views[i] as i64;
        *(*v).id_to_view_map.entry(ids[i].clone()).or_insert(0) += views[i];
    }
    let mut max_creators = vec![];
    let mut max_view_count = 0;
    for (creator, view_info) in map.iter() {
        if view_info.total_view > max_view_count {
            max_creators.clear();
            max_creators.push((creator, &view_info.id_to_view_map));
            max_view_count = view_info.total_view;
        } else if view_info.total_view == max_view_count {
            max_creators.push((creator, &view_info.id_to_view_map));
        }
    }
    let mut answer = vec![];
    for (creator, id_to_view_map) in max_creators.into_iter() {
        let mut max_view = 0;
        let mut max_id = "";
        for (id, view) in id_to_view_map.into_iter() {
            if max_id == "" {
                max_id = id;
                max_view = *view;
                continue;
            }
            if *view > max_view {
                max_id = id;
                max_view = *view;
            } else if *view == max_view {
                if max_id.cmp(id) == std::cmp::Ordering::Greater {
                    max_id = id;
                }
            }
        }
        answer.push(vec![creator.to_string(), max_id.to_string()]);
    }
    answer
}

fn main() {
    println!(
        "{:?}",
        most_popular_creator(
            vec![
                "alice".to_string(),
                "bob".to_string(),
                "alice".to_string(),
                "chris".to_string()
            ],
            vec![
                "one".to_string(),
                "two".to_string(),
                "three".to_string(),
                "four".to_string()
            ],
            vec![5, 10, 5, 4]
        )
    ); // [["alice","one"],["bob","two"]]
    println!(
        "{:?}",
        most_popular_creator(
            vec![
                "alice".to_string(),
                "alice".to_string(),
                "alice".to_string()
            ],
            vec!["a".to_string(), "b".to_string(), "c".to_string(),],
            vec![1, 2, 2]
        )
    ); // [["alice","b"]]
    println!(
        "{:?}",
        most_popular_creator(vec!["a".to_string()], vec!["a".to_string()], vec![0])
    ); // [["a","a"]]
}
