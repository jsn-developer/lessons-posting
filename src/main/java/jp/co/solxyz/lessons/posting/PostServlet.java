package jp.co.solxyz.lessons.posting;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.solxyz.lessons.posting.business.PostService;
import jp.co.solxyz.lessons.posting.entity.PostEntity;

@MultipartConfig(location = "/tmp", maxFileSize = 1048476)
public class PostServlet extends HttpServlet{
	
	private static final String PATH = "/WEB-INF/jsp/post.jsp";

	/** Serial UID */
	private static final long serialVersionUID = 4927403887972346328L;

	/** サービス */
	private PostService postService;

	public PostServlet() {
		this.postService = new PostService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher(PATH).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		var part = req.getPart("file");

		PostEntity entity = PostEntity.builder()
			.build();

		this.postService.post(entity);
		
		resp.sendRedirect("list");
	}
}
