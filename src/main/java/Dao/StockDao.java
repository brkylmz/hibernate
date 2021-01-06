package Dao;

import Dto.StockDto;
import Model.Domain.StockEntity;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class StockDao {
    private SessionFactory _sessionFactory;
    private Session _session;

    public StockDao() {
        this._sessionFactory = HibernateUtil.getSessionFactory();
        this._session = _sessionFactory.openSession();
    }

    public List<StockEntity> StockAll()
    {
        Query query = _session.createQuery("FROM Stock");
        return query.list();
    }

    public  StockEntity stockFindById(int id)
    {
        Query query = _session.createQuery("FROM Stock WHERE stc_Id =:stc_Id");
        query.setParameter("stc_Id", id);
        return (StockEntity) query.uniqueResult();
    }

    public List<StockEntity> StockFindByBetween(int minId, int maxId)
    {
        Query query = _session.createQuery("FROM Stock WHERE stc_Id >= :minId AND stc_Id <= :maxId");
        query.setParameter("minId", minId);
        query.setParameter("maxId", maxId);
        return query.list();
    }

    public List<StockEntity> StockFindByLike(String stc_name, MatchMode matchMode)
    {
        Query query = _session.createQuery("FROM Stock WHERE stc_name like :stc_name");
        switch (matchMode)
        {
            case EXACT:
                query.setParameter("stc_name", stc_name);
                break;
            case START:
                query.setParameter("stc_name", stc_name + "%");
                break;
            case END:
                query.setParameter("stc_name", "%" + stc_name);
                break;
            case ANYWHERE:
                query.setParameter("stc_name", "%" + stc_name + "%");
                break;
        }
        return query.list();
    }

    public List<StockEntity> StockByOrderAll()
    {
        Query query = _session.createQuery("FROM Stock ORDER BY stc_Id DESC");
        return query.list();
    }

    public List<StockEntity> StockByLimit(int maxResult)
    {
        Query query = _session.createQuery("FROM Stock ORDER BY stc_Id");
        query.setMaxResults(maxResult);
        return query.list();
    }

    public List<StockEntity> StockByDate(Date createDate)
    {
        Query query = _session.createQuery("FROM Stock WHERE stc_Create_date_time <= :stc_Create_date_time");
        query.setParameter("stc_Create_date_time", createDate);
        return query.list();
    }

    public Long stockByCount()
    {
        Query query = _session.createQuery("SELECT COUNT(Stock) FROM Stock Stock");
        return (Long) query.uniqueResult();
    }

    public Long stockBySum()
    {
        Query query = _session.createQuery("SELECT SUM(Stock.stc_Id) FROM Stock Stock");
        return (Long) query.uniqueResult();
    }

    public List<StockEntity> stockByDistinct()
    {
        Query query = _session.createQuery("SELECT Distinct(Stock.stc_unit) FROM Stock Stock");
        return query.list();
    }

    public Long stockByAVG()
    {
        Query query = _session.createQuery("SELECT AVG(Stock.stc_Id) FROM Stock Stock");
        return (Long) query.uniqueResult();
    }

    public Long stockByMin()
    {
        Query query = _session.createQuery("SELECT Min(Stock.stc_Id) FROM Stock Stock");
        return (Long) query.uniqueResult();
    }

    public Long stockByMax()
    {
        Query query = _session.createQuery("SELECT Max(Stock.stc_Id) FROM Stock Stock");
        return (Long) query.uniqueResult();
    }

    public List<StockDto> StockByGroupBy()
    {
        Query query = _session.createQuery("Select new Dto.StockDto(stock.stc_unit) FROM Stock stock GROUP BY stc_unit");
        return query.list();
    }

    public List<StockEntity> StockByProcedureParameter(String stc_name)
    {
        Query query = _session.createNativeQuery("{call prcAlinanTekliflerListesi(?)}").addEntity(StockEntity.class);
        query.setParameter(1, stc_name);
        return query.list();
    }
    public List<StockEntity> StockByProcedure()
    {
        Query query = _session.createNativeQuery("{call prcAlinanTekliflerListesi()}").addEntity(StockEntity.class);
        return query.list();
    }

}
