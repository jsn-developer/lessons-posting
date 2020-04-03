package jp.co.solxyz.lessons.posting.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImageEntity {


    private int id;

    private byte[] image;

    private String mime;
}
