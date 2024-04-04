package model.vo;

import static constant.LottoConstants.LOTTO_PRICE;

public class PurchaseAmount {
    private final int amount;

    public PurchaseAmount(int payment) {
        this.amount = payment / LOTTO_PRICE;
    }

    public int getAmount() {
        return amount;
    }
}
