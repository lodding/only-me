package only.me.common.page;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @program: only-me->BasePage
 * @description:
 * @author: szh
 * @create: 2022-01-18 16:11
 **/
public class BasePage<T> implements IPage<T> {
    private static final long serialVersionUID = 8545996863226528798L;
    private List<T> list;
    private long totalRow;
    private long pageSize;
    private long pageNumber;
    private List<OrderItem> orders;
    private boolean optimizeCountSql;
    private boolean isSearchCount;
    private Object extraData;

    public BasePage() {
        this.list = new ArrayList();
        this.totalRow = 0L;
        this.pageSize = 15L;
        this.pageNumber = 1L;
        this.orders = new ArrayList();
        this.optimizeCountSql = true;
        this.isSearchCount = true;
    }

    public BasePage(PageEntity pageEntity) {
        this.list = new ArrayList();
        this.totalRow = 0L;
        this.pageSize = 15L;
        this.pageNumber = 1L;
        this.orders = new ArrayList();
        this.optimizeCountSql = true;
        this.isSearchCount = true;
        if (pageEntity.getPage() > 1L) {
            this.pageNumber = pageEntity.getPage();
        }

        this.pageSize = pageEntity.getLimit();
        if (Objects.equals(0, pageEntity.getPageType())) {
            this.pageSize = 10000L;
        }

    }

    public BasePage(long current, long size) {
        this(current, size, 0L);
    }

    public BasePage(long current, long size, long total) {
        this(current, size, total, true);
    }

    public BasePage(long current, long size, boolean isSearchCount) {
        this(current, size, 0L, isSearchCount);
    }

    public BasePage(long current, long size, long total, boolean isSearchCount) {
        this.list = new ArrayList();
        this.totalRow = 0L;
        this.pageSize = 15L;
        this.pageNumber = 1L;
        this.orders = new ArrayList();
        this.optimizeCountSql = true;
        this.isSearchCount = true;
        if (current > 1L) {
            this.pageNumber = current;
        }

        this.pageSize = size;
        this.totalRow = total;
        this.isSearchCount = isSearchCount;
    }

    @Override
    @JsonIgnore
    public List<T> getRecords() {
        return this.list;
    }

    public List<T> getList() {
        return this.list;
    }

    public long getTotalRow() {
        return this.totalRow;
    }

    public long getTotalPage() {
        if (this.getSize() == 0L) {
            return 0L;
        } else {
            long pages = this.getTotal() / this.getSize();
            if (this.getTotal() % this.getSize() != 0L) {
                ++pages;
            }

            return pages;
        }
    }

    public long getPageSize() {
        return this.pageSize;
    }

    public long getPageNumber() {
        return this.pageNumber;
    }

    public boolean isFirstPage() {
        return this.pageNumber == 1L;
    }

    public boolean isLastPage() {
        return this.getTotal() == 0L || this.pageNumber == this.getTotalPage();
    }

    public void setPageNumber(long pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public BasePage<T> setRecords(List<T> records) {
        this.list = records;
        return this;
    }

    @Override
    @JsonIgnore
    public long getTotal() {
        return this.totalRow;
    }

    @Override
    public BasePage<T> setTotal(long total) {
        this.totalRow = total;
        return this;
    }

    @Override
    @JsonIgnore
    public long getSize() {
        return this.pageSize;
    }

    @Override
    public BasePage<T> setSize(long size) {
        this.pageSize = size;
        return this;
    }

    @Override
    @JsonIgnore
    public long getCurrent() {
        return this.pageNumber;
    }

    @Override
    public BasePage<T> setCurrent(long current) {
        this.pageNumber = current;
        return this;
    }

    public BasePage<T> addOrder(OrderItem... items) {
        this.orders.addAll(Arrays.asList(items));
        return this;
    }

    public List<OrderItem> orders() {
        return this.orders;
    }

    @Override
    public boolean optimizeCountSql() {
        return this.optimizeCountSql;
    }

    @Override
    @JsonIgnore
    public boolean isSearchCount() {
        return this.totalRow < 0L ? false : this.isSearchCount;
    }

    public void setSearchCount(boolean isSearchCount) {
        this.isSearchCount = isSearchCount;
    }

    public BasePage<T> setOptimizeCountSql(boolean optimizeCountSql) {
        this.optimizeCountSql = optimizeCountSql;
        return this;
    }

    public <R> BasePage<R> copy(Class<R> clazz) {
        return this.copy(clazz, (obj) -> {
            return BeanUtil.copyProperties(obj, clazz, new String[0]);
        });
    }

    public <R> BasePage<R> copy(Class<R> clazz, Function<? super T, ? extends R> mapper) {
        BasePage<R> basePage = new BasePage(this.getCurrent(), this.getSize(), this.getTotal(), this.isSearchCount());
        basePage.setRecords((List)this.getRecords().stream().map(mapper).collect(Collectors.toList()));
        return basePage;
    }

    @Override
    @JsonIgnore
    public long getPages() {
        return this.getTotalPage();
    }

    public Object getExtraData() {
        return this.extraData;
    }

    public void setExtraData(Object extraData) {
        this.extraData = extraData;
    }
}
