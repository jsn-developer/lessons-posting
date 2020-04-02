package jp.co.solxyz.lessons.posting.entity;

import lombok.Data;

@Data
public class ImageEntity {

    private int id;

    private byte[] image;

    private String mime;
}
