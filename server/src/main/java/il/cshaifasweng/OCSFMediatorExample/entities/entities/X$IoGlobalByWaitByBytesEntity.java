package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "x$io_global_by_wait_by_bytes", schema = "sys", catalog = "")
public class X$IoGlobalByWaitByBytesEntity {
    @Basic
    @Column(name = "event_name")
    private String eventName;
    @Basic
    @Column(name = "total")
    private Object total;
    @Basic
    @Column(name = "total_latency")
    private Object totalLatency;
    @Basic
    @Column(name = "min_latency")
    private Object minLatency;
    @Basic
    @Column(name = "avg_latency")
    private Object avgLatency;
    @Basic
    @Column(name = "max_latency")
    private Object maxLatency;
    @Basic
    @Column(name = "count_read")
    private Object countRead;
    @Basic
    @Column(name = "total_read")
    private long totalRead;
    @Basic
    @Column(name = "avg_read")
    private BigDecimal avgRead;
    @Basic
    @Column(name = "count_write")
    private Object countWrite;
    @Basic
    @Column(name = "total_written")
    private long totalWritten;
    @Basic
    @Column(name = "avg_written")
    private BigDecimal avgWritten;
    @Basic
    @Column(name = "total_requested")
    private long totalRequested;

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

    public Object getTotalLatency() {
        return totalLatency;
    }

    public void setTotalLatency(Object totalLatency) {
        this.totalLatency = totalLatency;
    }

    public Object getMinLatency() {
        return minLatency;
    }

    public void setMinLatency(Object minLatency) {
        this.minLatency = minLatency;
    }

    public Object getAvgLatency() {
        return avgLatency;
    }

    public void setAvgLatency(Object avgLatency) {
        this.avgLatency = avgLatency;
    }

    public Object getMaxLatency() {
        return maxLatency;
    }

    public void setMaxLatency(Object maxLatency) {
        this.maxLatency = maxLatency;
    }

    public Object getCountRead() {
        return countRead;
    }

    public void setCountRead(Object countRead) {
        this.countRead = countRead;
    }

    public long getTotalRead() {
        return totalRead;
    }

    public void setTotalRead(long totalRead) {
        this.totalRead = totalRead;
    }

    public BigDecimal getAvgRead() {
        return avgRead;
    }

    public void setAvgRead(BigDecimal avgRead) {
        this.avgRead = avgRead;
    }

    public Object getCountWrite() {
        return countWrite;
    }

    public void setCountWrite(Object countWrite) {
        this.countWrite = countWrite;
    }

    public long getTotalWritten() {
        return totalWritten;
    }

    public void setTotalWritten(long totalWritten) {
        this.totalWritten = totalWritten;
    }

    public BigDecimal getAvgWritten() {
        return avgWritten;
    }

    public void setAvgWritten(BigDecimal avgWritten) {
        this.avgWritten = avgWritten;
    }

    public long getTotalRequested() {
        return totalRequested;
    }

    public void setTotalRequested(long totalRequested) {
        this.totalRequested = totalRequested;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        X$IoGlobalByWaitByBytesEntity that = (X$IoGlobalByWaitByBytesEntity) o;

        if (totalRead != that.totalRead) return false;
        if (totalWritten != that.totalWritten) return false;
        if (totalRequested != that.totalRequested) return false;
        if (eventName != null ? !eventName.equals(that.eventName) : that.eventName != null) return false;
        if (total != null ? !total.equals(that.total) : that.total != null) return false;
        if (totalLatency != null ? !totalLatency.equals(that.totalLatency) : that.totalLatency != null) return false;
        if (minLatency != null ? !minLatency.equals(that.minLatency) : that.minLatency != null) return false;
        if (avgLatency != null ? !avgLatency.equals(that.avgLatency) : that.avgLatency != null) return false;
        if (maxLatency != null ? !maxLatency.equals(that.maxLatency) : that.maxLatency != null) return false;
        if (countRead != null ? !countRead.equals(that.countRead) : that.countRead != null) return false;
        if (avgRead != null ? !avgRead.equals(that.avgRead) : that.avgRead != null) return false;
        if (countWrite != null ? !countWrite.equals(that.countWrite) : that.countWrite != null) return false;
        if (avgWritten != null ? !avgWritten.equals(that.avgWritten) : that.avgWritten != null) return false;

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
        result = 31 * result + (int) (totalRead ^ (totalRead >>> 32));
        result = 31 * result + (avgRead != null ? avgRead.hashCode() : 0);
        result = 31 * result + (countWrite != null ? countWrite.hashCode() : 0);
        result = 31 * result + (int) (totalWritten ^ (totalWritten >>> 32));
        result = 31 * result + (avgWritten != null ? avgWritten.hashCode() : 0);
        result = 31 * result + (int) (totalRequested ^ (totalRequested >>> 32));
        return result;
    }
}
