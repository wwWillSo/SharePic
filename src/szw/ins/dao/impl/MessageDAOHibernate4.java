package szw.ins.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import szw.ins.dao.MessageDAO;
import szw.ins.model.Message;

public class MessageDAOHibernate4 implements MessageDAO{
	
	//DAO�齨���г־û������ײ�������SessionFactory���
	private SessionFactory sessionFactory ;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf ;
	}
	public SessionFactory getSessionFactory() {
		return this.sessionFactory ;
	}

	@Override
	public Message get(Class<Message> entityClazz, Serializable id) {
		return (Message)getSessionFactory().getCurrentSession().get(entityClazz, id) ;
	}

	@Override
	public Serializable save(Message entity) {
		return getSessionFactory().getCurrentSession().save(entity) ;
	}

	@Override
	public void update(Message entity) {
		getSessionFactory().getCurrentSession().saveOrUpdate(entity);
	}

	@Override
	public void delete(Message entity) {
		getSessionFactory().getCurrentSession().delete(entity);
	}

	@Override
	public void delete(Class<Message> entityClazz, Serializable id) {
		getSessionFactory().getCurrentSession()
			.createQuery("delete " + entityClazz.getSimpleName() + " en where en.id = ?0")
			.setParameter("0", id)
			.executeUpdate() ;
	}

	@Override
	public List<Message> findAll(Class<Message> entityClazz) {
		return find("select en from " + entityClazz.getSimpleName() + " en") ;
	}

	@Override
	public long findCount(Class<Message> entityClazz) {
		List<?> list = find ("select count(*) from " + entityClazz.getSimpleName()) ;
		//���ز�ѯ�õ���ʵ������
		if (list!=null && list.size() == 1) {
			return (long)list.get(0) ;
		}
		
		return 0 ; 
	}
	
	//����HQL��ѯʵ��
	@SuppressWarnings("unchecked")
	protected List<Message> find(String hql) {
		return (List<Message>)getSessionFactory().getCurrentSession().createQuery(hql).list() ;
	}
	
	//���ݴ�ռλ��������HQL��ѯʵ��
	@SuppressWarnings("unchecked")
	protected List<Message> find(String hql, Object[] params) {
		//������ѯ
		Query query = getSessionFactory().getCurrentSession().createQuery(hql) ;
		//Ϊ����ռλ����HQL������ò���
		for (int i = 0, len=params.length; i < len; i ++) {
			query.setParameter(i + "", params[i]) ;
		}
		return (List<Message>)query.list() ;
	}
	
	/**
	 * ��ҳ��ѯ
	 */
	@SuppressWarnings("unchecked")
	protected List<Message> findByPage(String hql, int pageNo, int pageSize) {
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
	protected List<Message> findByPage(String hql, int pageNo, int pageSize, Object[] params) {
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
