package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "io_by_thread_by_latency", schema = "sys", catalog = "")
public class IoByThreadByLatencyEntity {
    @Basic
    @Column(name = "user")
    private String user;
    @Basic
    @Column(name = "total")
    private Long total;
    @Basic
    @Column(name = "total_latency")
    private String totalLatency;
    @Basic
    @Column(name = "min_latency")
    private String minLatency;
    @Basic
    @Column(name = "avg_latency")
    private String avgLatency;
    @Basic
    @Column(name = "max_latency")
    private String maxLatency;
    @Basic
    @Column(name = "thread_id")
    private Object threadId;
    @Basic
    @Column(name = "processlist_id")
    private Object processlistId;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public String getTotalLatency() {
        return totalLatency;
    }

    public void setTotalLatency(String totalLatency) {
        this.totalLatency = totalLatency;
    }

    public String getMinLatency() {
        return minLatency;
    }

    public void setMinLatency(String minLatency) {
        this.minLatency = minLatency;
    }

    public String getAvgLatency() {
        return avgLatency;
    }

    public void setAvgLatency(String avgLatency) {
        this.avgLatency = avgLatency;
    }

    public String getMaxLatency() {
        return maxLatency;
    }

    public void setMaxLatency(String maxLatency) {
        this.maxLatency = maxLatency;
    }

    public Object getThreadId() {
        return threadId;
    }

    public void setThreadId(Object threadId) {
        this.threadId = threadId;
    }

    public Object getProcesslistId() {
        return processlistId;
    }

    public void setProcesslistId(Object processlistId) {
        this.processlistId = processlistId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IoByThreadByLatencyEntity that = (IoByThreadByLatencyEntity) o;

        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (total != null ? !total.equals(that.total) : that.total != null) return false;
        if (totalLatency != null ? !totalLatency.equals(that.totalLatency) : that.totalLatency != null) return false;
        if (minLatency != null ? !minLatency.equals(that.minLatency) : that.minLatency != null) return false;
        if (avgLatency != null ? !avgLatency.equals(that.avgLatency) : that.avgLatency != null) return false;
        if (maxLatency != null ? !maxLatency.equals(that.maxLatency) : that.maxLatency != null) return false;
        if (threadId != null ? !threadId.equals(that.threadId) : that.threadId != null) return false;
        if (processlistId != null ? !processlistId.equals(that.processlistId) : that.processlistId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (totalLatency != null ? totalLatency.hashCode() : 0);
        result = 31 * result + (minLatency != null ? minLatency.hashCode() : 0);
        result = 31 * result + (avgLatency != null ? avgLatency.hashCode() : 0);
        result = 31 * result + (maxLatency != null ? maxLatency.hashCode() : 0);
        result = 31 * result + (threadId != null ? threadId.hashCode() : 0);
        result = 31 * result + (processlistId != null ? processlistId.hashCode() : 0);
        return result;
    }
}
