package classes;

public class Main {

	public static void main(String[] args) {
		User user=new User("alina","12");
		IAccount account = new SafeProxyAccount(user);
		
		account.reserve();

	}

}
