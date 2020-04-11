package com.hy.tt.mode.chain;

import com.hy.tt.mode.chain.entity.Receipt;

/**
 * @author thy
 * @date 2020/4/11
 */
public class Test {
    public static void main(String[] args) {
        Receipt receipt = new Receipt();
        receipt.setMessage("责任链设计模式");
        receipt.setType("SUCCESS");

        ReceiptHandleChain chain = new ReceiptHandleChain();
        chain.handleReceipt(receipt);
    }
}
