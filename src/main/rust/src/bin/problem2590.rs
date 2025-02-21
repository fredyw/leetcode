use std::os::unix::raw::time_t;

// https://leetcode.com/problems/design-a-todo-list/description/
struct TodoList {}

impl TodoList {
    fn new() -> Self {
        Self {}
    }

    fn add_task(
        &mut self,
        user_id: i32,
        task_description: String,
        due_date: i32,
        tags: Vec<String>,
    ) -> i32 {
        todo!()
    }

    fn get_all_tasks(&self, user_id: i32) -> Vec<String> {
        todo!()
    }

    fn get_tasks_for_tag(&self, user_id: i32, tag: String) -> Vec<String> {
        todo!()
    }

    fn complete_task(&mut self, user_id: i32, task_id: i32) {
        todo!()
    }
}

fn main() {
    let mut todo_list = TodoList::new();
    println!("{}", todo_list.add_task(1, "Task1".to_string(), 50, vec![])); // 1
    println!(
        "{}",
        todo_list.add_task(1, "Task2".to_string(), 100, vec!["P1".to_string()])
    ); // 2
    println!("{:?}", todo_list.get_all_tasks(1)); // ["Task1","Task2"]
    println!("{:?}", todo_list.get_all_tasks(5)); // []
    println!(
        "{}",
        todo_list.add_task(1, "Task3".to_string(), 30, vec!["P1".to_string()])
    ); // 3
    println!("{:?}", todo_list.get_tasks_for_tag(1, "P1".to_string())); // ["Task3","Task2"]
    todo_list.complete_task(5, 1);
    todo_list.complete_task(1, 2);
    println!("{:?}", todo_list.get_tasks_for_tag(1, "P1".to_string())); // ["Task3"]
    println!("{:?}", todo_list.get_all_tasks(1)); //["Task3","Task1"]
}
