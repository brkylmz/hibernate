package EntityServices;

import Dao.StockDao;
import Dto.StockDto;
import Model.Domain.StockEntity;
import org.hibernate.criterion.MatchMode;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class StockEntityService {
    private StockDao stockDao;

    public StockEntityService() {
        stockDao = new StockDao();
    }
    public List<StockEntity> StockAll()
    {
        return stockDao.StockAll();
    }

    public  StockEntity stockFindById(int id)
    {
        return stockDao.stockFindById(id);
    }

    public List<StockEntity> StockFindByBetween(int minId, int maxId)
    {
        return stockDao.StockFindByBetween(minId, maxId);
    }

    public List<StockEntity> StockFindByLike(String stc_name, MatchMode matchMode)
    {
        return stockDao.StockFindByLike("Disk", matchMode);
    }

    public List<StockEntity> StockByOrderAll()
    {
        return stockDao.StockByOrderAll();
    }

    public List<StockEntity> StockByLimit(int maxResult)
    {
        return stockDao.StockByLimit(maxResult);
    }

    public List<StockEntity> StockByDate(Date createDate)
    {
        return stockDao.StockByDate(createDate);
    }

    public Long stockByCount()
    {
        return stockDao.stockByCount();
    }

    public Long stockBySum()
    {
        return stockDao.stockBySum();
    }

    public List<StockEntity> stockByDistinct()
    {
        return stockDao.stockByDistinct();
    }

    public Long stockByAVG()
    {
        return stockDao.stockByAVG();
    }

    public Long stockByMin()
    {
        return stockDao.stockByMin();
    }

    public Long stockByMax()
    {
        return stockDao.stockByMax();
    }

    public List<StockDto> StockByGroupBy()
    {
        return stockDao.StockByGroupBy();
    }

    public List<StockEntity> StockByProcedureParameter(String stc_name)
    {
        return stockDao.StockByProcedureParameter(stc_name);
    }

    public List<StockEntity> StockByProcedure()
    {
        return stockDao.StockByProcedure();
    }
}
