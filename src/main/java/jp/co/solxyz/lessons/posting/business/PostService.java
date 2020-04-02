package jp.co.solxyz.lessons.posting.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jp.co.solxyz.lessons.posting.entity.ImageEntity;
import jp.co.solxyz.lessons.posting.entity.PostEntity;


/**
 * 投稿に関するサービス
 * @author HISATO
 *
 */
public class PostService {


	public List<PostEntity> getPosts() {

		List<PostEntity> retList = new ArrayList<PostEntity>();

		return retList;
	}

	public Optional<PostEntity> getPost() {

		return null;
	}

	public int post(PostEntity entity) {

		return 0;
	} 

	public Optional<ImageEntity> getImage(String postId) {

		try{
			int id = Integer.parseInt(postId);

			return Optional.of(null);

		} catch(NumberFormatException e) {
			return Optional.empty();
		}
	}
}
