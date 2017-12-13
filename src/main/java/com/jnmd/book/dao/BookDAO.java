package com.jnmd.book.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jnmd.book.domain.Book;
import com.jnmd.book.exception.BookException;

@Repository
@Transactional
public class BookDAO{
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	//��������
	public void savePerson(final Book book) throws BookException{
		hibernateTemplate.execute(new HibernateCallback<Book>(){
			@Override
			public Book doInHibernate(Session session) throws HibernateException {
				session.save(book);
				return null;
			}
		});
	}
	//��ѯ����
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Book> selectAllBooks(){
		return hibernateTemplate.execute(new HibernateCallback(){
			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				
				System.out.println("DAO");
				String SELECT_BOOK="from Book";
				Query query = session.createQuery(SELECT_BOOK);
				List list = query.list();
				return list;
			}
		});
		
	}
	//ɾ������
	@SuppressWarnings("unchecked")
	public void deleteBook(final int id){
		hibernateTemplate.execute(new HibernateCallback(){
			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				 String hql = "delete from Book where id = ?";
				 Query query =session.createQuery(hql);
				 query.setInteger(0, id);
				 query.executeUpdate();
				return null;
			}
		});
	}
	//�����ѯ
	public Book selectBook (final int id){
		return hibernateTemplate.get(Book.class, id);
	}
	//�޸�
	public void updateBook(final Book book, final int id){
		hibernateTemplate.execute(new HibernateCallback<Book>() {
			@Override
			public Book doInHibernate(Session session) throws HibernateException {
				String hql="update Book set bookname=?,type=?,author=?,discount=?,price=?,num=?,massage=? where id=?";
				Query query =session.createQuery(hql);
				query.setString(0, book.getBookname());
				query.setString(1, book.getType());
				query.setString(2, book.getAuthor());
				query.setString(3, book.getDiscount());
				query.setDouble(4, book.getPrice());
				query.setInteger(5, book.getNum());
				query.setString(6, book.getMassage());
				query.setInteger(7, id);
				query.executeUpdate();
				return null;
			}
			
			
			
		});
		
	}
	//��ҳ��ѯ
	@SuppressWarnings("unchecked")
	public List<Book> selectBookByPage(final int currentPage,final int currentNum) {
		return hibernateTemplate.execute(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				String hql="from Book";
				Query query = session.createQuery(hql);
				query.setFirstResult((currentPage-1)*currentNum);
				query.setMaxResults(currentNum);
				List<Book> list = query.list();
				return list;
			}
			
		});
	}
	//��ѯ���е�����
    @SuppressWarnings("unchecked")
	public int findCount(){
        return hibernateTemplate.execute(new HibernateCallback() {

            @Override
            public Object doInHibernate(Session session) throws HibernateException {
                String hql = "from Book";
                Query query = session.createQuery(hql);
                int num = query.list().size();
                return num;
                
               /* Query query = session.createQuery(hql);
                int count = ((Number)query.uniqueResult()).intValue();  
                return count;*/
            }
        });
    }
	
	
	
	
	
	
	
	
	
	
}