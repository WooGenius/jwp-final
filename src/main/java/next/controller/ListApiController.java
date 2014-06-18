// 요구사항 8을 위한 클래스 입니다.

package next.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import next.dao.QuestionDao;
import next.model.Question;

import com.google.gson.Gson;

import core.mvc.Controller;

public class ListApiController implements Controller {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		Gson gson = new Gson();
		QuestionDao questionDao = new QuestionDao();
		String responseString;
		List<Question> questions;
		
		questions = questionDao.findAll();
		
		responseString = gson.toJson(questions);
		PrintWriter out = response.getWriter();
		response.setHeader("Content-Type", "application/json; charset=UTF-8");
		out.write(responseString);
		
		return "api";
	}

}
