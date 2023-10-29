package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "x$io_global_by_file_by_latency", schema = "sys", catalog = "")
public class X$IoGlobalByFileByLatencyEntity {
    @Basic
    @Column(name = "file")
    private String file;
    @Basic
    @Column(name = "total")
    private Object total;
    @Basic
    @Column(name = "total_latency")
    private Object totalLatency;
    @Basic
    @Column(name = "count_read")
    private Object countRead;
    @Basic
    @Column(name = "read_latency")
    private Object readLatency;
    @Basic
    @Column(name = "count_write")
    private Object countWrite;
    @Basic
    @Column(name = "write_latency")
    private Object writeLatency;
    @Basic
    @Column(name = "count_misc")
    private Object countMisc;
    @Basic
    @Column(name = "misc_latency")
    private Object miscLatency;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
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

    public Object getCountRead() {
        return countRead;
    }

    public void setCountRead(Object countRead) {
        this.countRead = countRead;
    }

    public Object getReadLatency() {
        return readLatency;
    }

    public void setReadLatency(Object readLatency) {
        this.readLatency = readLatency;
    }

    public Object getCountWrite() {
        return countWrite;
    }

    public void setCountWrite(Object countWrite) {
        this.countWrite = countWrite;
    }

    public Object getWriteLatency() {
        return writeLatency;
    }

    public void setWriteLatency(Object writeLatency) {
        this.writeLatency = writeLatency;
    }

    public Object getCountMisc() {
        return countMisc;
    }

    public void setCountMisc(Object countMisc) {
        this.countMisc = countMisc;
    }

    public Object getMiscLatency() {
        return miscLatency;
    }

    public void setMiscLatency(Object miscLatency) {
        this.miscLatency = miscLatency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        X$IoGlobalByFileByLatencyEntity that = (X$IoGlobalByFileByLatencyEntity) o;

        if (file != null ? !file.equals(that.file) : that.file != null) return false;
        if (total != null ? !total.equals(that.total) : that.total != null) return false;
        if (totalLatency != null ? !totalLatency.equals(that.totalLatency) : that.totalLatency != null) return false;
        if (countRead != null ? !countRead.equals(that.countRead) : that.countRead != null) return false;
        if (readLatency != null ? !readLatency.equals(that.readLatency) : that.readLatency != null) return false;
        if (countWrite != null ? !countWrite.equals(that.countWrite) : that.countWrite != null) return false;
        if (writeLatency != null ? !writeLatency.equals(that.writeLatency) : that.writeLatency != null) return false;
        if (countMisc != null ? !countMisc.equals(that.countMisc) : that.countMisc != null) return false;
        if (miscLatency != null ? !miscLatency.equals(that.miscLatency) : that.miscLatency != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = file != null ? file.hashCode() : 0;
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (totalLatency != null ? totalLatency.hashCode() : 0);
        result = 31 * result + (countRead != null ? countRead.hashCode() : 0);
        result = 31 * result + (readLatency != null ? readLatency.hashCode() : 0);
        result = 31 * result + (countWrite != null ? countWrite.hashCode() : 0);
        result = 31 * result + (writeLatency != null ? writeLatency.hashCode() : 0);
        result = 31 * result + (countMisc != null ? countMisc.hashCode() : 0);
        result = 31 * result + (miscLatency != null ? miscLatency.hashCode() : 0);
        return result;
    }
}
