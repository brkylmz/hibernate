package Model.Domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Purchase_Request")
@Table(name = "Purchase_Request", schema = "dbo", catalog = "hibernate")
public class PurchaseRequestEntity {
    @Id
    @Column(name="pr_Id", unique = true, nullable = false)
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int prId;

    @Column(name = "pr_stock_code", length = 11)
    private String prStockCode;

    @Column(name = "pr_quantity", precision = 8, scale = 3)
    //precision - Toplam digit sayısı
    //scale - Virgulden sonra 3 hane olur.
    private double prQuantity;

    @ManyToOne(
            targetEntity = UserEntity.class,   //
            cascade = CascadeType.ALL,        //
            fetch = FetchType.LAZY,          //
            optional = true                //Aradaki İlişki Zorunlu mudur?
    )
    @JoinColumn(name = "pr_usr_Id", insertable = true)
    private UserEntity users;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            joinColumns = { @JoinColumn(name = "pr_stock_code") },
            inverseJoinColumns = { @JoinColumn(name = "stc_code") }
    )
    Set<StockEntity> stocks = new HashSet<StockEntity>();

    public int getPrId() {
        return prId;
    }

    public void setPrId(int prId) {
        this.prId = prId;
    }

    public String getPrStockCode() {
        return prStockCode;
    }

    public void setPrStockCode(String prStockCode) {
        this.prStockCode = prStockCode;
    }

    public double getPrQuantity() {
        return prQuantity;
    }

    public void setPrQuantity(double prQuantity) {
        this.prQuantity = prQuantity;
    }

    public UserEntity getUsers() {
        return users;
    }

    public void setUsers(UserEntity users) {
        this.users = users;
    }

    public Set<StockEntity> getStocks() {
        return stocks;
    }

    public void setStocks(Set<StockEntity> stocks) {
        this.stocks = stocks;
    }
}