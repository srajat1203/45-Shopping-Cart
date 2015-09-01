
import javax.persistence.EntityManager;
import customTools.DBUtil;

public class Basic {
	public static void main(String[] args) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
			model.Pdetail cust = em.find(model.Pdetail.class, (long)2);
			System.out.println(cust.getGenre());
		} catch (Exception e){
			System.out.println(e);
		} finally {
			em.close();
			System.out.println("cerrado!");
		}
	}
}
