package com.dev.todo.app.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.dev.todo.app.model.Todo;

public enum Dao {

	INSTANCE;

    public List<Todo> listTodos() {
        EntityManager em = EMFService.get().createEntityManager();
        // read the existing entries
        Query q = em.createQuery("select m from Todo m");
        List<Todo> todos = q.getResultList();
        return todos;
    }

    public void add(String userId, String summary, String description,
            String url, String status) {
        synchronized (this) {
            EntityManager em = EMFService.get().createEntityManager();
            Todo todo = new Todo(userId, summary, description, url, status);
            em.persist(todo);
            em.close();
        }
    }

    public List<Todo> getTodos(String userId) {
        EntityManager em = EMFService.get().createEntityManager();
        Query q = em
                .createQuery("select t from Todo t where status in ('Pending') and t.author = :userId");
        q.setParameter("userId", userId);
        List<Todo> todos = q.getResultList();
        return todos;
    }

    public void remove(long id) {
        EntityManager em = EMFService.get().createEntityManager();
        try {
            Todo todo = em.find(Todo.class, id);
            em.remove(todo);
        } finally {
            em.close();
        }
    }
    
    public void remove(long id, String operation) {
        EntityManager em = EMFService.get().createEntityManager();
        try {
            Todo todo = em.find(Todo.class, id);
            
            if(operation.equalsIgnoreCase("delete"))
            {
            	//em.remove(todo);
            	if(!todo.getStatus().equalsIgnoreCase("completed"))
            	{
                	todo.setStatus("Deleted");            	
                	em.persist(todo);            		
            	}
            }
            else if(operation.equalsIgnoreCase("completed"))
            {
            	if(!todo.getStatus().equalsIgnoreCase("Deleted"))
            	{
            		todo.setStatus("Completed");
            		em.persist(todo);
            	}	
            }
            /*else if()
            em.remove(todo);*/
        } finally {
            em.close();
        }
    }
    
    public List<Todo> getAllTodos(String userId) {
        EntityManager em = EMFService.get().createEntityManager();
        Query q = em
                .createQuery("select t from Todo t where t.author = :userId");
        q.setParameter("userId", userId);
        List<Todo> todos = q.getResultList();
        return todos;
    }    
}