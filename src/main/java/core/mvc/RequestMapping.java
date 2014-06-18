package core.mvc;

import java.util.HashMap;
import java.util.Map;

import next.controller.AddAnswerController;
import next.controller.ListApiController;
import next.controller.ListController;
import next.controller.SaveController;
import next.controller.ShowController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestMapping {
	private static final Logger logger = LoggerFactory.getLogger(FrontController.class);
	private Map<String, Controller> mappings = new HashMap<String, Controller>();
	
	public void initMapping() {
		mappings.put("/list.next", new ListController());
		mappings.put("/show.next", new ShowController());
		
		// 요구사항 3
		mappings.put("/save.next", new SaveController());
		// 요구사항 3
		
		// 요구사항 5
		mappings.put("/api/addanswer.next", new AddAnswerController());
		// 요구사항 5
		
		// 요구사항 8
		mappings.put("/api/list.next", new ListApiController());
		// 요구사항 8
		
		mappings.put("/form.next", new ForwardController("form.jsp"));
		
		logger.info("Initialized Mapping Completed!");
	}

	public Controller findController(String url) {
		return mappings.get(url);
	}

	void put(String url, Controller controller) {
		mappings.put(url, controller);
	}

}
