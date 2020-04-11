package com.hy.tt.mode.chain;

import com.hy.tt.mode.chain.entity.Receipt;
import com.hy.tt.mode.chain.service.IReceiptHandler;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author thy
 * @date 2020/4/11
 */
public class ReceiptHandleChain implements IReceiptHandleChain {

    private static Integer index = 0;

    private static List<IReceiptHandler> receiptHandlerList;

    static{
        receiptHandlerList = ReceiptHandlerContainer.getReceiptHandlerList();
    }

    @Override
    public void handleReceipt(Receipt receipt) {
        if(CollectionUtils.isEmpty(receiptHandlerList)){
            return;
        }
        if(index != receiptHandlerList.size()){
            IReceiptHandler iReceiptHandler = receiptHandlerList.get(index++);
            iReceiptHandler.handlReceipt(receipt,this);
        }
    }
}
