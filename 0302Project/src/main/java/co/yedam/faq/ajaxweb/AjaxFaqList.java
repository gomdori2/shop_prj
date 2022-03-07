package co.yedam.faq.ajaxweb;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import co.yedam.common.DbCommand;
import co.yedam.faq.serviceImpl.faqServiceImpl;
import co.yedam.faq.vo.faqVO;

public class AjaxFaqList implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		faqServiceImpl dao = new faqServiceImpl();
		List<faqVO> list = dao.noticeSelectList();
		Gson gson = new Gson();
		String str = gson.toJson(list);
		return "ajax:"+str;
	}
}
