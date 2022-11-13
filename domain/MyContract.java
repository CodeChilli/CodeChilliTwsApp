package domain;

import com.ib.client.Contract;
import com.ib.client.Types;

public class MyContract extends Contract {
    public MyContract(String symbol) {
        symbol(symbol);
        secType(Types.SecType.STK);
        exchange("SMART");
        currency("USD");
        primaryExch("ISLAND");
    }
}
