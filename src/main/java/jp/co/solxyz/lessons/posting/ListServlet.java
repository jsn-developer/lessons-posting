package jp.co.solxyz.lessons.posting;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.solxyz.lessons.posting.business.PostService;

public class ListServlet extends HttpServlet {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 1265387581251395549L;

	/**
	 * 対応するJSPのパス
	 */
	private static final String PATH = "/WEB-INF/jsp/list.jsp";

	private PostService postService;

	public ListServlet() {
		this.postService = new PostService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 投稿データの取得
		var list = postService.getPosts();

		req.setAttribute("list", list);

		req.getRequestDispatcher(PATH).forward(req, resp);

	}

}
