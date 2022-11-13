package domain;

import java.util.HashMap;
import java.util.Map;

public class ContractSamples {
    public static Map<String, MyContract> contracts = new HashMap<String, MyContract>();

    static{
        String s="MSFT";
        contracts.put(s,new MyContract(s));

        s ="AAPL";
        contracts.put(s,new MyContract(s));

        s="NVDA";
        contracts.put(s,new MyContract(s));

        s="QQQ";
        contracts.put(s,new MyContract(s));

        s="BABA";
        contracts.put(s,new MyContract(s));

        s="JPM";
        contracts.put(s,new MyContract(s));

        s="PYPL";
        contracts.put(s,new MyContract(s));

        s="SQ";
        contracts.put(s,new MyContract(s));
    }

}
