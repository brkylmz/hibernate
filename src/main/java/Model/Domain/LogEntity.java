package Model.Domain;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Log")
@Table(name = "Log", schema = "dbo", catalog = "hibernate")
public class LogEntity {
    @Id
    @Column(name="log_Id", unique = true, nullable = false)
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private int log_Id;

    @Column(name = "log_ip_address", length = 16)
    private String ipAdres;

    @Column(name = "log_date_time")
    @Temporal(value = TemporalType.TIMESTAMP)
    //TemporalType.TIMESTAMP değeri -> Tarih ve Saattir. Örnek:2019-08-22 22:15:27
    private Date loginDatetime;

    public int getLog_Id() {
        return log_Id;
    }

    public void setLog_Id(int log_Id) {
        this.log_Id = log_Id;
    }

    public String getIpAdres() {
        return ipAdres;
    }

    public void setIpAdres(String ipAdres) {
        this.ipAdres = ipAdres;
    }

    public Date getLoginDatetime() {
        return loginDatetime;
    }

    public void setLoginDatetime(Date loginDatetime) {
        this.loginDatetime = loginDatetime;
    }
}
