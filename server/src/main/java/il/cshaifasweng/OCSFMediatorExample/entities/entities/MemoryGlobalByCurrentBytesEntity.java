package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "memory_global_by_current_bytes", schema = "sys", catalog = "")
public class MemoryGlobalByCurrentBytesEntity {
    @Basic
    @Column(name = "event_name")
    private String eventName;
    @Basic
    @Column(name = "current_count")
    private long currentCount;
    @Basic
    @Column(name = "current_alloc")
    private String currentAlloc;
    @Basic
    @Column(name = "current_avg_alloc")
    private String currentAvgAlloc;
    @Basic
    @Column(name = "high_count")
    private long highCount;
    @Basic
    @Column(name = "high_alloc")
    private String highAlloc;
    @Basic
    @Column(name = "high_avg_alloc")
    private String highAvgAlloc;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public long getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(long currentCount) {
        this.currentCount = currentCount;
    }

    public String getCurrentAlloc() {
        return currentAlloc;
    }

    public void setCurrentAlloc(String currentAlloc) {
        this.currentAlloc = currentAlloc;
    }

    public String getCurrentAvgAlloc() {
        return currentAvgAlloc;
    }

    public void setCurrentAvgAlloc(String currentAvgAlloc) {
        this.currentAvgAlloc = currentAvgAlloc;
    }

    public long getHighCount() {
        return highCount;
    }

    public void setHighCount(long highCount) {
        this.highCount = highCount;
    }

    public String getHighAlloc() {
        return highAlloc;
    }

    public void setHighAlloc(String highAlloc) {
        this.highAlloc = highAlloc;
    }

    public String getHighAvgAlloc() {
        return highAvgAlloc;
    }

    public void setHighAvgAlloc(String highAvgAlloc) {
        this.highAvgAlloc = highAvgAlloc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MemoryGlobalByCurrentBytesEntity that = (MemoryGlobalByCurrentBytesEntity) o;

        if (currentCount != that.currentCount) return false;
        if (highCount != that.highCount) return false;
        if (eventName != null ? !eventName.equals(that.eventName) : that.eventName != null) return false;
        if (currentAlloc != null ? !currentAlloc.equals(that.currentAlloc) : that.currentAlloc != null) return false;
        if (currentAvgAlloc != null ? !currentAvgAlloc.equals(that.currentAvgAlloc) : that.currentAvgAlloc != null)
            return false;
        if (highAlloc != null ? !highAlloc.equals(that.highAlloc) : that.highAlloc != null) return false;
        if (highAvgAlloc != null ? !highAvgAlloc.equals(that.highAvgAlloc) : that.highAvgAlloc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eventName != null ? eventName.hashCode() : 0;
        result = 31 * result + (int) (currentCount ^ (currentCount >>> 32));
        result = 31 * result + (currentAlloc != null ? currentAlloc.hashCode() : 0);
        result = 31 * result + (currentAvgAlloc != null ? currentAvgAlloc.hashCode() : 0);
        result = 31 * result + (int) (highCount ^ (highCount >>> 32));
        result = 31 * result + (highAlloc != null ? highAlloc.hashCode() : 0);
        result = 31 * result + (highAvgAlloc != null ? highAvgAlloc.hashCode() : 0);
        return result;
    }
}
