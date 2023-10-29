package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "innodb_buffer_stats_by_table", schema = "sys", catalog = "")
public class InnodbBufferStatsByTableEntity {
    @Basic
    @Column(name = "object_schema")
    private String objectSchema;
    @Basic
    @Column(name = "object_name")
    private String objectName;
    @Basic
    @Column(name = "allocated")
    private String allocated;
    @Basic
    @Column(name = "data")
    private String data;
    @Basic
    @Column(name = "pages")
    private long pages;
    @Basic
    @Column(name = "pages_hashed")
    private long pagesHashed;
    @Basic
    @Column(name = "pages_old")
    private long pagesOld;
    @Basic
    @Column(name = "rows_cached")
    private Long rowsCached;

    public String getObjectSchema() {
        return objectSchema;
    }

    public void setObjectSchema(String objectSchema) {
        this.objectSchema = objectSchema;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getAllocated() {
        return allocated;
    }

    public void setAllocated(String allocated) {
        this.allocated = allocated;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public long getPages() {
        return pages;
    }

    public void setPages(long pages) {
        this.pages = pages;
    }

    public long getPagesHashed() {
        return pagesHashed;
    }

    public void setPagesHashed(long pagesHashed) {
        this.pagesHashed = pagesHashed;
    }

    public long getPagesOld() {
        return pagesOld;
    }

    public void setPagesOld(long pagesOld) {
        this.pagesOld = pagesOld;
    }

    public Long getRowsCached() {
        return rowsCached;
    }

    public void setRowsCached(Long rowsCached) {
        this.rowsCached = rowsCached;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InnodbBufferStatsByTableEntity that = (InnodbBufferStatsByTableEntity) o;

        if (pages != that.pages) return false;
        if (pagesHashed != that.pagesHashed) return false;
        if (pagesOld != that.pagesOld) return false;
        if (objectSchema != null ? !objectSchema.equals(that.objectSchema) : that.objectSchema != null) return false;
        if (objectName != null ? !objectName.equals(that.objectName) : that.objectName != null) return false;
        if (allocated != null ? !allocated.equals(that.allocated) : that.allocated != null) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (rowsCached != null ? !rowsCached.equals(that.rowsCached) : that.rowsCached != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = objectSchema != null ? objectSchema.hashCode() : 0;
        result = 31 * result + (objectName != null ? objectName.hashCode() : 0);
        result = 31 * result + (allocated != null ? allocated.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (int) (pages ^ (pages >>> 32));
        result = 31 * result + (int) (pagesHashed ^ (pagesHashed >>> 32));
        result = 31 * result + (int) (pagesOld ^ (pagesOld >>> 32));
        result = 31 * result + (rowsCached != null ? rowsCached.hashCode() : 0);
        return result;
    }
}
