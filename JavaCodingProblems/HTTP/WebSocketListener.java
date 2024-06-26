package JavaCodingProblems.HTTP;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.net.http.WebSocket.Listener;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class WebSocketListener implements Listener {

	@Override
	public void onOpen(WebSocket webSocket) {
		System.out.println("Connection is open");
		Listener.super.onOpen(webSocket);
	}

	@Override
	public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
		System.out.println("Received data: " + data);
		return Listener.super.onText(webSocket, data, last);
	}

	@Override
	public CompletionStage<?> onClose(WebSocket webSocket, int statusCode, String reason) {
		System.out.println("Closing connection: " + statusCode + " " + reason);
		return Listener.super.onClose(webSocket, statusCode, reason);
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		WebSocketListener listener = new WebSocketListener();
		
		 HttpClient client = HttpClient.newHttpClient();

	        WebSocket webSocket = client.newWebSocketBuilder()
	                .buildAsync(URI.create("ws://stream.meetup.com/2/rsvps"), listener)
	                .get(10, TimeUnit.SECONDS);
	        
//	        webSocket.sendText("I am an Meetup RSVP fan", true);
	        
	        TimeUnit.SECONDS.sleep(10);
	        webSocket.sendClose(WebSocket.NORMAL_CLOSURE, "ok");
	}
	
	
	
}
