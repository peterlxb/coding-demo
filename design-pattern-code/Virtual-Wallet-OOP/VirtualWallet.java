
/**
 * 基于充血模型的 DDD(领域模型)
 * */
public class VirtualWallet {
    private Long id;
    private Long createTime = System.currentTimeMillis();
    private BigDecimal balance = BigDecimal.ZERO;
    private boolean isAllowedOverdraft = true;
    private BigDecimal overdraftAmount = BigDecimal.ZERO;
    private BigDecimal frozenAmount = BigDecimal.ZERO;

    public VirtualWallet(Long preAllocatedId) {
        this.id = preAllocatedId;
    }

    public void freeze(BigDecimal amount) { ... };
    public void unfreeze(BigDecimal amount) { ... };
    public void increaseOverdraftAmount(BigDecimal amount) { ... };
    public void decreaseOverdraftAmount(Bigecimal amount) { ... };
    public void closeOverdraft() { ... };
    public void openOverdraft() { ... };

    public BigDecial balance() {
        return balance;
    }

    public BigDecimal getAvailableBalance() {
        BigDecimal totalAvailableBalance = this.balance.subtract(this.frozenAmount);

        if (isAllowedOverdraft) {
            totalAvailableBalance += this.overdraftAmount;
        }
        return totalAvailableBalance;
    }

    public void debit(BigDecimal amount) {
        BigDecimal totalAvailableBalance = getAvailableBalance();

        if (totalAvailableBalance.compareTo(amount) < 0) {
            throw new InsufficientBalanceException(...);
        }
        this.balance.subtract(amount);
    }

    public void credit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidAmountException(...);
        }
        this.balance.add(amount);
    }

    // 转账过程
    public void transfer(Long fromWalletId, Long toWalletId, BigDeciaml amount) {
        VirtualWalletTransactionEntity transactionEntity = new VirtualWalletTransactionEntity();

        transactionEntity.setAmount(amount);
        transactionEntity.setCreateTime(System.curentTimeMillis());
        transactionEntity.setFromWalletId(fromWalletId);
        transactionEntity.setToWalletId(toWalletId);
        transactionEntity.setStatus(STATUS.TO_BE_EXECUTED);

        Long transactionId = transactionRepository.saveTransaction(transactionEntity);

        try {
            debit(fromWalletId, amount);
            credit(toWalletId, amount);
        } catch (InSufficientBalanceException e) {
            transactionRepository.updateStatus(transactionId, STATUS.CLOSED);
            ... rethrow exception e ...;
        }
        transactionRepository.updateStatus(transactionId, STATUS.EXECUTED);
    }
 }