package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "io_global_by_wait_by_bytes", schema = "sys", catalog = "")
public class IoGlobalByWaitByBytesEntity {
    @Basic
    @Column(name = "event_name")
    private String eventName;
    @Basic
    @Column(name = "total")
    private Object total;
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
    @Column(name = "count_read")
    private Object countRead;
    @Basic
    @Column(name = "total_read")
    private String totalRead;
    @Basic
    @Column(name = "avg_read")
    private String avgRead;
    @Basic
    @Column(name = "count_write")
    private Object countWrite;
    @Basic
    @Column(name = "total_written")
    private String totalWritten;
    @Basic
    @Column(name = "avg_written")
    private String avgWritten;
    @Basic
    @Column(name = "total_requested")
    private String totalRequested;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Object getTotal() {
        return total;
    }

    public void setTotal(Object total) {
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

    public Object getCountRead() {
        return countRead;
    }

    public void setCountRead(Object countRead) {
        this.countRead = countRead;
    }

    public String getTotalRead() {
        return totalRead;
    }

    public void setTotalRead(String totalRead) {
        this.totalRead = totalRead;
    }

    public String getAvgRead() {
        return avgRead;
    }

    public void setAvgRead(String avgRead) {
        this.avgRead = avgRead;
    }

    public Object getCountWrite() {
        return countWrite;
    }

    public void setCountWrite(Object countWrite) {
        this.countWrite = countWrite;
    }

    public String getTotalWritten() {
        return totalWritten;
    }

    public void setTotalWritten(String totalWritten) {
        this.totalWritten = totalWritten;
    }

    public String getAvgWritten() {
        return avgWritten;
    }

    public void setAvgWritten(String avgWritten) {
        this.avgWritten = avgWritten;
    }

    public String getTotalRequested() {
        return totalRequested;
    }

    public void setTotalRequested(String totalRequested) {
        this.totalRequested = totalRequested;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IoGlobalByWaitByBytesEntity that = (IoGlobalByWaitByBytesEntity) o;

        if (eventName != null ? !eventName.equals(that.eventName) : that.eventName != null) return false;
        if (total != null ? !total.equals(that.total) : that.total != null) return false;
        if (totalLatency != null ? !totalLatency.equals(that.totalLatency) : that.totalLatency != null) return false;
        if (minLatency != null ? !minLatency.equals(that.minLatency) : that.minLatency != null) return false;
        if (avgLatency != null ? !avgLatency.equals(that.avgLatency) : that.avgLatency != null) return false;
        if (maxLatency != null ? !maxLatency.equals(that.maxLatency) : that.maxLatency != null) return false;
        if (countRead != null ? !countRead.equals(that.countRead) : that.countRead != null) return false;
        if (totalRead != null ? !totalRead.equals(that.totalRead) : that.totalRead != null) return false;
        if (avgRead != null ? !avgRead.equals(that.avgRead) : that.avgRead != null) return false;
        if (countWrite != null ? !countWrite.equals(that.countWrite) : that.countWrite != null) return false;
        if (totalWritten != null ? !totalWritten.equals(that.totalWritten) : that.totalWritten != null) return false;
        if (avgWritten != null ? !avgWritten.equals(that.avgWritten) : that.avgWritten != null) return false;
        if (totalRequested != null ? !totalRequested.equals(that.totalRequested) : that.totalRequested != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eventName != null ? eventName.hashCode() : 0;
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (totalLatency != null ? totalLatency.hashCode() : 0);
        result = 31 * result + (minLatency != null ? minLatency.hashCode() : 0);
        result = 31 * result + (avgLatency != null ? avgLatency.hashCode() : 0);
        result = 31 * result + (maxLatency != null ? maxLatency.hashCode() : 0);
        result = 31 * result + (countRead != null ? countRead.hashCode() : 0);
        result = 31 * result + (totalRead != null ? totalRead.hashCode() : 0);
        result = 31 * result + (avgRead != null ? avgRead.hashCode() : 0);
        result = 31 * result + (countWrite != null ? countWrite.hashCode() : 0);
        result = 31 * result + (totalWritten != null ? totalWritten.hashCode() : 0);
        result = 31 * result + (avgWritten != null ? avgWritten.hashCode() : 0);
        result = 31 * result + (totalRequested != null ? totalRequested.hashCode() : 0);
        return result;
    }
}
