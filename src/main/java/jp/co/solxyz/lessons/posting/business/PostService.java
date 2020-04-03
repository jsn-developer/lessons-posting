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

	private PostDataDao dao;

	public PostService() throws Exception{
		this.dao = new PostDataDao();
	}

	public List<PostEntity> getPosts() throws Exception {

		List<PostEntity> retList = dao.getAll();
		return retList;
	}

	public Optional<PostEntity> getPost() {

		return null;
	}

	public int post(PostEntity entity) throws Exception{

		return this.dao.insert(entity);
	}


	public Optional<ImageEntity> getImage(String postId) {

		try{

			return this.dao.getImage(postId);

		} catch(NumberFormatException e) {
			return Optional.empty();
		}
	}
}
