package jp.co.solxyz.lessons.posting.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jp.co.solxyz.lessons.posting.entity.ImageEntity;
import jp.co.solxyz.lessons.posting.entity.PostEntity;

public class PostDataDao {

	private static final String CONNECTION_STRING = "jdbc:mysql://db/posting?user=user&password=user";

	private static final String INSERT_QUERY = "insert into post (title, content, photo, mime, tags) values(?, ?, ?, ?, ?)";

	/**
	 * コンストラクタ
	 * @throws ClassNotFoundException
	 */
	public PostDataDao() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
	}

	/**
	 * 全件取得
	 * @return
	 * @throws Exception
	 */
	public List<PostEntity> getAll() throws Exception {

		List<PostEntity> list = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(CONNECTION_STRING)) {

			var st = conn.createStatement();

			var result = st.executeQuery("select * from post");

			while (result.next()) {

				list.add(PostEntity.builder()
						.id(result.getInt("id"))
						.title(result.getString("title"))
						.content(result.getString("content"))
						.tags(result.getString("tags"))
						.photo(result.getBytes("photo"))
						.build());
			}

		} catch (Exception e) {
			throw e;
		}

		return list;
	}

	public Optional<ImageEntity> getImage(String id) {

		try (Connection conn = DriverManager.getConnection(CONNECTION_STRING)) {

			var st = conn.createStatement();
			
			var result = st.executeQuery("select photo, mime from post where id = " + id);

			if(result.next()) {
				return Optional.of(
						ImageEntity.builder()
						.image(result.getBytes("photo"))
						.build());
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

		try (Connection conn = DriverManager.getConnection(CONNECTION_STRING)) {

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
