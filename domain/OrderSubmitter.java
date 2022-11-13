package domain;

import com.ib.client.EClientSocket;

public class OrderSubmitter {
    private final OrderManager orderManager;

    OrderSubmitter(Connection connection, EClientSocket eClientSocket){
        this.orderManager = new OrderManager(connection, eClientSocket);
    }

    public void submit(Order_Contract order_contract){
        this.orderManager.placeOrder(null, order_contract);
    }
}
