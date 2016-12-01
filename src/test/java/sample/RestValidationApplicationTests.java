package sample;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RestValidationApplicationTests {
	@Autowired
	MockMvc mockMvc;
	@Autowired
	ObjectMapper mapper;

	@Test
	public void success() throws Exception {
		Message m = new Message();
		m.setId("1");
		m.setText("Foo bar");
		mockMvc.perform(createMessage(m))
			.andExpect(status().isOk());
	}

	@Test
	public void missingId() throws Exception {
		Message m = new Message();
		m.setText("Foo bar");
		mockMvc.perform(createMessage(m))
			.andExpect(status().isBadRequest())
			.andDo(print());
	}

	private MockHttpServletRequestBuilder createMessage(Message m) throws Exception {
		return post("/message")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(m));
	}


}
