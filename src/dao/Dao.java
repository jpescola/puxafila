package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Dao genérico Hibernate
 *
 * @author jpescola
 * @param <T>
 */
public class Dao<T> {

    private EntityManagerFactory factory = null;
    private EntityManager manager = null;
    private static Dao instance = null;

    protected Dao() {
        factory = Persistence.createEntityManagerFactory("ExemploPU");
        manager = factory.createEntityManager();
    }

    public static Dao getIntance() {
        if (instance == null) {
            instance = new Dao();
        }
        return instance;
    }

    public void fechar() {
        manager.close();
        factory.close();
    }

    public boolean salvar(T t) {
        try {
            manager.getTransaction().begin();
            manager.persist(t);
            manager.flush();
            manager.refresh(t);
            manager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean excluir(T t) {
        try {
            manager.getTransaction().begin();
            manager.remove(t);
            manager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<T> listarNaoNulos(Class c, String campo, String order) {
        List<T> lista = null;
        try {
            manager.getTransaction().begin();
            CriteriaBuilder builder = manager.getCriteriaBuilder();
            CriteriaQuery<T> criteria = builder.createQuery(c);
            Root<T> root = criteria.from(c);
            criteria.select(root);
            criteria.where(builder.isNotNull(root.get(campo)));
            if (order.equals("desc")) {
                criteria.orderBy(builder.desc(root.get(campo)));
            } else {
                criteria.orderBy(builder.asc(root.get(campo)));
            }
            lista = manager.createQuery(criteria).getResultList();
            manager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<T> listarNulos(Class c, String campo) {
        List<T> lista = null;
        try {
            manager.getTransaction().begin();
            CriteriaBuilder builder = manager.getCriteriaBuilder();
            CriteriaQuery<T> criteria = builder.createQuery(c);
            Root<T> root = criteria.from(c);
            criteria.select(root);
            criteria.where(builder.isNull(root.get(campo)));
            lista = manager.createQuery(criteria).getResultList();
            manager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<T> listar(Class c, String campo, T valor) {
        List<T> lista = null;
        try {
            manager.getTransaction().begin();
            CriteriaBuilder builder = manager.getCriteriaBuilder();
            CriteriaQuery<T> criteria = builder.createQuery(c);
            Root<T> root = criteria.from(c);
            criteria.select(root);
            if (valor.getClass() == String.class) {
                criteria.where(builder.like(root.get(campo), "%" + valor + "%"));
            } else {
                criteria.where(builder.equal(root.get(campo), valor));
            }
            lista = manager.createQuery(criteria).getResultList();
            manager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<T> listar(Class c) {
        List<T> lista = null;
        try {
            manager.getTransaction().begin();
            CriteriaBuilder builder = manager.getCriteriaBuilder();
            CriteriaQuery<T> criteria = builder.createQuery(c);
            Root<T> root = criteria.from(c);
            criteria.select(root);
            lista = manager.createQuery(criteria).getResultList();
            manager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public T get(Class c, int id) {
        manager.getTransaction().begin();
        T t = (T) manager.find(c, id);
        manager.getTransaction().commit();
        return t;
    }
}
