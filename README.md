# hibernate
![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+) `@Entity:` Veri tabanında bir karşılığı olduğunu belirtir.
![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+) `@Table:` @Entity ile birlikte kullanılır. Database’de bir tabloya karşılık geldiğini belirtilir.  Özellikleri;
-	Name: Tablo adını belirtir. Kullanılmazsa Class’ın adında bir tablomuz oluşur.
-	Catalog: Tablonun catalog (database) belirtilir. (Örnek: JavaFx_GGM)
-	Schema: Tablonun schema belirtilir. (Örnek: dbo)
-	UniqeConstraints: Null değer olabilen primary key constraintlerdir.
-	İndexes: Tablonun indexlerinin belirtir.
-	
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

![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+) `@OneToOne:`
->	Join yapılan tabloda 1-1 ilişkide kullanılır.
->	mappedBy ile çift yönlü ilişkide kolon oluşturulmadan entity üzerine ekleme yapılır.

-	Coscade Coscade tipi belirlenir. 6 farklı tipi vardır. Yapılan işlemi diğer nesnede de yapılması istenirse ALL seçilir.
-	Fetch Sorgu yapıldığında Join yapılan kolonunda getirilip getirilmemesi belirlenir. Default olarak Eager gelir. Sürekli birlikte kullanılır eagerda.
-	mappedBy Çift yönlü ilişkilerde kullanılır.
-	optional Aradaki ilişki belirlenir. Default true’dur. İstenirse boş geçilebilir. False’de ilişki kurulması şarttır.
-	opphanRemovol True olursa ve join yapılan alan değiştirilip kaydedersek kaldırılan alan database’den silinir.
-	Target Entity İlgili referans sınıfının belirtilmesine yarar. Genelde gerekmez. Özel durumlarda gerekir.

![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+) `@Many To Many:`
->	Join yapılan tabloda n-n ilişkisinde kullanılır.
->	mappedBy ile çift yönlü ilişkide kolon oluşturulmadan entity üzerinde ekleme yapılabilir.

-	Cascade Cascade tipi belirtilir. 6 tipi vardır. Bu nesneye yapılan işlem diğer nesneye de yapılır. 
-	Fetch Sorgu yapıldığında join yapılan kolonunda tamamının getirilip getirilmeyeceğini belirtir. Sürekli birlikte kullanılacak tablolar olmadıkça type Lazy yapılmalıdır. 
-	mappedBy Çift yönlü ilişkilerde kolon oluşturulmadan entity üzerine ekleme yapılır.
-	targetEntity Referans sınıfını belirtmek için kullanılır. Genelde kullanılmaz. Bazı durumlarda kullanılır.

![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+) `@Many To One:`
->	En çok kullanılan ilişkidir.
->  Join yapılan tablo ile arada n-1 ilişkisi vardır. MappedBy aynı şekildedir.
-	Fetch Join yapılan kolonun tamamının getirilip getirilmeyeceği belirlenir.
-	Cascade Cascade tipi belirlenir. 6 tipi vardır. 
-	optinol Aradaki ilişki belirlenir. True olursa aradaki ilişki boş geçilebilir. False olursa bu alan zorunludur.
-	Target Entity İlgili join ilişkin referans sınıfının belirlenmesini yapar.

![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+) `@One To Many:`
->	Join yapılan tablo ile arada 1-n ilişkisi vardır.
-	Fetch Join yapılan kolonun tamamının getirilip getirilmeyeceği belirlenir.
-	Cascade Cascade tipi belirlenir. 6 tipi vardır. 
-	mappedBy İlişki alanı için entityde kullanılan alan için databasede bir ilişkinin tablosu oluşturulmaz.
-	Target Entity İlgili join ilişkin referans sınıfının belirlenmesini yapar.
-	OrhonRemowal true olursa ve join yaptığımız alanı değiştirip kaydedersek kaldırılan alanda databaseden silinir.

![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+) `@JoinColumn:`
->	Entity içinde bir entity tanımlanması durumunda kullanılır.
->	Oluşacak ilişki kolonuna ait özellikleri belirtmemize yarar.
->	Kullanılmazsa default değerleri ile kolon oluşur.
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
->	Tabloya Foreign key eklemek ve özelleştirmek için kullanılır.
->	Eskiden tek başına kullanılırdı anca bu method artık kullanılmamaktadır.
-	Name İsmi özelleştirebiliriz.
-	ForeignKeyDefinition ForeignKey için tanımlamalar yapabiliriz.
-	Value Constraint modu belirleyebiliriz. 3 değeri vardır.
I.	constraint: Constraintleri uygular.
II.	no_constraint: Constraintleri uygulamaz.
III.	provider_default: Providerda tanımlı default davranışları benimser.

![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+) `@Index:`
->	İndex eklemek için kullanılır.
->	Birden fazla kolon için aynı index kullanılabilir.
->	Eskiden tek başına kullanılırdı ancak bu method artık kullanılmamaktadır.
-	Name İsim özelleştirebiliriz.
-	ColumnList Eklenen isimleri hangi kolonlara ait olacağını belirtilir. Birden fazla eklenebilir. ''Adi, Id’’ gibi
-	Unique Unique ile index’i unique yapabiliriz. Default olarak False’dır. True yaparsak index unique yapılır ve indexdeki indexleme alanı olarak seçilen verilerin tekrar kullanılmaması için bu yapı kullanılır. Veriye erişim hızını arttırır.

![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+) `@SecondaryTable:` Bir entity classında normalde bir tablo kullanılanbilir ancak SecondaryTable ile ikinci tabloyu kullanmak mümkündür.
```sh
@Table(name = ”Personel”)
@SecondaryTable(name = “Adres”)
public class Personel {

@Column(name = “Adres”, table = “Adres”)
Private String Adres;
}
```
![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+)`@Embedded ve @Embeddedable:` Bir Class’ı entity clasında kullanacağız. Bu kullanımda ilgli Class’ı bir alan gibi kullanacaz.
```sh
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
```sh
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
```sh
@Entity
@Table(name = ”Personel”)
@Cachable
@Cache(usage = CacheConCurrencyStrategy.Read_WRITE)
public class Personel {

}
```
Not: Bu işlem ikinci seviye cacleleme yöntemidir. Hiç cache kullanmasak bile varsayılan olarak 1. Seviye cacheleme yapılmaktadır.



![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+) `Cache Provider:` 4 tane cache provider vardır. 

Hibernate Config xml kullanımı; 
```sh
<property name = “hibernatecache.provider_class”>
Org.hibernate.cache.EhcacheProvider
</property>
```
Javada Kullanımı:
query.setCachable(true);

1.	EHCache (Easy Hibernate Cache): Çok hızlıdır. Read-Wrider , Read.Only destekler.
2.	OS Cache (Open Symphony Cache): Çok güçlüdür. Gruplama destekliyor. Sorguları son kullanma zamanı kontrolü destekler.
3.	Swarm Cache: Yazma işlemi yoğun ise uygundur.
4.	JBoss Tree Cache: Ağırlıklı bankalarda kullanılır.

![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+) `Hibernate Toplu işlemler:` Toplu eklemede Hibernate 50.000 kayıttan sonra OutOfMemoryException verir. Toplu ekleme miktarını Hibernate config dosyasına yazmak gerekir. 
```sh
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
