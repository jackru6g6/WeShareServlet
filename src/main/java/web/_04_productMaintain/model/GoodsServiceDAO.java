package web._04_productMaintain.model;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;


public interface GoodsServiceDAO {
	public int insertGoods(GoodsBean gb, InputStream is,
			long size, String filename) throws SQLException;
	
	public int updateGoods(GoodsBean bean, InputStream is, 
			long sizeInBytes, String filename) throws SQLException;
	
	public List<GoodsBean> getGoodsByIndId(String indid,long now) throws SQLException;
	
	public GoodsBean getGoodsByGoodsno(String goodsno) throws SQLException;
	
	public int deleteGoods(int goodsno) throws SQLException;
	
	public List<GoodsBean> getGoodsByGoodsStatus(String goodsstatus)throws SQLException;
	
	public List<GoodsBean> getGoods(String goodsstatusValue) throws SQLException;
	
	public List<GoodsBean> getGoodsByUserType(String goodsstatusValue,int usertype) throws SQLException;
	
	public List<GoodsBean> getGoodsByGoodsType(String goodsstatusValue,String goodstype) throws SQLException;
	
	public List<GoodsBean> getGoodsByGoodsLoc(String goodsstatusValue,String goodsloc) throws SQLException;
	
	public List<GoodsBean> getGoodsByKeyword(String goodsstatusValue,String keyword) throws SQLException;
	


}
