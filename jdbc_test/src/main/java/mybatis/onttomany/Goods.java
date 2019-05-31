package mybatis.onttomany;

import java.util.List;

public class Goods {

    private Integer goodsId;

    private String goodsName;

    private Integer goodsStorageNum;

    private Integer goodsScore;

    private String goodsDescription;

    private List<GoodsImg> goodsImgList;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getGoodsStorageNum() {
        return goodsStorageNum;
    }

    public void setGoodsStorageNum(Integer goodsStorageNum) {
        this.goodsStorageNum = goodsStorageNum;
    }

    public Integer getGoodsScore() {
        return goodsScore;
    }

    public void setGoodsScore(Integer goodsScore) {
        this.goodsScore = goodsScore;
    }

    public String getGoodsDescription() {
        return goodsDescription;
    }

    public void setGoodsDescription(String goodsDescription) {
        this.goodsDescription = goodsDescription;
    }

    public List<GoodsImg> getGoodsImgList() {
        return goodsImgList;
    }

    public void setGoodsImgList(List<GoodsImg> goodsImgList) {
        this.goodsImgList = goodsImgList;
    }
}
