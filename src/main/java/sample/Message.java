package sample;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Message {
	@NotNull
	@Min(1)
	private String id;
	private String text;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}


}
