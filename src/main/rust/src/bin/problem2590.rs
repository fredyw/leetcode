// https://leetcode.com/problems/design-a-todo-list/description/
struct TodoList {}

impl TodoList {
    fn new() -> Self {
        Self {}
    }

    fn add_task(
        &self,
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

    fn complete_task(&self, user_id: i32, task_id: i32) {
        todo!()
    }
}

fn main() {}
