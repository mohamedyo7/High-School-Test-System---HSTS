package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "io_global_by_file_by_bytes", schema = "sys", catalog = "")
public class IoGlobalByFileByBytesEntity {
    @Basic
    @Column(name = "file")
    private String file;
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
    @Column(name = "avg_write")
    private String avgWrite;
    @Basic
    @Column(name = "total")
    private String total;
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

    public String getAvgWrite() {
        return avgWrite;
    }

    public void setAvgWrite(String avgWrite) {
        this.avgWrite = avgWrite;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
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

        IoGlobalByFileByBytesEntity that = (IoGlobalByFileByBytesEntity) o;

        if (file != null ? !file.equals(that.file) : that.file != null) return false;
        if (countRead != null ? !countRead.equals(that.countRead) : that.countRead != null) return false;
        if (totalRead != null ? !totalRead.equals(that.totalRead) : that.totalRead != null) return false;
        if (avgRead != null ? !avgRead.equals(that.avgRead) : that.avgRead != null) return false;
        if (countWrite != null ? !countWrite.equals(that.countWrite) : that.countWrite != null) return false;
        if (totalWritten != null ? !totalWritten.equals(that.totalWritten) : that.totalWritten != null) return false;
        if (avgWrite != null ? !avgWrite.equals(that.avgWrite) : that.avgWrite != null) return false;
        if (total != null ? !total.equals(that.total) : that.total != null) return false;
        if (writePct != null ? !writePct.equals(that.writePct) : that.writePct != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = file != null ? file.hashCode() : 0;
        result = 31 * result + (countRead != null ? countRead.hashCode() : 0);
        result = 31 * result + (totalRead != null ? totalRead.hashCode() : 0);
        result = 31 * result + (avgRead != null ? avgRead.hashCode() : 0);
        result = 31 * result + (countWrite != null ? countWrite.hashCode() : 0);
        result = 31 * result + (totalWritten != null ? totalWritten.hashCode() : 0);
        result = 31 * result + (avgWrite != null ? avgWrite.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (writePct != null ? writePct.hashCode() : 0);
        return result;
    }
}
