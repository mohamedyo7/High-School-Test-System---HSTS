package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "x$io_global_by_file_by_bytes", schema = "sys", catalog = "")
public class X$IoGlobalByFileByBytesEntity {
    @Basic
    @Column(name = "file")
    private String file;
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
    @Column(name = "avg_write")
    private BigDecimal avgWrite;
    @Basic
    @Column(name = "total")
    private long total;
    @Basic
    @Column(name = "write_pct")
    private BigDecimal writePct;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
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

    public BigDecimal getAvgWrite() {
        return avgWrite;
    }

    public void setAvgWrite(BigDecimal avgWrite) {
        this.avgWrite = avgWrite;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public BigDecimal getWritePct() {
        return writePct;
    }

    public void setWritePct(BigDecimal writePct) {
        this.writePct = writePct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        X$IoGlobalByFileByBytesEntity that = (X$IoGlobalByFileByBytesEntity) o;

        if (totalRead != that.totalRead) return false;
        if (totalWritten != that.totalWritten) return false;
        if (total != that.total) return false;
        if (file != null ? !file.equals(that.file) : that.file != null) return false;
        if (countRead != null ? !countRead.equals(that.countRead) : that.countRead != null) return false;
        if (avgRead != null ? !avgRead.equals(that.avgRead) : that.avgRead != null) return false;
        if (countWrite != null ? !countWrite.equals(that.countWrite) : that.countWrite != null) return false;
        if (avgWrite != null ? !avgWrite.equals(that.avgWrite) : that.avgWrite != null) return false;
        if (writePct != null ? !writePct.equals(that.writePct) : that.writePct != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = file != null ? file.hashCode() : 0;
        result = 31 * result + (countRead != null ? countRead.hashCode() : 0);
        result = 31 * result + (int) (totalRead ^ (totalRead >>> 32));
        result = 31 * result + (avgRead != null ? avgRead.hashCode() : 0);
        result = 31 * result + (countWrite != null ? countWrite.hashCode() : 0);
        result = 31 * result + (int) (totalWritten ^ (totalWritten >>> 32));
        result = 31 * result + (avgWrite != null ? avgWrite.hashCode() : 0);
        result = 31 * result + (int) (total ^ (total >>> 32));
        result = 31 * result + (writePct != null ? writePct.hashCode() : 0);
        return result;
    }
}
