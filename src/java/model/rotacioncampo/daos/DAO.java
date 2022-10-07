package model.rotacioncampo.daos;

/**
 *
 * @author saul.ortigoza
 */
public interface DAO {
    public Object create(Object obj) throws Exception;
    public Object retrieve(Object obj) throws Exception;
    public int update(Object obj) throws Exception;
    public Object delete(Object obj) throws Exception;
}
