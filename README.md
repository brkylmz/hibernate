# hibernate
![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+) `@Entity:` Veri tabanında bir karşılığı olduğunu belirtir.

![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+) `@Table:` @Entity ile birlikte kullanılır. Database’de bir tabloya karşılık geldiğini belirtilir.  Özellikleri;
-	Name: Tablo adını belirtir. Kullanılmazsa Class’ın adında bir tablomuz oluşur.
-	Catalog: Tablonun catalog (database) belirtilir. (Örnek: JavaFx_GGM)
-	Schema: Tablonun schema belirtilir. (Örnek: dbo)
-	UniqeConstraints: Null değer olabilen primary key constraintlerdir.
-	İndexes: Tablonun indexlerinin belirtir.

![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+) `@Id:` Her entityde muhakkak bulunur. Primary keyin hangisi olduğunu belirtiriz.

![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+) `@Generated Value:` Primary key’in değerini nasıl arttıracağımızı belirler.  Özellikleri; Strategy
-	Auto Hiçbir şey belirtmezsek Auto alır. Arttırma görevini Hibernate yapar.
-	Identity Düşük performanslıdır. Her insert için yeni değer oluşturur.
-	Sequence En performanslıdır. Değer artırımı bir sequence ile yapılır. Belirtilmezse Hibernate varsayılan üzerinden yapar.
-	Table Kullanılmaz. Performansızdır. Sıradaki değeri belirtilen tabloda depolar orada günceller ve lazım olduğunda yeni değer alır. Bu uygulamayı yavaşlatır.

![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+) `@Squence Generator:` Kullanılacak Sequence özelliklerini özelleştirmek için kullanılır. Özellikleri;
-	Name Generator’ın adını belirtir.
-	SquenceName Squence’nin adını belirtir.
-	Allocationsize Arttırmı sayısını belirtir. Default 50’dir.
-	İnitalValue Başlangıç sayısını belirtir. Default 1 ‘dir.
-	Catalog Catalog belirtir. (Örnek: JavaFx_GGM)
-	Schema Schema (dbo) belirtir. (Örnek: dbo)

![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+) `@Table Generator:` Değer arttırmı yöntemi olarak ‘’Table’’ kullanılır. Özellikleri;
-	Name Generator’ın ismini belirtir.
-	Table Tablo adını belirtir.
-	pkColumnName Kolonun adını belirtir. Değer olarak tablo adı tutulur.
-	ValueColumnName Kolon adı belirtilir. Değer olarak en son Id tutulur.
-	allocationSize Arttırım sayısı belirtilir. Default 50’dir.
-	initalValue Başlangıç numarasıdır. Default 0’dır.
-	Catalog Catalogu belirtir.
-	Schema Schema’yı belirtilir.
-	pkColumnValue Tablodaki birincil anahtar değerini depolar.
-	index / uniqueConstraints Bu tabloda olmasını istediğimiz index ve uniqueConstraints’leri belirtir.

![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+) `@Column:` İlgili değişkenin tablodaki karşılığını belirler. Kullanılmaz ise default ile kolon açılır. İnsertable ve updateable false belirtilirse update ve insert o alanda yapılmaz. Özellikleri;
-	Scole Ondalık kısmın basamak sayısı belirtilir.
-	Precision Tam kısmın basamak sayıları belirtilir.
-	Length Uzunluğu belirtir.

![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+) `@Version:` Tablonun versiyonunu tutan kolonun anatosyonudur. Farklı transoctionlarda aynı veri üzerinde aynı anda değişiklik yapılasını önler. (Optimistik locking)

![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+) `@Temporol:` Tarih verinin database yazılacağı formatı belirler. Özellikleri;
-	Date (dd.mm.yyyy)
-	Time (hh:mm:ss)
-	Datetime (dd.mm.yyyy hh:mm:ss)

![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+) `@Transient:` Oluşturduğumuz class içindeki bir değişkendir. Database’de karşılığı yoktur. Nesne yaşam döngüsü içinde vardır.

![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+) `@Lab:` İlgili kolonun büyük olduğunu belirtiriz. String, Blob yada clob (byte, char) olanlarla kullanılabilir.

![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+) `@One To One:`

- [x]	Join yapılan tabloda 1-1 ilişkide kullanılır.

- [x]	mappedBy ile çift yönlü ilişkide kolon oluşturulmadan entity üzerine ekleme yapılır.

-	Coscade Coscade tipi belirlenir. 6 farklı tipi vardır. Yapılan işlemi diğer nesnede de yapılması istenirse ALL seçilir.
-	Fetch Sorgu yapıldığında Join yapılan kolonunda getirilip getirilmemesi belirlenir. Default olarak Eager gelir. Sürekli birlikte kullanılır eagerda.
-	mappedBy Çift yönlü ilişkilerde kullanılır.
-	optional Aradaki ilişki belirlenir. Default true’dur. İstenirse boş geçilebilir. False’de ilişki kurulması şarttır.
-	opphanRemovol True olursa ve join yapılan alan değiştirilip kaydedersek kaldırılan alan database’den silinir.
-	Target Entity İlgili referans sınıfının belirtilmesine yarar. Genelde gerekmez. Özel durumlarda gerekir.

- ![#c5f015](https://via.placeholder.com/15/c5f015/000000?text=+) `Örnek Kullanım`
```java
@Entity(name = "users")
@Table(name = "users", schema = "dbo", catalog = "hibernate")
public class UserEntity {
    @OneToOne(
            mappedBy = "userEntity",                  //UserStickyNotesEntity Classındaki UserEntity nesnesinin adı .Kullanıldığı Entity'deki alan için Tabloda bir alan oluşturulmuyor ancak Entity'de kullanılıyor.
            cascade = CascadeType.ALL,               //
            fetch = FetchType.LAZY,                 //
            orphanRemoval = true,                  //Join yapılan alan değiştirilip kaydedilirse. Kaldırılan alan Tablodan silinir
            optional = true                       //Aradaki İlişki Zorunlu mudur?
    )
    @NotFound( action = NotFoundAction.IGNORE ) //İlişkili Kayıt Yoksa Hata Almamak için Not Found ile gösteririrz
    private UserStickyNotesEntity userStickyNote;
}


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
}

public static void OneToOneExam()
{
        Date date = new Date();
        //Kullanıcı Nesnemizi Oluşturuyoruz.
        UserEntity user = new UserEntity();
        user.setUserNo(0);
        user.setUserName("Burak");
        user.setCreateHour(date);
        user.setCreateDate(date);
        user.setCreateDatetime(date);
        user.setIpAdres("192.168.1.41");

        //Kullanıcı İçin Bir Yapışkan Notu Nesnemizi Oluşturuyoruz.
        UserStickyNotesEntity userStickyNotes = new UserStickyNotesEntity();
        userStickyNotes.setNote("Kullanıcı için oluşuturulan yapışkan not");

        //Yapışkan Notu Nesnemizi Kullanıcı Nesnemize Ekliyoruz.
        user.addUserStickyNotes(userStickyNotes);

        //Kullanıcı Nesnemizi Database ekliyoruz.
        _entityManager.persist(user);

        //Yapışkan Notun 1 Id'li Kaydını Alıyoruz.
        UserStickyNotesEntity getUserStickyNote = _entityManager.find(UserStickyNotesEntity.class, 1);
        UserEntity usr = null;
        //Gelen Yapışkan Not NULL mı? Kontrol Ediyoruz ve usr Nesnemize Atıyoruz
        if(getUserStickyNote != null)
        {
            usr = getUserStickyNote.getUserEntity();
            //Kullanıcı Adı ve Not Değerleri Yazdırıyoruz.
            System.out.println(getUserStickyNote.getUserEntity().getUserName());
            System.out.println(getUserStickyNote.getNote());
        }

        //Kullanıcının 1 Id'li Kaydını Alıyoruz.
        UserEntity getUser = _entityManager.find(UserEntity.class, 1);
        UserStickyNotesEntity userStickyNote = null;
        //Gelen Kullanıcı NULL mı? Kontrol Ediyoruz ve userStickyNote Nesnemize Atıyoruz
        if(getUser != null)
        {
            userStickyNote = getUser.getUserStickyNote();
            //Kullanıcı Adı ve Not Değerleri Yazdırıyoruz.
            System.out.println(userStickyNote.getUserEntity().getUserName());
            System.out.println(userStickyNote.getNote());
        }
}
```

![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+) `@Many To Many:`

- [x]	Join yapılan tabloda n-n ilişkisinde kullanılır.

- [x]	mappedBy ile çift yönlü ilişkide kolon oluşturulmadan entity üzerinde ekleme yapılabilir.

-	Cascade Cascade tipi belirtilir. 6 tipi vardır. Bu nesneye yapılan işlem diğer nesneye de yapılır. 
-	Fetch Sorgu yapıldığında join yapılan kolonunda tamamının getirilip getirilmeyeceğini belirtir. Sürekli birlikte kullanılacak tablolar olmadıkça type Lazy yapılmalıdır. 
-	mappedBy Çift yönlü ilişkilerde kolon oluşturulmadan entity üzerine ekleme yapılır.
-	targetEntity Referans sınıfını belirtmek için kullanılır. Genelde kullanılmaz. Bazı durumlarda kullanılır.

- ![#c5f015](https://via.placeholder.com/15/c5f015/000000?text=+) `Örnek Kullanım`
```java
@Entity(name = "Purchase_Request")
@Table(name = "Purchase_Request", schema = "dbo", catalog = "hibernate")
public class PurchaseRequestEntity {

    @Column(name = "pr_stock_code", length = 11)
    private String prStockCode;
    
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            joinColumns = { @JoinColumn(name = "pr_stock_code") }, //pr_stock_code -> Purchase_Request tablosundaki pr_stock_code alanı
            inverseJoinColumns = { @JoinColumn(name = "stc_code") } // stc_code -> Stock tablosundaki stc_code alanı
    )
    Set<StockEntity> stocks = new HashSet<StockEntity>();
}

@Entity(name = "Stock")
@Table(name = "Stock", schema = "dbo", catalog = "hibernate")
public class StockEntity {
    @Column(name = "stc_code", length = 11)
    private String stcCode;
    
    @ManyToMany(mappedBy = "stocks") //mappedBy = "stocks" -> PurchaseRequestEntity Classındaki oluşturulan Set Collection'un adı
    private Set<PurchaseRequestEntity> PurchaseRequests = new HashSet<PurchaseRequestEntity>();
}

public static void ManyToManyExam()
{
        UserEntity getUser = _entityManager.find(UserEntity.class, 1);

        StockEntity stock = new StockEntity();
        stock.setStcCode("600.001.001");
        stock.setStcName("Bakır Disk");
        stock.setUnit(EnumUnit.ADET);
        _entityManager.persist(stock);
        _entityManager.flush();

        StockEntity stock2 = new StockEntity();
        stock2.setStcCode("600.001.002");
        stock2.setStcName("Bakır Levha");
        stock2.setUnit(EnumUnit.METRE);
        _entityManager.persist(stock2);
        _entityManager.flush();

        PurchaseRequestEntity pr = new PurchaseRequestEntity();
        pr.setPrStockCode("600.001.001");
        pr.setPrQuantity(30.50);
        pr.setUsers(getUser);
        pr.getStocks().add(stock);
        pr.getStocks().add(stock2);
        _entityManager.persist(pr);
        _entityManager.flush();

        List<PurchaseRequestEntity> PurchaseRequestList = _entityManager.createQuery("FROM Purchase_Request").list();
        for(PurchaseRequestEntity purchaseRequest : PurchaseRequestList) {
            for(StockEntity stocks : purchaseRequest.getStocks()) {
                System.out.println(stocks.getStcName());
            }
        }

        List<StockEntity> stockList = _entityManager.createQuery("FROM Stock").list();
        for(StockEntity stcs : stockList) {
            for(PurchaseRequestEntity PurchaseRequest : stcs.getPurchaseRequests()) {
                System.out.println(PurchaseRequest.getPrStockCode());
            }
        }
    }
```

![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+) `@Many To One:`

- [x]	En çok kullanılan ilişkidir.

- [x]  Join yapılan tablo ile arada n-1 ilişkisi vardır. MappedBy aynı şekildedir.

-	Fetch Join yapılan kolonun tamamının getirilip getirilmeyeceği belirlenir.
-	Cascade Cascade tipi belirlenir. 6 tipi vardır. 
-	optinol Aradaki ilişki belirlenir. True olursa aradaki ilişki boş geçilebilir. False olursa bu alan zorunludur.
-	Target Entity İlgili join ilişkin referans sınıfının belirlenmesini yapar.

- ![#c5f015](https://via.placeholder.com/15/c5f015/000000?text=+) `Örnek Kullanım`
```java
@Entity(name = "Purchase_Request")
@Table(name = "Purchase_Request", schema = "dbo", catalog = "hibernate")
public class PurchaseRequestEntity {
    @Id
    @Column(name="pr_Id", unique = true, nullable = false)
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int prId;

    @ManyToOne(
            targetEntity = UserEntity.class,   //
            cascade = CascadeType.ALL,        //
            fetch = FetchType.LAZY,          //
            optional = true                //Aradaki İlişki Zorunlu mudur?
    )
    @JoinColumn(name = "pr_usr_Id", insertable = true)
    private UserEntity users;
}

@Entity(name = "users")
@Table(name = "users", schema = "dbo", catalog = "hibernate")
public class UserEntity {
    @Id
    @Column(name="usr_Id", unique = true, nullable = false)
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int Id;
}

public static void ManyToOneExam()
{
        //Kullanıcının 1 Id'li Kaydını Alıyoruz.
        UserEntity getUser = _entityManager.find(UserEntity.class, 1);
        PurchaseRequestEntity pr = new PurchaseRequestEntity();
        pr.setPrStockCode("600.001.001");//Bakır Disk Kodu
        pr.setPrQuantity(30.50);//Kilosu
        pr.setUsers(getUser);
        _entityManager.persist(pr);

        //Satınalma Talebi 1 Id'li Kaydını Alıyoruz.
        PurchaseRequestEntity getpurchaseRequest = _entityManager.find(PurchaseRequestEntity.class, 1);
        UserEntity usr = null;
        //Gelen Satınalma Talebi NULL mı? Kontrol Ediyoruz ve usr Nesnemize Atıyoruz
        if(getpurchaseRequest != null)
        {
            usr = getpurchaseRequest.getUsers();
            //Kullanıcı Adı ve Not Değerleri Yazdırıyoruz.
            System.out.println(getpurchaseRequest.getPrStockCode());
            System.out.println(getpurchaseRequest.getUsers().getUserName());
        }
}
```


![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+) `@One To Many:`

- [x]	Join yapılan tablo ile arada 1-n ilişkisi vardır.

-	Fetch Join yapılan kolonun tamamının getirilip getirilmeyeceği belirlenir.
-	Cascade Cascade tipi belirlenir. 6 tipi vardır. 
-	mappedBy İlişki alanı için entityde kullanılan alan için databasede bir ilişkinin tablosu oluşturulmaz.
-	Target Entity İlgili join ilişkin referans sınıfının belirlenmesini yapar.
-	OrhonRemowal true olursa ve join yaptığımız alanı değiştirip kaydedersek kaldırılan alanda databaseden silinir.


- ![#c5f015](https://via.placeholder.com/15/c5f015/000000?text=+) `Örnek Kullanım`
```java
@Entity(name = "users")
@Table(name = "users", schema = "dbo", catalog = "hibernate")
public class UserEntity {
    @Id
    @Column(name="usr_Id", unique = true, nullable = false)
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int Id;
    
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "log_usr_Id", insertable = true)
    @NotFound( action = NotFoundAction.IGNORE )                 //İlişkili Kayıt Yoksa Hata Almamak için Not Found ile gösteririrz
    private List<LogEntity> logs = new ArrayList<LogEntity>();
}


@Entity(name = "Log")
@Table(name = "Log", schema = "dbo", catalog = "hibernate")
public class LogEntity {
    @Id
    @Column(name="log_Id", unique = true, nullable = false)
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int log_Id;
    
    @Column(name = "log_usr_Id", precision = 4, scale = 0)
    //precision - Toplam digit sayısı
    //scale - Virgulden sonra 3 hane olur.
    private double logUsId;
}

 public static void OneToManyExam()
{
        Date date = new Date();
        //Kullanıcının 1 Id'li Kaydını Alıyoruz.
        UserEntity getUser = _entityManager.find(UserEntity.class, 1);
        LogEntity log1 = new LogEntity();
        log1.setIpAdres("192.168.1.41");
        log1.setLoginDatetime(date);

        LogEntity log2 = new LogEntity();
        log2.setIpAdres("192.168.1.41");
        log2.setLoginDatetime(date);

        getUser.getLogs().add(log1);
        getUser.getLogs().add(log2);
        _entityManager.persist(getUser);
        _entityManager.flush();

        getUser.getLogs().remove(log1);

        for (LogEntity item: getUser.getLogs()) {
            System.out.println("İp Adres:" + item.getIpAdres());
        }
}
```

![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+) `@JoinColumn:`

- [x]	Entity içinde bir entity tanımlanması durumunda kullanılır.

- [x]	Oluşacak ilişki kolonuna ait özellikleri belirtmemize yarar.

- [x]	Kullanılmazsa default değerleri ile kolon oluşur.

-	Name Oluşacak kolonun adını belirleriz.
-	Nullable Boş olup olamayacağını belirleriz.
-	foreignKey Foreign Key’ini belirleriz.
-	refrencedColumnName Id dışında başka bir kolon ile join yapılacaksa o kolonu belirtiriz.
-	İnsertable İnsert edilip edilmeyeceğini belirleriz.
-	Updatable Update edilip edilmeyeceğini belirleriz.
-	Unique Tabloda o kolonun uniq olup olmadığını belirtmemizi sağlar.
-	Table Tablosunu belirleriz.
-	ColumnDefinition Colon için oluşturulan ddl’e eklenecek SQL’i belirleriz.

![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+) `@ForeignKey:`

- [x]	Tabloya Foreign key eklemek ve özelleştirmek için kullanılır.

- [x]	Eskiden tek başına kullanılırdı anca bu method artık kullanılmamaktadır.

-	Name İsmi özelleştirebiliriz.
-	ForeignKeyDefinition ForeignKey için tanımlamalar yapabiliriz.
-	Value Constraint modu belirleyebiliriz. 3 değeri vardır.
I.	constraint: Constraintleri uygular.
II.	no_constraint: Constraintleri uygulamaz.
III.	provider_default: Providerda tanımlı default davranışları benimser.

![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+) `@Index:`

- [x]	İndex eklemek için kullanılır.

- [x]	Birden fazla kolon için aynı index kullanılabilir.

- [x]	Eskiden tek başına kullanılırdı ancak bu method artık kullanılmamaktadır.

-	Name İsim özelleştirebiliriz.
-	ColumnList Eklenen isimleri hangi kolonlara ait olacağını belirtilir. Birden fazla eklenebilir. ''Adi, Id’’ gibi
-	Unique Unique ile index’i unique yapabiliriz. Default olarak False’dır. True yaparsak index unique yapılır ve indexdeki indexleme alanı olarak seçilen verilerin tekrar kullanılmaması için bu yapı kullanılır. Veriye erişim hızını arttırır.

![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+) `@SecondaryTable:` Bir entity classında normalde bir tablo kullanılanbilir ancak SecondaryTable ile ikinci tabloyu kullanmak mümkündür.
```java
@Table(name = ”Personel”)
@SecondaryTable(name = “Adres”)
public class Personel {

@Column(name = “Adres”, table = “Adres”)
Private String Adres;
}
```
![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+)`@Embedded ve @Embeddedable:` Bir Class’ı entity clasında kullanacağız. Bu kullanımda ilgli Class’ı bir alan gibi kullanacaz.
```java
@Embeddedable
public class Adres {
.
.
.
}

@Entity
@Table(name = ”Personel”)
public class Personel {

@Embedded
Private Adres adres;
.
.
.
Set/get
}
```
![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+) `@ElementCollection:` Bir kişinin birden fazla adresi olabilir. Biz bunları aynı tabloda tutmuyoruz. ForeignKey ile farklı tabloda tutuyoruz. 
```java
public class Adres {
.
.
.
}

@Entity
@Table(name = ”Personel”)
public class Personel {

@ElementCollection
Private List<Adres> adres;
.
.
.
Set/get
}
```
![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+) `@Cachable:` Uygulama ile database arasındaki tampon bellektir. Bu tampon bellek, veritabanı isteğini azaltmak için kullanılır.
```java
@Entity
@Table(name = ”Personel”)
@Cachable
@Cache(usage = CacheConCurrencyStrategy.Read_WRITE)
public class Personel {

}
```
Not: Bu işlem ikinci seviye cachleleme yöntemidir. Hiç cache kullanmasak bile varsayılan olarak 1. Seviye cacheleme yapılmaktadır.



![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+) `Cache Provider:` 4 tane cache provider vardır. 

Hibernate Config xml kullanımı; 
```java
<property name = “hibernatecache.provider_class”>
Org.hibernate.cache.EhcacheProvider
</property>
```
Javada Kullanımı;
```java
query.setCachable(true);
```

1.	EHCache (Easy Hibernate Cache): Çok hızlıdır. Read-Wrider , Read.Only destekler.
2.	OS Cache (Open Symphony Cache): Çok güçlüdür. Gruplama destekliyor. Sorguları son kullanma zamanı kontrolü destekler.
3.	Swarm Cache: Yazma işlemi yoğun ise uygundur.
4.	JBoss Tree Cache: Ağırlıklı bankalarda kullanılır.

![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+) `Hibernate Toplu işlemler:` Toplu eklemede Hibernate 50.000 kayıttan sonra OutOfMemoryException verir. Toplu ekleme miktarını Hibernate config dosyasına yazmak gerekir. 
```java
<property name = “hibernatecache.jdbc.batch_size”>
50
</property>
```
Bu özellik sonrası yapılan toplu işlemde her 50. Kayıtta bir 
```sh
Session.flush();
Session.clear();
```
otomatik olarak yapılacak.
