import java.io.IOException;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;

// Add Javadoc ..

public class Controller {

	static Boolean loggedIn = true;
	
	public static void main(String[] args) {
		
		try {
			HttpServer server = HttpServer.create(new InetSocketAddress(8005), 0);
			
			server.createContext("/process", new InsertDatabaseHandler()); //post information
			
			server.createContext("/show", new ShowHandler()); //debuggging
			
			server.createContext("/Delete", new DeleteHandler());
			
			server.createContext("/Process-Update", new UpdateDatabaseHandler());
			
			server.createContext("/get-all", new GetHandler());
			
			server.createContext("/", new HomeHandler());
			
				@Override
				public void handle(HttpExchange he) throws IOException {
					
				}
			

			// start the server
			server.setExecutor(null);
			server.start();
			System.out.println("Server running on port 8005");

		} catch (IOException e) {			
			e.printStackTrace();
		}
	}

}
