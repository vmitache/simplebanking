package curs.banking.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "BANK", name = "ACCOUNT")
public class Transaction {
  @Id
  @GeneratedValue
  @Column(name = "ID")
  private long mId;
  @ManyToOne
  @JoinColumn(name = "ACCOUNT_ID")
  private Account mAccount;
  @Column(name="TTYPE")
  @Enumerated(value=EnumType.STRING)
  private TransactionType mTransactionType;
  @Column(name="AMOUNT")
  private double mAmount;
  @Column(name="TTIME")
  private Timestamp mTransactionTime;

  public long getId() {
    return mId;
  }

  public void setId(long pId) {
    mId = pId;
  }

  public Account getAccount() {
    return mAccount;
  }

  public void setAccount(Account pAccount) {
    mAccount = pAccount;
  }

  public TransactionType getTransactionType() {
    return mTransactionType;
  }

  public void setTransactionType(TransactionType pTransactionType) {
    mTransactionType = pTransactionType;
  }

  public double getAmount() {
    return mAmount;
  }

  public void setAmount(double pAmount) {
    mAmount = pAmount;
  }

  public Timestamp getTransactionTime() {
    return mTransactionTime;
  }

  public void setTransactionTime(Timestamp pTransactionTime) {
    mTransactionTime = pTransactionTime;
  }

  @Override
  public String toString() {
    return "Transaction [mId=" + mId + ", mAccount=" + mAccount + ", mTransactionType=" + mTransactionType
        + ", mAmount=" + mAmount + ", mTransactionTime=" + mTransactionTime + "]";
  }

}
