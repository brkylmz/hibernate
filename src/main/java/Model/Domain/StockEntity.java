package Model.Domain;

import enums.EnumUnit;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Stock")
@Table(name = "Stock", schema = "dbo", catalog = "hibernate")
public class StockEntity {
    @Id
    @Column(name = "stc_Id", unique = true, nullable = false)
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int stcId;

    @Column(name = "stc_Create_date_time")
    @Temporal(value = TemporalType.TIMESTAMP)
    //TemporalType.TIMESTAMP değeri -> Tarih ve Saattir. Örnek:2019-08-22 22:15:27
    private Date CreateDatetime;

    @Column(name = "stc_code", length = 11)
    private String stcCode;

    @Column(name = "stc_name", length = 150)
    private String stcName;

    @ManyToMany(mappedBy = "stocks")
    private Set<PurchaseRequestEntity> PurchaseRequests = new HashSet<PurchaseRequestEntity>();

    @Enumerated(EnumType.STRING)
    @Column(name="stc_unit", length = 50)
    private EnumUnit unit;

    public int getStcId() {
        return stcId;
    }

    public void setStcId(int stcId) {
        this.stcId = stcId;
    }

    public Date getCreateDatetime() {
        return CreateDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        CreateDatetime = createDatetime;
    }

    public String getStcCode() {
        return stcCode;
    }

    public void setStcCode(String stcCode) {
        this.stcCode = stcCode;
    }

    public String getStcName() {
        return stcName;
    }

    public void setStcName(String stcName) {
        this.stcName = stcName;
    }

    public Set<PurchaseRequestEntity> getPurchaseRequests() {
        return PurchaseRequests;
    }

    public void setPurchaseRequests(Set<PurchaseRequestEntity> purchaseRequests) {
        PurchaseRequests = purchaseRequests;
    }

    public EnumUnit getUnit() {
        return unit;
    }

    public void setUnit(EnumUnit unit) {
        this.unit = unit;
    }
}