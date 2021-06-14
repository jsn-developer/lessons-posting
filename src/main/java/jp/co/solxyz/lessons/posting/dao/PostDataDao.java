package jp.co.solxyz.lessons.posting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jp.co.solxyz.lessons.posting.entity.ImageEntity;
import jp.co.solxyz.lessons.posting.entity.PostEntity;

/**
 * 投稿内容のDAO
 * @author HISATO
 *
 */
public class PostDataDao extends AbstractDao{


	private static final String INSERT_QUERY = "insert into post (title, content, photo, mime, tags) values(?, ?, ?, ?, ?)";

	/**
	 * コンストラクタ
	 * @throws ClassNotFoundException
	 */
	public PostDataDao() throws ClassNotFoundException {
		//Class.forName("com.mysql.jdbc.Driver");
	}

	/**
	 * 全件取得
	 * @return
	 * @throws Exception
	 */
	public List<PostEntity> getAll() throws Exception {

		List<PostEntity> list = new ArrayList<>();


		try (Connection conn = getConnection()) {

			Statement st = conn.createStatement();

			ResultSet result = st.executeQuery("select * from post");

			while (result.next()) {

				list.add(new PostEntity(
						result.getInt("id"),
						result.getString("title"),
						result.getString("content"),
						result.getBytes("photo"),
						null,
						result.getString("tags")
						));
			}

		} catch (Exception e) {
			throw e;
		}

		return list;
	}

	public Optional<ImageEntity> getImage(String id) {

		try (Connection conn = getConnection()) {

			Statement st = conn.createStatement();

			ResultSet result = st.executeQuery("select photo, mime from post where id = " + id);

			if(result.next()) {
				return Optional.of(
						new ImageEntity(0,
								result.getBytes("photo"),
								null));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return Optional.empty();
	}

	/**
	 * 登録処理
	 * @param entity 保存するエンティティ情報
	 * @return 実行成功件数
	 * @throws Exception エラー
	 */
	public int insert(PostEntity entity) throws Exception {

		try (Connection conn = getConnection()) {

			conn.setAutoCommit(false);

			try (PreparedStatement ps = conn.prepareStatement(INSERT_QUERY)) {

				ps.setString(1, entity.getTitle());
				ps.setString(2, entity.getContent());

				ps.setBytes(3, entity.getPhoto());
				ps.setString(4, entity.getMime());
				ps.setString(5, entity.getTags());

				int ret = ps.executeUpdate();
				conn.commit();

				return ret;
			} catch (Exception e) {
				conn.rollback();
				throw e;
			}
		} catch(Exception e) {
			throw e;
		}

	}
}
