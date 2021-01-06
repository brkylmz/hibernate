package Model.Domain;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "users")
@Table(name = "users", schema = "dbo", catalog = "hibernate")
public class UserEntity {
    @Id
    @Column(name="usr_Id", unique = true, nullable = false)
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int Id;

    @Basic
    @Column(name = "usr_no", scale = 15, precision = 2)
    //precision - Toplam digit sayısı
    //scale - Virgulden sonra 2 hane olur.
    private int userNo;

    @Basic
    @Column(name = "usr_name", length = 50, nullable = false)
    //length - Kaç Karakter Olacağını Belirliyoruz.
    //nullable - true ise boş geçilir. false ise boş geçilemez
    //insertable - false ise insert işlemine dahil olmaz
    //updatable -  false ise update işlemine dahil olmaz
    private String userName;

    @Column(name = "usr_create_date")
    @Temporal(value = TemporalType.DATE)
    //TemporalType.DATE değeri -> Tarihtir. Örnek:2019-08-22
    private Date createDate;

    @Column(name = "usr_Create_hour")
    @Temporal(value = TemporalType.TIME)
    //TemporalType.TIME değeri -> Saattir. Örnek:22:15:27.3066667
    private Date CreateHour;

    @Column(name = "usr_Create_date_time")
    @Temporal(value = TemporalType.TIMESTAMP)
    //TemporalType.TIMESTAMP değeri -> Tarih ve Saattir. Örnek:2019-08-22 22:15:27
    private Date CreateDatetime;

    @Transient
    //Veritabanına kaydedilmez. Nesne var olduğu sürece geçici olarak tutulur.
    private String ipAdres;

    @OneToOne(
            mappedBy = "userEntity",                  //Kullanıldığı Entity'deki alan için Tabloda bir alan oluşturulmuyor ancak Entity'de kullanılıyor.
            cascade = CascadeType.ALL,               //
            fetch = FetchType.LAZY,                 //
            orphanRemoval = true,                  //Join yapılan alan değiştirilip kaydedilirse. Kaldırılan alan Tablodan silinir
            optional = true                       //Aradaki İlişki Zorunlu mudur?
    )
    @NotFound( action = NotFoundAction.IGNORE ) //İlişkili Kayıt Yoksa Hata Almamak için Not Found ile gösteririrz
    private UserStickyNotesEntity userStickyNote;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "log_usr_Id", insertable = true)
    @NotFound( action = NotFoundAction.IGNORE )                 //İlişkili Kayıt Yoksa Hata Almamak için Not Found ile gösteririrz
    private List<LogEntity> logs = new ArrayList<LogEntity>();

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getCreateHour() {
        return CreateHour;
    }

    public void setCreateHour(Date createHour) {
        CreateHour = createHour;
    }

    public Date getCreateDatetime() {
        return CreateDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        CreateDatetime = createDatetime;
    }

    public String getIpAdres() {
        return ipAdres;
    }

    public void setIpAdres(String ipAdres) {
        this.ipAdres = ipAdres;
    }

    public UserStickyNotesEntity getUserStickyNote() {
        return userStickyNote;
    }

    public void setUserStickyNote(UserStickyNotesEntity userStickyNote) {
        this.userStickyNote = userStickyNote;
    }

    public List<LogEntity> getLogs() {
        return logs;
    }

    public void setLogs(List<LogEntity> logs) {
        this.logs = logs;
    }

    public void addUserStickyNotes(UserStickyNotesEntity stickyNote) {
        stickyNote.setUserEntity(this);
        this.userStickyNote = stickyNote;
    }

    public void removeUserStickyNotes() {
        if ( userStickyNote != null ) {
            userStickyNote.setUserEntity(null);
            this.userStickyNote = null;
        }
    }
}
