package calculator.utilies.converters;

import calculator.models.TransactionFx;
import calculator.user.Transaction;

public class TransactionConverter {

    public static TransactionFx convertToTransactionFx(Transaction transaction)
    {
        TransactionFx transactionFx = new TransactionFx();
        transactionFx.setAddedDate(ConvertToDate.convertToLocalDate(transaction.getAddedDate()));
        transactionFx.setTypeCurrency(transaction.getTypeCurrency());
        transactionFx.setBuyCurrency(transaction.getBuyCurrency());
        transactionFx.setSellCurrency(transaction.getSellCurrency());
        transactionFx.setRateValue(transaction.getRateValue());

        return transactionFx;
    }
}
