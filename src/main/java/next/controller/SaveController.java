
// 요구사항 3 을 구현하기 위해 만든 클래스입니다.

package next.controller;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import next.dao.QuestionDao;
import next.model.Question;
import core.mvc.Controller;

public class SaveController implements Controller {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String writer = (String) request.getParameter("writer");
		String title = (String) request.getParameter("title");
		String contents = (String) request.getParameter("contents");
	
		Date date = new Date();
		
		Question q = new Question(0, writer, title, contents, date, 0);
		QuestionDao qd = new QuestionDao();
		
		qd.insert(q);
		
		return "redirect:/";
	}

}
