package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "x$host_summary_by_statement_latency", schema = "sys", catalog = "")
public class X$HostSummaryByStatementLatencyEntity {
    @Basic
    @Column(name = "host")
    private String host;
    @Basic
    @Column(name = "total")
    private Long total;
    @Basic
    @Column(name = "total_latency")
    private Long totalLatency;
    @Basic
    @Column(name = "max_latency")
    private Object maxLatency;
    @Basic
    @Column(name = "lock_latency")
    private Long lockLatency;
    @Basic
    @Column(name = "cpu_latency")
    private Long cpuLatency;
    @Basic
    @Column(name = "rows_sent")
    private Long rowsSent;
    @Basic
    @Column(name = "rows_examined")
    private Long rowsExamined;
    @Basic
    @Column(name = "rows_affected")
    private Long rowsAffected;
    @Basic
    @Column(name = "full_scans")
    private Long fullScans;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getTotalLatency() {
        return totalLatency;
    }

    public void setTotalLatency(Long totalLatency) {
        this.totalLatency = totalLatency;
    }

    public Object getMaxLatency() {
        return maxLatency;
    }

    public void setMaxLatency(Object maxLatency) {
        this.maxLatency = maxLatency;
    }

    public Long getLockLatency() {
        return lockLatency;
    }

    public void setLockLatency(Long lockLatency) {
        this.lockLatency = lockLatency;
    }

    public Long getCpuLatency() {
        return cpuLatency;
    }

    public void setCpuLatency(Long cpuLatency) {
        this.cpuLatency = cpuLatency;
    }

    public Long getRowsSent() {
        return rowsSent;
    }

    public void setRowsSent(Long rowsSent) {
        this.rowsSent = rowsSent;
    }

    public Long getRowsExamined() {
        return rowsExamined;
    }

    public void setRowsExamined(Long rowsExamined) {
        this.rowsExamined = rowsExamined;
    }

    public Long getRowsAffected() {
        return rowsAffected;
    }

    public void setRowsAffected(Long rowsAffected) {
        this.rowsAffected = rowsAffected;
    }

    public Long getFullScans() {
        return fullScans;
    }

    public void setFullScans(Long fullScans) {
        this.fullScans = fullScans;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        X$HostSummaryByStatementLatencyEntity that = (X$HostSummaryByStatementLatencyEntity) o;

        if (host != null ? !host.equals(that.host) : that.host != null) return false;
        if (total != null ? !total.equals(that.total) : that.total != null) return false;
        if (totalLatency != null ? !totalLatency.equals(that.totalLatency) : that.totalLatency != null) return false;
        if (maxLatency != null ? !maxLatency.equals(that.maxLatency) : that.maxLatency != null) return false;
        if (lockLatency != null ? !lockLatency.equals(that.lockLatency) : that.lockLatency != null) return false;
        if (cpuLatency != null ? !cpuLatency.equals(that.cpuLatency) : that.cpuLatency != null) return false;
        if (rowsSent != null ? !rowsSent.equals(that.rowsSent) : that.rowsSent != null) return false;
        if (rowsExamined != null ? !rowsExamined.equals(that.rowsExamined) : that.rowsExamined != null) return false;
        if (rowsAffected != null ? !rowsAffected.equals(that.rowsAffected) : that.rowsAffected != null) return false;
        if (fullScans != null ? !fullScans.equals(that.fullScans) : that.fullScans != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = host != null ? host.hashCode() : 0;
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (totalLatency != null ? totalLatency.hashCode() : 0);
        result = 31 * result + (maxLatency != null ? maxLatency.hashCode() : 0);
        result = 31 * result + (lockLatency != null ? lockLatency.hashCode() : 0);
        result = 31 * result + (cpuLatency != null ? cpuLatency.hashCode() : 0);
        result = 31 * result + (rowsSent != null ? rowsSent.hashCode() : 0);
        result = 31 * result + (rowsExamined != null ? rowsExamined.hashCode() : 0);
        result = 31 * result + (rowsAffected != null ? rowsAffected.hashCode() : 0);
        result = 31 * result + (fullScans != null ? fullScans.hashCode() : 0);
        return result;
    }
}
