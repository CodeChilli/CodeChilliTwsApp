package domain;

import com.ib.client.Contract;
import com.ib.client.EClientSocket;
import com.ib.client.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderManager {

    private Connection connection;
    private EClientSocket eClientSocket;
    public enum OrderActionEnum {
        BRACKET_ORDER,
        LIMIT_ORDER,
        MARKET_ORDER
    }

    public OrderManager(Connection connection, EClientSocket eClientSocket) {
        this.connection = connection;
        eClientSocket = eClientSocket;
    }

    /*public void placeBracketOrder(Contract contract, double quantity,double tpLimitPrice, double spLossPrice) {
        List<Order> bracket = BracketOrder(connection.getNextOrderId(), "BUY", quantity tpLimitPrice, spLossPrice);
        for (Order o : bracket) {
            placeOrder(o.orderId(), contract, o);
        }
    }*/

    public void placeOrder(Integer orderId, Order_Contract order_contract) {
        final int i = orderId == null ? connection.getNextOrderId() : orderId;
        final Order order = order_contract.getOrder();
        order.parentId(i);
        eClientSocket.placeOrder(i, order_contract.getMyContract(), order);
    }

    public List<Order> BracketOrder(int parentOrderId, String action, double quantity, double takeProfitLimitPrice, double stopLossPrice) {
        //This will be our main or "parent" order
        Order parent = new Order();
        parent.orderId(parentOrderId);
        parent.action(action);
        parent.orderType("MKT");
        parent.totalQuantity(quantity);
        //The parent and children orders will need this attribute set to false to prevent accidental executions.
        //The LAST CHILD will have it set to true.
        parent.transmit(false);

        Order takeProfit = new Order();
        takeProfit.orderId(parent.orderId() + 1);
        takeProfit.action(action.equals("BUY") ? "SELL" : "BUY");
        takeProfit.orderType("LMT");
        takeProfit.totalQuantity(quantity);
        takeProfit.lmtPrice(takeProfitLimitPrice);
        takeProfit.parentId(parentOrderId);
        takeProfit.transmit(false);

        Order stopLoss = new Order();
        stopLoss.orderId(parent.orderId() + 2);
        stopLoss.action(action.equals("BUY") ? "SELL" : "BUY");
        stopLoss.orderType("STP");
        //Stop trigger price
        stopLoss.auxPrice(stopLossPrice);
        stopLoss.totalQuantity(quantity);
        stopLoss.parentId(parentOrderId);
        //In this case, the low side order will be the last child being sent. Therefore, it needs to set this attribute to true
        //to activate all its predecessors
        stopLoss.transmit(true);

        List<Order> bracketOrder = new ArrayList<>();
        bracketOrder.add(parent);
        bracketOrder.add(takeProfit);
        bracketOrder.add(stopLoss);

        return bracketOrder;
    }
}
