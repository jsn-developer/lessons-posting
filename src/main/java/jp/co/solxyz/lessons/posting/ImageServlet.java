package jp.co.solxyz.lessons.posting;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.solxyz.lessons.posting.business.PostService;
import jp.co.solxyz.lessons.posting.entity.ImageEntity;

/**
 * データベースに登録した画像の取得するサーブレット
 * @author HISATO
 *
 */
@WebServlet("/image")
public class ImageServlet extends HttpServlet{

    /**
     * Serial UID
     */
    private static final long serialVersionUID = -3454710049928692929L;

    private PostService postService;

    public ImageServlet() throws Exception {
        this.postService = new PostService();
    }

    /**
     * 画像データの取得
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    	// 画像の取得を行う
        var image = postService.getImage(req.getParameter("id")).orElseGet(() -> {
            return new ImageEntity();
        });

        resp.setContentType(image.getMime());

        resp.getOutputStream().write(image.getImage());

    }

}
