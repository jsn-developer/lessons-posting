package jp.co.solxyz.lessons.posting.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
	 * タグ
	 */
	private String tags;

}
