package cn.tedu.store.vo;

import java.io.Serializable;
import java.util.Date;

public class CartVo implements Serializable{
	private static final long serialVersionUID = -1262218290206492809L;
	private Integer id;
	private Integer uid;
	private String goodsId;
	private Integer num;
	private String image;
	private String title;
	private Integer price;
	private String createdUser;
	private Date createTime;
	private String modifiedUser;
	private Date modifiedTime;
	public Integer getId() {
		return id;
	}
	public Integer getUid() {
		return uid;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public Integer getNum() {
		return num;
	}
	public String getImage() {
		return image;
	}
	public String getTitle() {
		return title;
	}
	public Integer getPrice() {
		return price;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((createdUser == null) ? 0 : createdUser.hashCode());
		result = prime * result + ((goodsId == null) ? 0 : goodsId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((modifiedTime == null) ? 0 : modifiedTime.hashCode());
		result = prime * result + ((modifiedUser == null) ? 0 : modifiedUser.hashCode());
		result = prime * result + ((num == null) ? 0 : num.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartVo other = (CartVo) obj;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (createdUser == null) {
			if (other.createdUser != null)
				return false;
		} else if (!createdUser.equals(other.createdUser))
			return false;
		if (goodsId == null) {
			if (other.goodsId != null)
				return false;
		} else if (!goodsId.equals(other.goodsId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (modifiedTime == null) {
			if (other.modifiedTime != null)
				return false;
		} else if (!modifiedTime.equals(other.modifiedTime))
			return false;
		if (modifiedUser == null) {
			if (other.modifiedUser != null)
				return false;
		} else if (!modifiedUser.equals(other.modifiedUser))
			return false;
		if (num == null) {
			if (other.num != null)
				return false;
		} else if (!num.equals(other.num))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CartVo [id=" + id + ", uid=" + uid + ", goodsId=" + goodsId + ", num=" + num + ", image=" + image
				+ ", title=" + title + ", price=" + price + ", createdUser=" + createdUser + ", createTime="
				+ createTime + ", modifiedUser=" + modifiedUser + ", modifiedTime=" + modifiedTime + "]";
	}
	

}
