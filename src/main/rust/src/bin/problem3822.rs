use std::collections::{HashMap, HashSet};

struct OrderManagementSystem {
    orders: HashMap<i32, (String, i32)>, // order ID -> (order type, price)
    sell: HashMap<i32, HashSet<i32>>,    // price -> order IDs
    buy: HashMap<i32, HashSet<i32>>,     // price -> order IDs
}

impl OrderManagementSystem {
    fn new() -> Self {
        OrderManagementSystem {
            orders: HashMap::new(),
            sell: HashMap::new(),
            buy: HashMap::new(),
        }
    }

    fn add_order(&mut self, order_id: i32, order_type: String, price: i32) {
        self.orders.insert(order_id, (order_type.clone(), price));
        if order_type == "sell" {
            self.sell
                .entry(price)
                .or_insert(HashSet::new())
                .insert(order_id);
        } else {
            self.buy
                .entry(price)
                .or_insert(HashSet::new())
                .insert(order_id);
        }
    }

    fn modify_order(&mut self, order_id: i32, new_price: i32) {
        let (order_type, price) = self.orders.get(&order_id).unwrap();
        if order_type == "sell" {
            self.sell
                .get_mut(price)
                .unwrap_or(&mut HashSet::new())
                .remove(&order_id);
            self.add_order(order_id, order_type.clone(), new_price);
        } else {
            self.buy
                .get_mut(price)
                .unwrap_or(&mut HashSet::new())
                .remove(&order_id);
            self.add_order(order_id, order_type.clone(), new_price);
        }
    }

    fn cancel_order(&mut self, order_id: i32) {
        let (order_type, price) = self.orders.get(&order_id).unwrap();
        if order_type == "sell" {
            self.sell
                .get_mut(price)
                .unwrap_or(&mut HashSet::new())
                .remove(&order_id);
        } else {
            self.buy
                .get_mut(price)
                .unwrap_or(&mut HashSet::new())
                .remove(&order_id);
        }
        self.orders.remove(&order_id);
    }

    fn get_orders_at_price(&self, order_type: String, price: i32) -> Vec<i32> {
        if order_type == "sell" {
            self.sell
                .get(&price)
                .unwrap_or(&HashSet::new())
                .iter()
                .cloned()
                .collect()
        } else {
            self.buy
                .get(&price)
                .unwrap_or(&HashSet::new())
                .iter()
                .cloned()
                .collect()
        }
    }
}

fn main() {
    let mut oms = OrderManagementSystem::new();
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
