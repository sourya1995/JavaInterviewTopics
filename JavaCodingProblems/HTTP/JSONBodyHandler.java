package JavaCodingProblems.HTTP;

import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodySubscriber;
import java.net.http.HttpResponse.BodySubscribers;
import java.net.http.HttpResponse.ResponseInfo;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

public class JSONBodyHandler<T> implements HttpResponse.BodyHandler<T> {
	
	private final Jsonb jsonb;
	private final Class<T> type;

	public JSONBodyHandler(Jsonb jsonb, Class<T> type) {
		this.jsonb = jsonb;
		this.type = type;
	}
	
	public static<T> JSONBodyHandler<T> jsonBodyHandler(Class<T> type){
		return jsonBodyHandler(JsonbBuilder.create(), type);
	}
	
	public static<T> JSONBodyHandler<T> jsonBodyHandler(Jsonb jsonb, Class<T> type){
		return JSONBodyHandler(jsonb, type);
	}



	@Override
	public BodySubscriber<T> apply(ResponseInfo responseInfo) {
		return BodySubscribers.mapping(BodySubscribers.ofByteArray(), byteArray -> this.jsonb.fromJson(new ByteArrayInputStream(byteArray), this.type));
	}

}
