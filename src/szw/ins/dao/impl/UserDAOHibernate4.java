package szw.ins.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import szw.ins.dao.UserDAO;
import szw.ins.model.User;

public class UserDAOHibernate4 implements UserDAO {
	//DAO�齨���г־û������ײ�������SessionFactory���
	private SessionFactory sessionFactory ;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf ;
	}
	public SessionFactory getSessionFactory() {
		return this.sessionFactory ;
	}

	@Override
	public User get(Class<User> entityClazz, Serializable id) {
		return (User)getSessionFactory().getCurrentSession().get(entityClazz, id) ;
	}

	@Override
	public Serializable save(User entity) {
		return getSessionFactory().getCurrentSession().save(entity) ;
	}

	@Override
	public void update(User entity) {
		getSessionFactory().getCurrentSession().saveOrUpdate(entity);
	}

	@Override
	public void delete(User entity) {
		getSessionFactory().getCurrentSession().delete(entity);
	}

	@Override
	public void delete(Class<User> entityClazz, Serializable id) {
		getSessionFactory().getCurrentSession()
			.createQuery("delete " + entityClazz.getSimpleName() + " en where en.id = ?0")
			.setParameter("0", id)
			.executeUpdate() ;
	}

	@Override
	public List<User> findAll(Class<User> entityClazz) {
		return find("select en from " + entityClazz.getSimpleName() + " en") ;
	}

	@Override
	public long findCount(Class<User> entityClazz) {
		List<?> list = find ("select count(*) from " + entityClazz.getSimpleName()) ;
		//���ز�ѯ�õ���ʵ������
		if (list!=null && list.size() == 1) {
			return (long)list.get(0) ;
		}
		
		return 0 ; 
	}
	
	//����HQL��ѯʵ��
	@SuppressWarnings("unchecked")
	protected List<User> find(String hql) {
		return (List<User>)getSessionFactory().getCurrentSession().createQuery(hql).list() ;
	}
	
	//���ݴ�ռλ��������HQL��ѯʵ��
	@SuppressWarnings("unchecked")
	protected List<User> find(String hql, Object[] params) {
		//������ѯ
		Query query = getSessionFactory().getCurrentSession().createQuery(hql) ;
		//Ϊ����ռλ����HQL������ò���
		for (int i = 0, len=params.length; i < len; i ++) {
			query.setParameter(i + "", params[i]) ;
		}
		return (List<User>)query.list() ;
	}
	
	/**
	 * ��ҳ��ѯ
	 */
	@SuppressWarnings("unchecked")
	protected List<User> findByPage(String hql, int pageNo, int pageSize) {
		//������ѯ
		return getSessionFactory().getCurrentSession().createQuery(hql)
				.setFirstResult((pageNo-1) * pageSize)
				.setMaxResults(pageSize)
				.list() ;
	}
	
	/**
	 * ��ռλ�������ķ�ҳ��ѯ
	 */
	@SuppressWarnings("unchecked")
	protected List<User> findByPage(String hql, int pageNo, int pageSize, Object[] params) {
		//������ѯ
		Query query = getSessionFactory().getCurrentSession().createQuery(hql) ;
		
		//Ϊ����ռλ����hql������ò���
		for (int i = 0, len = params.length; i < len; i ++) {
			query.setParameter(i + "", params[i]) ;
		}
		
		//ִ�з�ҳ�������ز�ѯ���
		return query.setFirstResult((pageNo-1)*pageSize)
				.setMaxResults(pageSize)
				.list() ;
	}
}
