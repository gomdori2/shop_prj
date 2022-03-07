package co.yedam.faq.ajaxweb;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.DbCommand;

public class faqClient implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		return "faq/faqClient.tiles";
	}

}
