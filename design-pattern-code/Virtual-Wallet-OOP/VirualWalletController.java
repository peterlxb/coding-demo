public class VirtualWalletController {
    // 通过构造函数或者 IOC 框架注入
    private VirtualWallertService virtualWallertService;

    // 查询余额
    public BigDecimal getBalance(Long walletId) { ... }

    // 出账
    public void debit(Long walletId, BigDecimal amount) { ... }

    // 入账
    public void credit(Long walletId, BigDecimal amount) { ... }

    // 转账
    public void transfer(Long fromWaletId, Long toWalletId, BigDecimal amount) {
        ...
    }
}