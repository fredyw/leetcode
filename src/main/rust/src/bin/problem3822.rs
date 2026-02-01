struct OrderManagementSystem {}

impl OrderManagementSystem {
    fn new() -> Self {
        todo!()
    }

    fn add_order(&self, order_id: i32, order_type: String, price: i32) {
        todo!()
    }

    fn modify_order(&self, order_id: i32, new_price: i32) {
        todo!()
    }

    fn cancel_order(&self, order_id: i32) {
        todo!()
    }

    fn get_orders_at_price(&self, order_type: String, price: i32) -> Vec<i32> {
        todo!()
    }
}

fn main() {
    let oms = OrderManagementSystem::new();
    oms.add_order(1, "buy".to_string(), 1);
    oms.add_order(2, "buy".to_string(), 1);
    oms.add_order(3, "sell".to_string(), 2);
    println!("{:?}", oms.get_orders_at_price("buy".to_string(), 1)); // [2, 1]
    oms.modify_order(1, 3);
    oms.modify_order(2, 1);
    println!("{:?}", oms.get_orders_at_price("buy".to_string(), 1)); // [2]
    oms.cancel_order(3);
    oms.cancel_order(2);
    println!("{:?}", oms.get_orders_at_price("buy".to_string(), 1)); // []
}
