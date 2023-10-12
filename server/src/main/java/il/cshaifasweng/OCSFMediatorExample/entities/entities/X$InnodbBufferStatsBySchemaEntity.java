package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "x$innodb_buffer_stats_by_schema", schema = "sys", catalog = "")
public class X$InnodbBufferStatsBySchemaEntity {
    @Basic
    @Column(name = "object_schema")
    private String objectSchema;
    @Basic
    @Column(name = "allocated")
    private Long allocated;
    @Basic
    @Column(name = "data")
    private Long data;
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
    private long rowsCached;

    public String getObjectSchema() {
        return objectSchema;
    }

    public void setObjectSchema(String objectSchema) {
        this.objectSchema = objectSchema;
    }

    public Long getAllocated() {
        return allocated;
    }

    public void setAllocated(Long allocated) {
        this.allocated = allocated;
    }

    public Long getData() {
        return data;
    }

    public void setData(Long data) {
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

    public long getRowsCached() {
        return rowsCached;
    }

    public void setRowsCached(long rowsCached) {
        this.rowsCached = rowsCached;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        X$InnodbBufferStatsBySchemaEntity that = (X$InnodbBufferStatsBySchemaEntity) o;

        if (pages != that.pages) return false;
        if (pagesHashed != that.pagesHashed) return false;
        if (pagesOld != that.pagesOld) return false;
        if (rowsCached != that.rowsCached) return false;
        if (objectSchema != null ? !objectSchema.equals(that.objectSchema) : that.objectSchema != null) return false;
        if (allocated != null ? !allocated.equals(that.allocated) : that.allocated != null) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = objectSchema != null ? objectSchema.hashCode() : 0;
        result = 31 * result + (allocated != null ? allocated.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (int) (pages ^ (pages >>> 32));
        result = 31 * result + (int) (pagesHashed ^ (pagesHashed >>> 32));
        result = 31 * result + (int) (pagesOld ^ (pagesOld >>> 32));
        result = 31 * result + (int) (rowsCached ^ (rowsCached >>> 32));
        return result;
    }
}
