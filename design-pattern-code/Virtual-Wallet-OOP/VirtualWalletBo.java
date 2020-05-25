public class VirtualWalletBo { // 省略 getter/setter/constructor方法
    private Long id;
    private Long createTime;
    private BigDecimal balance;
}

public class VirtualWalletService {
    // 通过构造函数或者 IOC 框架注入
    private VirtualWalletRepository wallerRepo;
    private VirtualWalletTransactionRepository transactionRepository;

    public VirtualWalletBo getVirtualWallet (Long walletId) {
        VirtualWalletEntity walletEntity = wallerRepo.getWalletEntity(walletId);
        VirtualWalletBo walletBo = convert(walletEntity);
        return walletBo;
    }

    public BigDecimal getBalance(Long walletId) {
        return wallerRepo.getBalance(walletId);
    }

    // 转账
    public void debit(Long walletId, BigDecimal amount) {
        VirtualWalletEntity walletEntity = wallerRepo.getWalletEntity(walletId);
        BigDecimal balance = walletEntity.getBalance();

        if (balance.compareTo(amount) < 0) {
            throw new NoSufficientBalanceException(...);
        }

        wallerRepo.updateBalance(walletId, balance.subtract(amount));
    }

    // 入账
    public void credit(Long walletId, BigDeciaml amount) {
        VirtualWalletEntity walletEntity = wallerRepo.getWalletEntity(walletId);
        BigDecimal balance = walletEntity.getBalance();

        wallerRepo.updateBalance(walletId, balance.add(amount));
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