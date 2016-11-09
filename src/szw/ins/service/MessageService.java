package szw.ins.service;

import java.io.Serializable;
import java.util.List;

import szw.ins.model.Message;

public interface MessageService {
	public Message get(Class<Message> entityClazz, Serializable id) ;
	
	public Serializable save(Message entity) ;
	
	public void update(Message entity) ;
	
	public void delete(Message entity) ;
	
	public void delete(Class<Message> entityClazz, Serializable id) ;
	
	public List<Message> findAll(Class<Message> entityClazz) ;
	
	public long findCount(Class<Message> entityClazz) ;
}
