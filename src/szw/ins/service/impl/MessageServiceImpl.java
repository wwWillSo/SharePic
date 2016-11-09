package szw.ins.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import szw.ins.dao.MessageDAO;
import szw.ins.model.Message;
import szw.ins.service.MessageService;

public class MessageServiceImpl implements MessageService{
	
	@Autowired
	private MessageDAO messageDAO ;

	@Override
	public Message get(Class<Message> entityClazz, Serializable id) {
		return messageDAO.get(entityClazz, id) ;
	}

	@Override
	public Serializable save(Message entity) {
		return messageDAO.save(entity) ;
	}

	@Override
	public void update(Message entity) {
		messageDAO.update(entity);
	}

	@Override
	public void delete(Message entity) {
		messageDAO.delete(entity);
	}

	@Override
	public void delete(Class<Message> entityClazz, Serializable id) {
		messageDAO.delete(entityClazz, id);
	}

	@Override
	public List<Message> findAll(Class<Message> entityClazz) {
		return messageDAO.findAll(entityClazz) ;
	}

	@Override
	public long findCount(Class<Message> entityClazz) {
		return messageDAO.findCount(entityClazz) ;
	}

	public MessageDAO getMessageDAO() {
		return messageDAO;
	}

	public void setMessageDAO(MessageDAO messageDAO) {
		this.messageDAO = messageDAO;
	}

}
