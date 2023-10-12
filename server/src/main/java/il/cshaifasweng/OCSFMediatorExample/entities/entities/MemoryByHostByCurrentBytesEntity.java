package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "memory_by_host_by_current_bytes", schema = "sys", catalog = "")
public class MemoryByHostByCurrentBytesEntity {
    @Basic
    @Column(name = "host")
    private String host;
    @Basic
    @Column(name = "current_count_used")
    private Long currentCountUsed;
    @Basic
    @Column(name = "current_allocated")
    private String currentAllocated;
    @Basic
    @Column(name = "current_avg_alloc")
    private String currentAvgAlloc;
    @Basic
    @Column(name = "current_max_alloc")
    private String currentMaxAlloc;
    @Basic
    @Column(name = "total_allocated")
    private String totalAllocated;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Long getCurrentCountUsed() {
        return currentCountUsed;
    }

    public void setCurrentCountUsed(Long currentCountUsed) {
        this.currentCountUsed = currentCountUsed;
    }

    public String getCurrentAllocated() {
        return currentAllocated;
    }

    public void setCurrentAllocated(String currentAllocated) {
        this.currentAllocated = currentAllocated;
    }

    public String getCurrentAvgAlloc() {
        return currentAvgAlloc;
    }

    public void setCurrentAvgAlloc(String currentAvgAlloc) {
        this.currentAvgAlloc = currentAvgAlloc;
    }

    public String getCurrentMaxAlloc() {
        return currentMaxAlloc;
    }

    public void setCurrentMaxAlloc(String currentMaxAlloc) {
        this.currentMaxAlloc = currentMaxAlloc;
    }

    public String getTotalAllocated() {
        return totalAllocated;
    }

    public void setTotalAllocated(String totalAllocated) {
        this.totalAllocated = totalAllocated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MemoryByHostByCurrentBytesEntity that = (MemoryByHostByCurrentBytesEntity) o;

        if (host != null ? !host.equals(that.host) : that.host != null) return false;
        if (currentCountUsed != null ? !currentCountUsed.equals(that.currentCountUsed) : that.currentCountUsed != null)
            return false;
        if (currentAllocated != null ? !currentAllocated.equals(that.currentAllocated) : that.currentAllocated != null)
            return false;
        if (currentAvgAlloc != null ? !currentAvgAlloc.equals(that.currentAvgAlloc) : that.currentAvgAlloc != null)
            return false;
        if (currentMaxAlloc != null ? !currentMaxAlloc.equals(that.currentMaxAlloc) : that.currentMaxAlloc != null)
            return false;
        if (totalAllocated != null ? !totalAllocated.equals(that.totalAllocated) : that.totalAllocated != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = host != null ? host.hashCode() : 0;
        result = 31 * result + (currentCountUsed != null ? currentCountUsed.hashCode() : 0);
        result = 31 * result + (currentAllocated != null ? currentAllocated.hashCode() : 0);
        result = 31 * result + (currentAvgAlloc != null ? currentAvgAlloc.hashCode() : 0);
        result = 31 * result + (currentMaxAlloc != null ? currentMaxAlloc.hashCode() : 0);
        result = 31 * result + (totalAllocated != null ? totalAllocated.hashCode() : 0);
        return result;
    }
}
