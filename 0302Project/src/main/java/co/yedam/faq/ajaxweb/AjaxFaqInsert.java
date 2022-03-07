package co.yedam.faq.ajaxweb;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import co.yedam.common.DbCommand;
import co.yedam.faq.serviceImpl.faqServiceImpl;
import co.yedam.faq.vo.faqVO;

public class AjaxFaqInsert implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO ���옣�븯湲�
		faqServiceImpl dao = new faqServiceImpl();
		
		faqVO vo = new faqVO();
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));

		dao.insertNotice(vo);
		System.out.println(vo);
		Gson gson = new Gson();
		String str = gson.toJson(vo);
		return "ajax:"+str;
	}
}
