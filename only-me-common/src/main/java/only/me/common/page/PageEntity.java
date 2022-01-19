package only.me.common.page;

import io.swagger.annotations.ApiModelProperty;

/**
 * @program: only-me->PageEntity
 * @description:
 * @author: szh
 * @create: 2022-01-18 16:17
 **/
public class PageEntity {
    @ApiModelProperty("当前页数")
    private long page = 1L;
    @ApiModelProperty("每页展示条数")
    private long limit = 15L;
    @ApiModelProperty(
            value = "是否分页，0:不分页 1 分页",
            allowableValues = "0,1"
    )
    private Integer pageType = 1;

    public void setPageType(Integer pageType) {
        this.pageType = pageType;
        if (pageType == 0) {
            this.limit = 10000L;
        }

    }

    public long getLimit() {
        if (this.limit > 100L && 1 == this.pageType) {
            this.limit = 100L;
        }

        return this.limit;
    }

    public PageEntity() {
    }

    public long getPage() {
        return this.page;
    }

    public Integer getPageType() {
        return this.pageType;
    }

    public void setPage(final long page) {
        this.page = page;
    }

    public void setLimit(final long limit) {
        this.limit = limit;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof PageEntity)) {
            return false;
        } else {
            PageEntity other = (PageEntity)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getPage() != other.getPage()) {
                return false;
            } else if (this.getLimit() != other.getLimit()) {
                return false;
            } else {
                Object this$pageType = this.getPageType();
                Object other$pageType = other.getPageType();
                if (this$pageType == null) {
                    if (other$pageType == null) {
                        return true;
                    }
                } else if (this$pageType.equals(other$pageType)) {
                    return true;
                }

                return false;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PageEntity;
    }

    @Override
    public int hashCode() {
        boolean PRIME = true;
        int result1 = 1;
        long $page = this.getPage();
        int result = result1 * 59 + (int)($page >>> 32 ^ $page);
        long $limit = this.getLimit();
        result = result * 59 + (int)($limit >>> 32 ^ $limit);
        Object $pageType = this.getPageType();
        result = result * 59 + ($pageType == null ? 43 : $pageType.hashCode());
        return result;
    }

    @Override
    public String toString() {
        long var10000 = this.getPage();
        return "PageEntity(page=" + var10000 + ", limit=" + this.getLimit() + ", pageType=" + this.getPageType() + ")";
    }
}
