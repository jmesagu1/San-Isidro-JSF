import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.sanisidro.entity.User;
import com.sanisidro.entity.UserType;



public class sample {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SanIsidro");
		EntityManager em = null;
		try
		{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			
			User u = em.find(User.class, new Long(1));
			
			UserType l =  em.find(UserType.class , new Long(3));
			
			u.setType(l);	
			
			em.merge(u);
			
			em.getTransaction().commit();
	
		}
		finally
		{
			if (em != null)
			{
				em.close();
			}			
		}
		

	}

}
