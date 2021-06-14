package jp.co.solxyz.lessons.posting;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import jp.co.solxyz.lessons.posting.business.PostService;
import jp.co.solxyz.lessons.posting.entity.PostEntity;

/**
 * 登録のサーブレット
 * @author HISATO
 *
 */
@WebServlet("/post")
//MultipartConfigを設定すると、一時的にアップロードする場所を指定できる
@MultipartConfig(location = "C:\\tmp", maxFileSize = 1048476)
public class PostServlet extends HttpServlet {

	private static final String PATH = "/WEB-INF/jsp/post.jsp";

	/** Serial UID */
	private static final long serialVersionUID = 4927403887972346328L;

	/** サービス */
	private PostService postService;

	public PostServlet() throws Exception {
		this.postService = new PostService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher(PATH).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		// ファイルの送信にはMultipartという手法を利用して送信する必要がある。
		Part part = req.getPart("photo");
		byte[] photoBytes = part.getInputStream().readAllBytes();
		String filename = getNameBy(part).orElse("empty name");

		String content = req.getParameter("content");

		PostEntity entity = new PostEntity();
		entity.setTitle(filename);
		entity.setContent(content);
		entity.setPhoto(photoBytes);

		try {
			int result = this.postService.post(entity);
			System.out.println("Result is "  + result);
		} catch (Exception e) {
			e.printStackTrace();
			//TODO redirect to error page.
		}

		resp.sendRedirect("list");
	}

	/**
	 * Part情報からファイル名を取得
	 * @param part
	 * @return
	 */
	private Optional<String> getNameBy(Part part) {
		return Optional.of(part.getSubmittedFileName());
	}
}
