package Controller;

import Dto.StockDto;
import EntityServices.StockEntityService;
import Model.Domain.*;
import enums.EnumUnit;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Main {
    public static final Session _entityManager = HibernateUtil.getSessionFactory().openSession();
    public static final Transaction _transaction = _entityManager.beginTransaction();

    public static void main(String[] args) {
        //OneToOneExam();
        //ManyToOneExam();
        //OneToManyExam();
        //ManyToManyExam();

        StockEntityService stockEntityService = new StockEntityService();
        List<StockEntity> stockAllList = stockEntityService.StockAll();
        for (StockEntity item: stockAllList)
            System.out.println(item.getStcName());

        StockEntity stock = stockEntityService.stockFindById(3);
        System.out.println(stock.getStcName());

        List<StockEntity> stockBetweenList = stockEntityService.StockFindByBetween(1, 50);
        for (StockEntity item: stockAllList)
            System.out.println(item.getStcName());

        List<StockEntity> stockLikeList = stockEntityService.StockFindByLike("Disk", MatchMode.EXACT);
        for (StockEntity item: stockAllList)
            System.out.println(item.getStcName());

        stockAllList = stockEntityService.StockByOrderAll();
        for (StockEntity item: stockAllList)
            System.out.println(item.getStcName());

        stockAllList = stockEntityService.StockByLimit(3);
        for (StockEntity item: stockAllList)
            System.out.println(item.getStcName());

        SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = simpleFormatter.parse("2019-03-02");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        stockAllList = stockEntityService.StockByDate(date);
        for (StockEntity item: stockAllList)
        System.out.println(item.getStcName());

        Long count = stockEntityService.stockByCount();
        System.out.println(count);

        Long sum = stockEntityService.stockBySum();
        System.out.println(sum);

        stockAllList = stockEntityService.stockByDistinct();
        for (StockEntity item: stockAllList)
            System.out.println(item.getUnit());

        Long avg = stockEntityService.stockByAVG();
        System.out.println(avg);

        Long min = stockEntityService.stockByMin();
        System.out.println(min);

        Long max = stockEntityService.stockByMax();
        System.out.println(max);

        List<StockDto> stockDtoList = stockEntityService.StockByGroupBy();
        for (StockDto item: stockDtoList)
            System.out.println(item.getUnit());

        stockAllList = stockEntityService.StockByProcedureParameter("Bakır Disk");
        for (StockEntity item: stockAllList)
            System.out.println(item.getStcName());

        stockAllList = stockEntityService.StockByProcedure();
        for (StockEntity item: stockAllList)
            System.out.println(item.getStcName());

        _transaction.commit();
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
}
