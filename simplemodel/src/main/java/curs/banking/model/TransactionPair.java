package curs.banking.model;

public class TransactionPair {
	private final Transaction mDebitTransaction;
	private final Transaction mCreditTrasaction;
	
	public TransactionPair(Transaction pDebit,Transaction pCredit) {
		mDebitTransaction = pDebit;
		mCreditTrasaction = pCredit;
	}

	public Transaction getDebitTransaction() {
		return mDebitTransaction;
	}

	public Transaction getCreditTrasaction() {
		return mCreditTrasaction;
	}
	
	
}
