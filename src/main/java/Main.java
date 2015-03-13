import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;

public class Main {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
	vertx.deployVerticle("service:io.vertx:vertx-jdbc-service:3.0.0-SNAPSHOT", Main::handle);	

	// this will fail without the com.englishtown.vertx:vertx-hk2 extension (see build.gradle),
	// but not because of the service descriptor name / classpath issues in question
	// vertx.deployVerticle("service:com.englishtown.vertx:vertx-elasticsearch-service:2.0.0-SNAPSHOT", Main::handle);
    }

    public static void handle(AsyncResult<String> asyncResult) {
        if (asyncResult.succeeded()) {
	    System.out.println("SUCCESS: " + asyncResult.result());
	}
	else {
	    System.out.println("FAILURE: " + asyncResult.cause());
        }
    }
}
