package base;

public class TestUtilities extends BaseTest{

	// Static Sleep
	protected  void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}