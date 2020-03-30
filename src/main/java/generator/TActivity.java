package generator;

import java.io.Serializable;
import java.util.Date;

/**
 * t_activity
 * @author 
 */
public class TActivity implements Serializable {
    /**
     * 活动id
     */
    private String id;

    /**
     * 活动名称
     */
    private String name;

    /**
     * 活动状态
     */
    private Integer status;

    /**
     * 社团id
     */
    private String clubid;

    /**
     * 发起人名称
     */
    private String founder;

    /**
     * 活动图片
     */
    private String img;

    /**
     * 参与人数
     */
    private Integer scaleNum;

    /**
     * 实际人数
     */
    private Integer actualNum;

    /**
     * 开始时间
     */
    private Date openDate;

    /**
     * 结束时间
     */
    private Date closeDate;

    /**
     * 审批人（admin id）
     */
    private String approver;

    /**
     * 创建时间
     */
    private Date createAt;

    /**
     * 修改时间
     */
    private Date updateAt;

    /**
     * 活动简介
     */
    private String introduction;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getClubid() {
        return clubid;
    }

    public void setClubid(String clubid) {
        this.clubid = clubid;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getScaleNum() {
        return scaleNum;
    }

    public void setScaleNum(Integer scaleNum) {
        this.scaleNum = scaleNum;
    }

    public Integer getActualNum() {
        return actualNum;
    }

    public void setActualNum(Integer actualNum) {
        this.actualNum = actualNum;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TActivity other = (TActivity) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getClubid() == null ? other.getClubid() == null : this.getClubid().equals(other.getClubid()))
            && (this.getFounder() == null ? other.getFounder() == null : this.getFounder().equals(other.getFounder()))
            && (this.getImg() == null ? other.getImg() == null : this.getImg().equals(other.getImg()))
            && (this.getScaleNum() == null ? other.getScaleNum() == null : this.getScaleNum().equals(other.getScaleNum()))
            && (this.getActualNum() == null ? other.getActualNum() == null : this.getActualNum().equals(other.getActualNum()))
            && (this.getOpenDate() == null ? other.getOpenDate() == null : this.getOpenDate().equals(other.getOpenDate()))
            && (this.getCloseDate() == null ? other.getCloseDate() == null : this.getCloseDate().equals(other.getCloseDate()))
            && (this.getApprover() == null ? other.getApprover() == null : this.getApprover().equals(other.getApprover()))
            && (this.getCreateAt() == null ? other.getCreateAt() == null : this.getCreateAt().equals(other.getCreateAt()))
            && (this.getUpdateAt() == null ? other.getUpdateAt() == null : this.getUpdateAt().equals(other.getUpdateAt()))
            && (this.getIntroduction() == null ? other.getIntroduction() == null : this.getIntroduction().equals(other.getIntroduction()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getClubid() == null) ? 0 : getClubid().hashCode());
        result = prime * result + ((getFounder() == null) ? 0 : getFounder().hashCode());
        result = prime * result + ((getImg() == null) ? 0 : getImg().hashCode());
        result = prime * result + ((getScaleNum() == null) ? 0 : getScaleNum().hashCode());
        result = prime * result + ((getActualNum() == null) ? 0 : getActualNum().hashCode());
        result = prime * result + ((getOpenDate() == null) ? 0 : getOpenDate().hashCode());
        result = prime * result + ((getCloseDate() == null) ? 0 : getCloseDate().hashCode());
        result = prime * result + ((getApprover() == null) ? 0 : getApprover().hashCode());
        result = prime * result + ((getCreateAt() == null) ? 0 : getCreateAt().hashCode());
        result = prime * result + ((getUpdateAt() == null) ? 0 : getUpdateAt().hashCode());
        result = prime * result + ((getIntroduction() == null) ? 0 : getIntroduction().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", status=").append(status);
        sb.append(", clubid=").append(clubid);
        sb.append(", founder=").append(founder);
        sb.append(", img=").append(img);
        sb.append(", scaleNum=").append(scaleNum);
        sb.append(", actualNum=").append(actualNum);
        sb.append(", openDate=").append(openDate);
        sb.append(", closeDate=").append(closeDate);
        sb.append(", approver=").append(approver);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", introduction=").append(introduction);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}