package jp.co.solxyz.lessons.posting.entity;

/**
 * 投稿
 * @author HISATO
 *
 */
public class PostEntity {

	/**
	 * ID
	 */
	private int id;

	/**
	 * タイトル
	 */
	private String title;

	/**
	 * ポスト内容
	 */
	private String content;

	/**
	 * 画像データ
	 */
	private byte[] photo;

	/**
	 * Mime/Type
	 */
	private String mime;

	/**
	 * タグ
	 */
	private String tags;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getMime() {
		return mime;
	}

	public void setMime(String mime) {
		this.mime = mime;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}
	
	/**
	 * No Args Constructor
	 */
	public PostEntity() {
		
	}

	/**
	 * All Args Constructor
	 * @param id
	 * @param title
	 * @param content
	 * @param photo
	 * @param mime
	 * @param tags
	 */
	public PostEntity(int id, String title, String content, byte[] photo, String mime, String tags) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.photo = photo;
		this.mime = mime;
		this.tags = tags;
	}

	
}
