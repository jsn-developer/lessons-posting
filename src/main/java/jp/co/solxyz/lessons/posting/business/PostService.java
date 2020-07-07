package jp.co.solxyz.lessons.posting.business;

import java.util.List;
import java.util.Optional;

import jp.co.solxyz.lessons.posting.dao.PostDataDao;
import jp.co.solxyz.lessons.posting.entity.ImageEntity;
import jp.co.solxyz.lessons.posting.entity.PostEntity;


/**
 * 投稿に関するサービス
 * @author HISATO
 *
 */
public class PostService {

	/**
	 * DAO
	 */
	private PostDataDao dao;

	/**
	 * コンストラクタ
	 * @throws Exception
	 */
	public PostService() throws Exception{
		this.dao = new PostDataDao();
	}

	/**
	 * 一覧を取得
	 * @return 一覧
	 * @throws Exception
	 */
	public List<PostEntity> getPosts() throws Exception {

		List<PostEntity> retList = dao.getAll();
		return retList;
	}

	/**
	 * 単票を取得
	 * @return
	 */
	public Optional<PostEntity> getPost() {

		return null;
	}

	/**
	 * 登録
	 * @param entity 登録対象
	 * @return 成功件数
	 * @throws Exception
	 */
	public int post(PostEntity entity) throws Exception{

		return this.dao.insert(entity);
	}


	/**
	 * 画像の取得
	 * @param postId 画像ID
	 * @return
	 */
	public Optional<ImageEntity> getImage(String postId) {

		try{

			return this.dao.getImage(postId);

		} catch(NumberFormatException e) {
			return Optional.empty();
		}
	}
}
