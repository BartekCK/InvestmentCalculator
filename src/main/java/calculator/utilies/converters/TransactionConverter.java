package calculator.utilies.converters;

import calculator.date.TransactionFx;
import calculator.date.Transaction;

public class TransactionConverter {

    public TransactionFx convertToTransactionFx(Transaction transaction)
    {
        TransactionFx transactionFx = new TransactionFx();
        transactionFx.setAddedDate(DateConverter.convertToLocalDate(transaction.getAddedDate()));

        transactionFx.setBuyTypeCurrency(transaction.getBuyTypeCurrency());
        transactionFx.setBuyCountCurrency(transaction.getBuyCountCurrency());
        transactionFx.setBuyRateCurrency(transaction.getBuyRateCurrency());

        transactionFx.setSellTypeCurrency(transaction.getSellTypeCurrency());
        transactionFx.setSellCountCurrency(transaction.getSellCountCurrency());
        transactionFx.setSellRateCurrency(transaction.getSellRateCurrency());

        return transactionFx;
    }
}
