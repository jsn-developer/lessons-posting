<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>投稿</title>
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <link rel="stylesheet" href="./css/app.css">
    <script src="./js/jquery-3.4.1.min.js"></script>
    <script src="./js/bootstrap.bundle.js"></script>
</head>
<body>
    <nav class="navbar fixed-top navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">投稿一覧</a>
    </nav>
    <form id="myForm" action="post" method="post" enctype="multipart/form-data">
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-md-3 offset-md-1">
                    写真
                </div>
                <div class="col-xs-12 col-md-7">
                    <input type="file" id="photo" name="photo"><br>
                    <img src="./img/noimage.jpg" alt="プレビュー" id="preview">
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12 col-md-3 offset-md-1">
                    コメント
                </div>
                <div class="col-xs-12 col-md-7">
                    <textarea name="content" id="content" class="form-control"></textarea>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12 col-md-12 center">
                    <input type="submit" value="投稿" class="btn btn-success">
                </div>
            </div>
        </div>
    </form>
<script>

$(function(){
	// 写真が選択されたら画像の内容を表示する
    $("#photo").on("change", function(e) {

        e.stopPropagation();
        e.preventDefault();

        if (!!$(this).val()) {
            let img = $(this).prop('files')[0];

            if (!/\.(jpg|jpeg|png|gif|JPG|JPEG|PNG|GIF)$/.test(img.name)
                     || !/(jpg|jpeg|png|gif)$/.test(img.type)) {
                alert('JPG、GIF、PNGファイルの画像を添付してください。');

            } else if (1048576 < img.size) {
                alert('1MB以下の画像を添付してください。');
            } else {
                //window.FileReaderに対応しているブラウザどうか
                if (window.FileReader) {
                    //FileReaderをインスタンス化
                    var reader = new FileReader();
                    //添付ファイルの読み込みが成功したときに実行されるイベント（成功時のみ）
                    //一旦飛ばしてreader .readAsDataURLが先に動く
                    reader.onload = function() {
                        //Data URI Schemeをimgタグのsrcにいれてリアルタイムに添付画像を描画する
                        $('#preview').attr('src', reader.result);
                    }
                    //Data URI Schemeを取得する
                    reader.readAsDataURL(img);
                } else {
                    // プレビュー不可能
                }
                return false;
            }
        }
    });

    // refere to https://qiita.com/espeon196/items/3e50733ed8ca9d3c93f4

    // 画像が選択されていなかったら送信できなくする
    $("#myForm").submit(function(){
    	if (!$("#photo").val()) {
			// ファイルが選択されていない場合
			alert("画像を選択してください。");
			// return falseとすることでsubmitをキャンセルできる
			return false;
    	}
    });

});

</script>
</body>
</html>
