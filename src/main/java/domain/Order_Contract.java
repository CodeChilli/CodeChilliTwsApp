package domain;


import com.ib.client.Order;

public class Order_Contract {
    public enum ORDER_TYPE {SINGLE_MKT, BRACKET_MKT};

    public enum BUY_SELL_ENUM {BUY, SELL};

    public enum QUANTITY_ENUM {
        MINI(50), MICRO(100), MEDIUM(150), LARGE(200), Mega(250), EXTRA(300);
        private final int quantity;

        QUANTITY_ENUM(int quantity) {
            this.quantity = quantity;
        }

        public int getI() {
            return quantity;
        }
    }

    private final String du5927993 = "DU5927993";
    private final String day = "DAY";

    private QUANTITY_ENUM quantity_enum;
    private MyContract myContract;
    private ORDER_TYPE order_type;

    private Order order;

    public Order_Contract(QUANTITY_ENUM quantity_enum, MyContract myContract, BUY_SELL_ENUM bsEnum, ORDER_TYPE order_type) {

        switch (order_type) {
            //TODO validation
            case SINGLE_MKT -> {
                this.quantity_enum = quantity_enum;
                this.order_type = order_type;
                Order order = createNewOrderFromTemplate();
                order.totalQuantity(quantity_enum.getI());
                order.action(bsEnum.toString());
                order.orderType("MKT");
                order.transmit(true);
                this.order= order;
                //final MyContract aapl = ContractSamples.contracts.get("AAPL");
                this.myContract = myContract;
                break;
            }
        }
    }

    private Order createNewOrderFromTemplate() {
        Order order = new Order();
        order.tif(day);
        order.usePriceMgmtAlgo(false);
        order.account(du5927993);
        return order;
    }

    public MyContract getMyContract() {
        return myContract;
    }

    public void setMyContract(MyContract myContract) {
        this.myContract = myContract;
    }

    public ORDER_TYPE getOrder_type() {
        return order_type;
    }

    public void setOrder_type(ORDER_TYPE order_type) {
        this.order_type = order_type;
    }

    public Order getOrder() {
        return order;
    }
}

