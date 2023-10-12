package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "io_global_by_wait_by_latency", schema = "sys", catalog = "")
public class IoGlobalByWaitByLatencyEntity {
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
    @Column(name = "avg_latency")
    private String avgLatency;
    @Basic
    @Column(name = "max_latency")
    private String maxLatency;
    @Basic
    @Column(name = "read_latency")
    private String readLatency;
    @Basic
    @Column(name = "write_latency")
    private String writeLatency;
    @Basic
    @Column(name = "misc_latency")
    private String miscLatency;
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

    public String getReadLatency() {
        return readLatency;
    }

    public void setReadLatency(String readLatency) {
        this.readLatency = readLatency;
    }

    public String getWriteLatency() {
        return writeLatency;
    }

    public void setWriteLatency(String writeLatency) {
        this.writeLatency = writeLatency;
    }

    public String getMiscLatency() {
        return miscLatency;
    }

    public void setMiscLatency(String miscLatency) {
        this.miscLatency = miscLatency;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IoGlobalByWaitByLatencyEntity that = (IoGlobalByWaitByLatencyEntity) o;

        if (eventName != null ? !eventName.equals(that.eventName) : that.eventName != null) return false;
        if (total != null ? !total.equals(that.total) : that.total != null) return false;
        if (totalLatency != null ? !totalLatency.equals(that.totalLatency) : that.totalLatency != null) return false;
        if (avgLatency != null ? !avgLatency.equals(that.avgLatency) : that.avgLatency != null) return false;
        if (maxLatency != null ? !maxLatency.equals(that.maxLatency) : that.maxLatency != null) return false;
        if (readLatency != null ? !readLatency.equals(that.readLatency) : that.readLatency != null) return false;
        if (writeLatency != null ? !writeLatency.equals(that.writeLatency) : that.writeLatency != null) return false;
        if (miscLatency != null ? !miscLatency.equals(that.miscLatency) : that.miscLatency != null) return false;
        if (countRead != null ? !countRead.equals(that.countRead) : that.countRead != null) return false;
        if (totalRead != null ? !totalRead.equals(that.totalRead) : that.totalRead != null) return false;
        if (avgRead != null ? !avgRead.equals(that.avgRead) : that.avgRead != null) return false;
        if (countWrite != null ? !countWrite.equals(that.countWrite) : that.countWrite != null) return false;
        if (totalWritten != null ? !totalWritten.equals(that.totalWritten) : that.totalWritten != null) return false;
        if (avgWritten != null ? !avgWritten.equals(that.avgWritten) : that.avgWritten != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eventName != null ? eventName.hashCode() : 0;
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (totalLatency != null ? totalLatency.hashCode() : 0);
        result = 31 * result + (avgLatency != null ? avgLatency.hashCode() : 0);
        result = 31 * result + (maxLatency != null ? maxLatency.hashCode() : 0);
        result = 31 * result + (readLatency != null ? readLatency.hashCode() : 0);
        result = 31 * result + (writeLatency != null ? writeLatency.hashCode() : 0);
        result = 31 * result + (miscLatency != null ? miscLatency.hashCode() : 0);
        result = 31 * result + (countRead != null ? countRead.hashCode() : 0);
        result = 31 * result + (totalRead != null ? totalRead.hashCode() : 0);
        result = 31 * result + (avgRead != null ? avgRead.hashCode() : 0);
        result = 31 * result + (countWrite != null ? countWrite.hashCode() : 0);
        result = 31 * result + (totalWritten != null ? totalWritten.hashCode() : 0);
        result = 31 * result + (avgWritten != null ? avgWritten.hashCode() : 0);
        return result;
    }
}
