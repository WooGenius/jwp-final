// 요구사항 5를 위해 구현한 클래스 입니다.
package next.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import next.dao.AnswerDao;
import next.dao.QuestionDao;
import next.model.Answer;
import core.mvc.Controller;

public class AddAnswerController implements Controller {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		long questionId = Long.parseLong((String) request.getParameter("questionId"));
		String writer = (String) request.getParameter("writer");
		String contents = (String) request.getParameter("contents");
		Date date = new Date();
		
		Answer a = new Answer(writer, contents, questionId);
		AnswerDao ad = new AnswerDao();
		ad.insert(a);
		
		QuestionDao qd = new QuestionDao();
		qd.addCommentCount(questionId);
		
		
		return "api";
	}

}
