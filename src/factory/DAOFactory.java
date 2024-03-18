package factory;

import dao.GeneralDAO;
import dao.impl.CategoryDAOImpl;
import dao.impl.ProductDAOImpl;

public class DAOFactory {
	public static <T> GeneralDAO getDAO(Class<T> _class){
		if(_class == CategoryDAOImpl.class)
			return CategoryDAOImpl.getInstance();
		else if(_class == ProductDAOImpl.class)
			return ProductDAOImpl.getInstance();
		return null;
		
	}
}
