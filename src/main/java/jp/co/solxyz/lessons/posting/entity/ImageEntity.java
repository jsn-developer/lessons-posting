package jp.co.solxyz.lessons.posting.entity;

/**
 * 画像
 * @author HISATO
 *
 */
public class ImageEntity {

    private int id;

    private byte[] image;

    private String mime;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the image
	 */
	public byte[] getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(byte[] image) {
		this.image = image;
	}

	/**
	 * @return the mime
	 */
	public String getMime() {
		return mime;
	}

	/**
	 * @param mime the mime to set
	 */
	public void setMime(String mime) {
		this.mime = mime;
	}

	/**
	 * No Args Constructor
	 */
	public ImageEntity() {
		
	}
	
	/**
	 * All Args Constructor
	 * @param id
	 * @param image
	 * @param mime
	 */
	public ImageEntity(int id, byte[] image, String mime) {
		super();
		this.id = id;
		this.image = image;
		this.mime = mime;
	}
    
}
