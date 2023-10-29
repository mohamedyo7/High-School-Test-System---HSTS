package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "x$memory_global_total", schema = "sys", catalog = "")
public class X$MemoryGlobalTotalEntity {
    @Basic
    @Column(name = "total_allocated")
    private Long totalAllocated;

    public Long getTotalAllocated() {
        return totalAllocated;
    }

    public void setTotalAllocated(Long totalAllocated) {
        this.totalAllocated = totalAllocated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        X$MemoryGlobalTotalEntity that = (X$MemoryGlobalTotalEntity) o;

        if (totalAllocated != null ? !totalAllocated.equals(that.totalAllocated) : that.totalAllocated != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return totalAllocated != null ? totalAllocated.hashCode() : 0;
    }
}
