package Model.Domain;

import javax.persistence.*;

@Entity
@Table(
        name = "UserStickyNotesEntity",
        schema = "dbo",
        catalog = "hibernate",
        indexes = {
                @Index(name = "IX_STICKY_ID", columnList = "sticky_Id", unique = true),
                @Index(name = "IX_STICKY_USER_ID", columnList = "sticky_Id", unique = true)
        }
)
public class UserStickyNotesEntity {
    @Id
    @Column(name="sticky_Id", unique = true, nullable = false)
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int Id;

    @Lob
    @Column(name = "sticky_note")
    //@Lob - String olarak Büyük alan oluşturduk. byte[] ve char[]'da oluşturabiliriz.
    private String note;

    @OneToOne(
            fetch = FetchType.LAZY,            //
            cascade = CascadeType.ALL,        //
            orphanRemoval = true,            //Join yapılan alan değiştirilip kaydedilirse. Kaldırılan alan Tablodan silinir
            optional = true                 //Aradaki İlişki Zorunlu mudur?
    )
    @JoinColumn(name = "sticky_usr_Id", insertable = true)
    private UserEntity userEntity;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
